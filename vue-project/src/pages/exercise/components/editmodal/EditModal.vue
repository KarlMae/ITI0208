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
                <button type="button" class="btn btn-secondary">{{ set }}</button>
              </template>
            </div>
          </div>

          <div class="line">
            <button class="btn amount-btn">-</button>
            <div>
              <p class="title">Repetitions</p>
              <p>{{ this.exercise.repetitions }}</p>
            </div>
            <button class="btn amount-btn">+</button>
          </div>

          <div class="line">
            <button class="btn amount-btn">-</button>
            <div>
              <p class="title">Weight</p>
              <p>{{ this.exercise.amount + this.exercise.unit }}</p>
            </div>
            <button class="btn amount-btn">+</button>
          </div>

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
  export default {
    name: "EditModal",
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
        sets: 4,
        repetitions: 4,
        amount: 10,
        unit: 'kg'
      }
    },
    methods: {
      closeModal() {
        this.$emit('close');
      },
      saveChanges() {
        // Send POST request
        this.$emit('close');
      }
    }
  }
</script>

<style scoped>
  .modal {
    display: block;
    padding-top: 2rem;
  }

  .title {
    font-size: 1.5rem;
    font-weight: bolder;
    padding-top: 1rem;
    margin-bottom: 0.5rem;
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

  .line {
    display: flex;
    justify-content: space-between;
  }

  .amount-btn {
    font-size: 2rem;
  }
</style>