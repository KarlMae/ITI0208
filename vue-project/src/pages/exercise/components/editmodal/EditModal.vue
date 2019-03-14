<template>
  <div class="modal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button
              v-on:click="closeModal"
              class="close"
          >
            <span>&lt;</span>
          </button>
          <h5 class="modal-title">{{ this.exercise.name }}</h5>
        </div>
        <div class="modal-body">

          <div>
            <p class="title">Set</p>
            <div class="btn-group" role="group">
              <template v-for="set in this.exercise.sets">
                <button
                    v-on:click="changeSet(set.setNumber - 1)"
                    :key="set.setNumber"
                    type="button"
                    class="btn btn-secondary"
                >
                  {{ set.setNumber }}
                </button>
              </template>
            </div>
          </div>

          <EditModalRow
              name="repetitions"
              :amount="selectedSet.repetitions"
              v-on:add="add"
              v-on:subtract="subtract"
          />

          <EditModalRow
              name="amount"
              :amount="selectedSet.amount"
              v-on:add="add"
              v-on:subtract="subtract"
          />
        </div>
        <button
            v-on:click="saveChanges"
            class="btn btn-primary save-button">Save changes
        </button>
      </div>
    </div>
  </div>
</template>

<script>
  import EditModalRow from './EditModalRow'

  export default {
    name: "EditModal",
    components: {
      EditModalRow
    },
    data() {
      return {
        selectedSet: {}
      }
    },
    props: {
      exerciseId: {
        type: Number,
        required: true
      }
    },
    created() {
      // Send GET request
      this.exercise = {
        name: 'Tuck planche',
        unit: 'kg',
        sets: [
          {
            setNumber: 1,
            repetitions: 10,
            amount: 11
          },
          {
            setNumber: 2,
            repetitions: 20,
            amount: 21,
          },
          {
            setNumber: 3,
            repetitions: 30,
            amount: 31,
          },
          {
            setNumber: 4,
            repetitions: 40,
            amount: 41,
          }
        ],
      };

      this.selectedSet = this.exercise.sets[0]
    },
    methods: {
      closeModal() {
        this.$emit('close');
      },
      saveChanges() {
        // Send POST request
        this.$emit('close');
      },
      changeSet(setNumber) {
        this.selectedSet = this.exercise.sets[setNumber];
      },
      add(element) {
        this.selectedSet[element] = this.selectedSet[element] + 1
      },
      subtract(element) {
        this.selectedSet[element] = this.selectedSet[element] - 1;
      }
    },
  }
</script>

<style scoped>
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

  .modal {
    background-color: #30000090;
  }

  .save-button {
    padding: 1rem;
  }

  .title {
    font-size: 1.5rem;
    font-weight: bolder;
    padding-top: 1rem;
    margin-bottom: 0.5rem;
  }
</style>