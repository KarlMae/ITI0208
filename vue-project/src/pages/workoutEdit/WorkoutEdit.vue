<template>
  <div class="workout-edit">
    <validated-field
        label="Workout name"
        :default-value="workout.name"
        :validation-errors="$v.workout.name"
        :has-been-used="isSavePressed"
        @valueChanged="(value) => workout.name = value"
    />
    <image-selector-button
        @clicked="imageSelectorModalOpen = true"
        :image="workout.image"
    />
    <div role="tablist">
      <template v-for="(group, groupIndex) in categories">
        <div v-bind:key="group">
          <b-button block href="#" v-b-toggle="'accordion-' + groupIndex">{{ group }}</b-button>
          <b-collapse :id="'accordion-' + groupIndex" accordion="my-accordion" role="tabpanel">
            <b-card-body>

              <template v-for="(exercise, exerciseIndex) in exercisesByCategory(group)">
                <exercise-component
                    v-if="exercise"
                    v-bind:key="exercise.id"
                    :exercise="exercise"
                    :field-validators="$v.workout.exerciseGroups.$each[exerciseIndex].name"
                    :is-save-pressed="isSavePressed"
                    @removeExercise="removeExercise"
                    @addSet="addSet"
                    @removeSet="(id) => removeSet(exercise, id)"
                />
              </template>

              <button class="btn exercise-btn" type="button" v-on:click="addExercise(group)">Add exercise</button>

            </b-card-body>
          </b-collapse>
        </div>
      </template>
    </div>

    <image-selector
        v-if="imageSelectorModalOpen"
        @selectImage="(src) => workout.image = src"
        @close="imageSelectorModalOpen = false"
    />

    <div class="absolute">
      <div class="footer-buttons">
        <button class="btn save-btn" type="button" v-on:click="save">Save</button>
      </div>
    </div>
  </div>
</template>

<script>
  import ExerciseComponent from './ExerciseComponent';
  import ImageSelector from './ImageSelector';
  import ImageSelectorButton from './ImageSelectorButton';
  import ValidatedField from '../../components/ValidatedField';
  import { sendRequest } from './service'
  import { minLength, required } from 'vuelidate/lib/validators'


  export default {
    name: 'WorkoutEdit',
    components: {
      ImageSelector,
      ImageSelectorButton,
      ValidatedField,
      ExerciseComponent,
    },
    props: ['editWorkout'],
    data() {
      return {
        workout: {
          exerciseGroups: [],
          name: '',
          userId: this.$store.getters.getUserId
        },
        categories: ['Warm-up', 'Main exercises', 'Cool-down'],
        validationErrors: false,
        isSavePressed: false,
        imageSelectorModalOpen: false,
        uniqueId: 0,
      }
    },
    mounted() {
      if (this.editWorkout) {
        this.workout = this.editWorkout;
        this.workout.exerciseGroups.forEach((group) => {
            if (group.sets[0].weight !== null) {
              group.weighed = true;
            }

            if (group.sets[0].duration !== null) {
              group.timed = true;
            }

          }
        )
      }
    },
    validations: {
      workout: {
        name: {
          minLength: minLength(5),
          required
        },
        exerciseGroups: {
          $each: {
            name: {
              minLength: minLength(4),
              required
            }
          },
          required
        }
      }
    },
    methods: {
      addExercise(category) {
        this.workout.exerciseGroups.push(
          {
            name: '',
            category: category,
            sets: [],
            weighed: false,
            timed: false,
            id: this.uniqueId
          }
        );

        this.uniqueId += 1;
      },
      addSet(exercise) {
        exercise.sets.push({
          repetitions: 1,
          weight: 0,
          duration: 0,
          id: this.uniqueId
        });

        this.uniqueId += 1;
      },
      removeExercise(id) {
        this.workout.exerciseGroups = this.workout.exerciseGroups.filter(group => group.id !== id);
      },
      removeSet(exercise, id) {
        exercise.sets = exercise.sets.filter(set => set.id !== id)
      },
      exercisesByCategory(group) {
        return this.workout.exerciseGroups.filter(exercise => {
          return exercise.category === group
        });
      },
      async save() {
        if (this.validate()) {
          return;
        }
        this.cleanData();

        let workoutId = await sendRequest(this.workout, this.$route.path);

        this.$router.push('/workout/?id=' + workoutId);
      },
      cleanData() {
        this.workout.exerciseGroups.forEach(group => {
          if (!group.weighed) {
            group.sets.forEach(set => delete set.weight);
          }

          if (!group.timed) {
            group.sets.forEach(set => delete set.duration);
          }

          let setIndex = 1;
          group.sets.forEach(set => {
            set.name = group.name;
            set.category = group.category;
            set.set = setIndex;
            setIndex += 1;
          });
        })
      },
      validate() {
        if (this.workout.exerciseGroups.length === 0) {
          alert('Workout needs to have at least one exercise with one set');
          return true;
        }
        this.isSavePressed = true;

        this.$v.$touch();
        return !!this.$v.$invalid;
      },
    }
  }
</script>

<style lang="scss" scoped>
  @import "../../assets/colors";

  p {
    margin: 0;
  }

  a, button {
    border-radius: 0;
    border-color: transparent;
  }

  .workout-edit {
    background-color: #F0F0F0;
    max-height: calc(100% - 7rem);
    overflow: scroll;
  }

  .exercise {
    background-color: #00000010;
  }

  .set {
    background-color: #EF464880;
    margin-bottom: 1rem;
    display: flex;
    flex-direction: column;
    padding: 1rem;
    position: relative;
  }

  .btn, .btn:hover, .btn:focus {
    margin: 1rem 0;
    background-color: $primary-main !important;
    color: #f0f0f0 !important;
  }

  .exercise-btn {
    width: 100%;
  }

  .set-buttons {
    display: flex;
    justify-content: space-around;
  }

  .card-body {
    padding: 0;
  }

  .footer-buttons {
    width: 100vw;
    position: relative;
    left: 50%;
    right: 50%;
    margin-left: -50vw;
    margin-right: -50vw;
    bottom: -1.5rem;
    background-color: #dfdfdf;
    -webkit-box-shadow: inset 0px 10px 5px -10px rgba(0, 0, 0, 0.75);
    -moz-box-shadow: inset 0px 10px 5px -10px rgba(0, 0, 0, 0.75);
    box-shadow: inset 0px 10px 5px -10px rgba(0, 0, 0, 0.75);
  }

  .sticky {
    position: sticky;
  }

  .absolute {
    position: absolute;
    left: 50%;
    bottom: 1.5rem;
  }

  .transparent-button {
    background-color: transparent;
  }

  .header {
    display: flex;
    justify-content: space-between;
    align-items: baseline;
  }

  .text-input {
    display: flex;
    flex-direction: column;
  }

  .buttons {
    display: flex;
    justify-content: space-evenly;
  }

  .close-button {
    position: absolute;
    top: 1rem;
    right: 2rem;
  }

  .save-btn {
    width: 10rem;
  }


</style>
