<template>
  <div class="workout-edit">
    <ErrorModal
        v-if="isModalVisible"
        message="error"/>

    <Header/>
    <div class="text-input">
      <label for="workoutName">Workout name</label>
      <input id="workoutName" v-model="workout.name">
    </div>

    <div class="text-input">
      <label for="workoutDescription">Workout description</label>
      <input id="workoutDescription" v-model="workout.description">
    </div>


    <div role="tablist">
      <template v-for="(group, index) in groups">
        <b-card no-body class="mb-1">
          <b-card-header header-tag="header" class="p-1" role="tab">
            <b-button block href="#" v-b-toggle="'accordion-' + index">{{group}}</b-button>
          </b-card-header>

          <b-collapse :id="'accordion-' + index" accordion="my-accordion" role="tabpanel">
            <b-card-body>

              <template v-for="exercise in exercisesByGroup(group)">
                <div class="exercise">

                  <div class="text-input">
                    <label for="exerciseName">Exercise name</label>
                    <input id="exerciseName" v-model="exercise.name">
                  </div>

                  <div class="midagi">
                    <template v-for="set in exercise.sets">
                      <div class="set">
                        <label for="repetitions">Repetitions</label>

                        <div class="set-parameter">
                          <button @click="() => {set.repetitions = parseInt(set.repetitions) - 1}"
                                  class="btn amount-btn">-
                          </button>
                          <input class="set-parameter" v-model="set.repetitions" id="repetitions">
                          <button @click="() => {set.repetitions = parseInt(set.repetitions) + 1}"
                                  class="btn amount-btn">+
                          </button>

                        </div>
                        <label for="weight">Weight</label>
                        <div class="set-parameter">
                          <button @click="() => {set.weight = parseInt(set.weight) - 1}" class="btn amount-btn">
                            -
                          </button>
                          <input type="number" class="set-parameter" v-model="set.weight" id="weight">
                          <button @click="() => {set.weight = parseInt(set.weight) + 1}" class="btn amount-btn">
                            +
                          </button>
                        </div>


                        <label for="duration">Duration</label>
                        <div class="set-parameter">
                          <button @click="() => {set.duration = parseInt(set.duration) - 1}" class="btn amount-btn">
                            -
                          </button>
                          <input class="set-parameter" v-model="set.duration" id="duration">

                          <button @click="() => {set.duration = parseInt(set.duration) + 1}" class="btn amount-btn">
                            +
                          </button>
                        </div>
                      </div>
                    </template>

                    <div class="set-buttons">
                      <button class="btn" type="button" @click="addSet(exercise)">Add set</button>
                      <button class="btn" type="button" @click="removeSet(exercise)">Remove set</button>
                    </div>
                    <button class="btn exercise-btn" type="button" @click="removeExercise(exercise.index)">Remove
                      exercise
                    </button>
                  </div>

                </div>
              </template>

              <button class="btn exercise-btn" type="button" @click="addNewExercise(group)">Add exercise</button>

            </b-card-body>
          </b-collapse>

        </b-card>
      </template>
    </div>

    <button class="btn" type="button" @click="save">Save</button>
  </div>
</template>

<script>
  import Header from '../../components/Header'
  import ErrorModal from './ErrorModal'
  import axios from 'axios'
  import routeTo from '../../functions'

  export default {
    name: 'WorkoutEdit',
    components: {
      Header,
      ErrorModal
    },
    data() {
      return {
        groups: ['Warm-up', 'Main exercises', 'Cool-down'],
        exerciseCount: 0,
        workout: this.editWorkout ||
        {
          name: '',
          exerciseGroups: [],
        },
        isModalVisible: false
      }
    },
    props: ['editWorkout'],
    methods: {
      routeTo,
      addNewExercise(category) {
        this.workout.exerciseGroups.push(
          {
            setIndex: 1,
            name: '',
            category: category,
            sets: [],
            index: this.exerciseCount
          }
        );
        this.exerciseCount += 1;
      },
      addSet(exercise) {
        exercise.sets.push({
          set: exercise.setIndex,
          name: exercise.name,
          category: exercise.category,
          duration: 0,
          repetitions: 0,
          weight: 0
        });

        exercise.setIndex += 1;
      },
      removeSet(exercise) {
        exercise.sets.splice(-1, 1);
        exercise.setIndex -= 1;
      },
      async save() {
        let workoutId;

        await axios.post(this.getUrl(), this.workout)
          .then(function (response) {
            workoutId = response.data.id;
          })
          .catch(e => {
            this.errors.push(e)
          });

        this.routeTo('/workout/?id=' + workoutId);
      },
      removeExercise(index) {
        for (let i = this.workout.exerciseGroups.length - 1; i >= 0; i--) {
          if (this.workout.exerciseGroups[i].index === index) {
            this.workout.exerciseGroups.splice(i, 1);
          }
        }
      },
      exercisesByGroup(group) {
        return this.workout.exerciseGroups.filter(exercise => {
          return exercise.category === group
        });
      },
      getUrl() {
        if (this.$route.path === '/workoutEdit') {
          return process.env.VUE_APP_BACKEND_IP + '/updateWorkout'
        } else {
          return process.env.VUE_APP_BACKEND_IP + '/insert'
        }
      }
    },
  }
</script>

<style lang="scss" scoped>
  @import "../../assets/colors";

  .text-input {
    overflow: hidden;

    input {
      margin-bottom: 1rem;
    }

    label {
      margin-bottom: 0;
      text-align: left;
      width: 100%;
    }
  }

  input {
    width: 100%;
  }

  p {
    margin: 0;
  }

  .workout-edit {
    background-color: #F0F0F0;
    padding: 1rem;
  }

  .exercise {
    background-color: #00000050;
    padding: 1rem;
    margin-bottom: 1rem;
    border-radius: 0.3rem;
  }

  .set {
    background-color: #EF464880;
    margin-bottom: 1rem;
    display: flex;
    flex-direction: column;
    padding: 0.5rem;
    border-radius: 0.3rem;
  }

  .btn {
    margin: 1rem 0;
    background-color: $light;
    min-width: 10rem;
  }

  .btn-info {
    background-color: $secondary-main;
    border-color: $secondary-shade;
    box-shadow: transparent;
  }

  .btn-info:hover {
    background-color: $secondary-shade;
    border-color: $secondary-shade;
    box-shadow: transparent;
  }

  .btn-info:active {
    background-color: $secondary-shade;
    border-color: $secondary-shade;
    box-shadow: transparent;
  }

  .exercise-btn {
    width: 23.5rem;
    height: 4rem;
    background-color: $secondary-shade;
  }

  .set-buttons {
    display: flex;
    justify-content: space-around;
  }

  .group {
    width: 100%;
    background-color: #00000050;
    margin-top: 1rem;
    padding-top: 1rem;
  }

  .set-parameter {
    display: flex;
    justify-content: space-around;

    .btn {
      min-width: 3rem;
      min-height: 3rem;
    }

    label {
      text-align: center;
    }
    input {
      margin: 1rem;
      display: inline-block;
      text-align: center;
      background-color: #ffffff20;
      border: transparent;
      width: 3rem;
      height: 3rem;
    }
  }
</style>
