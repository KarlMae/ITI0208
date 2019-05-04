<template>
  <div class="modal" @click='closeModal'>
    <div class="modal-dialog" @click.stop='() => {}'>
      <div class="modal-content">
        <div class="modal-header">
          <button @click="closeModal" class="close">
            <span>&lt;</span>
          </button>
          <h5 class="modal-title">{{ this.exercise.name }}</h5>
        </div>

        <div class="modal-body">
          <div>
            <p class="title">Set</p>
            <SetSelector
                :set-count="exercise.sets.length"
                :set="selectedSet.set"
                name="edit"
                @selectSet="selectSet"
            />
          </div>

          <EditModalRow
              v-if="selectedSet.repetitions !== 0"
              name="repetitions"
              :repetitions="selectedSet.repetitions"
              @add="add"
              @subtract="subtract"
          />

          <EditModalRow
              v-if="selectedSet.duration !== 0"
              name="duration"
              :duration="selectedSet.duration"
              @add="add"
              @subtract="subtract"
          />

          <EditModalRow
              v-if="selectedSet.weight !== 0"
              name="weight"
              :weight="selectedSet.weight"
              @add="add"
              @subtract="subtract"
          />
        </div>
        <button @click="saveChanges" class="btn btn-primary save-button">
          Save changes
        </button>
      </div>
    </div>
  </div>
</template>

<script>
  import EditModalRow from './EditModalRow'
  import axios from 'axios';
  import SetSelector from '../setSelector/SetSelector';

  export default {
    name: "EditModal",
    components: {
      SetSelector,
      EditModalRow
    },
    data() {
      return {
        exercise: this.$store.getters.currentExercise
      }
    },
    mounted() {
      axios.get(process.env.VUE_APP_BACKEND_IP + '/fetchGroup/' + this.$store.getters.currentExercise.groupId)
        .then(response => {
          this.exercise = response.data;
        })
        .catch(e => {
          this.errors.push(e)
        });
    },
    computed: {
      selectedSet() {
        return this.$store.getters.currentSet;
      },
      selectedExercise() {
        return this.$store.getters.currentExercise;
      }
    },
    methods: {
      async saveChanges() {
        await axios.post(process.env.VUE_APP_BACKEND_IP + '/updateExercise', this.selectedExercise)
          .catch(e => {
            this.errors.push(e)
          });

        this.$store.commit('updateCurrentExercise', this.selectedExercise);
        this.$emit('close')
      },
      selectSet(setNumber) {
        this.$store.commit('selectSet', setNumber);
      },
      add(element) {
        this.selectedSet[element] = this.selectedSet[element] + 1
      },
      subtract(element) {
        this.selectedSet[element] = this.selectedSet[element] - 1
      },
      closeModal() {
        this.$store.commit('updateCurrentExercise', this.exercise);
        this.$emit('close')
      },
    }
  }
</script>

<style lang="scss" scoped>
  @import '../../../../assets/colors';
  .modal {
    display: block;
    padding-top: 2rem;
  }

  .modal-header .close {
    padding: 0;
    margin: 0;
  }

  .modal-title {
    margin: auto;
  }

  .modal-body {
    padding: 0 1rem 1rem 1rem;
  }

  .save-button {
    padding: 1rem;
    border-radius: 0;
    background-color: $primary-main;
    border: solid 1px $primary-shade;
  }

  .modal {
    background-color: #00000070;
  }

  .title {
    font-size: 1.5rem;
    font-weight: bolder;
    padding-top: 1rem;
    margin-bottom: 0.5rem;
  }
</style>
