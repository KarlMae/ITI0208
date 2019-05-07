<template>
  <div class="exercise">
    <div class="header">
      <button v-on:click="$emit('removeExercise', exercise.id)" class="transparent-button close-button" type="button">X</button>
      <validated-field
        label="Exercise name"
        :default-value="exercise.name"
        :validationErrors="fieldValidators"
        :has-been-used="isSavePressed"
        @valueChanged="(value) => exercise.name = value"
      />
    </div>
    <div class="buttons">
      <button type="button"
              class="btn"
              v-bind:class="{ 'active-btn': exercise.weighed }"
              v-on:click="() => exercise.weighed = !exercise.weighed"
      > Weighed </button>

      <button type="button"
              class="btn"
              v-bind:class="{ 'active-btn': exercise.timed }"
              v-on:click="() => exercise.timed = !exercise.timed"
      > Timed </button>
    </div>

    <template v-for="(set, index) in exercise.sets">
      <set-component
          v-bind:key="index"
          :set="set"
          :weighed="exercise.weighed"
          :timed="exercise.timed"
          @removeSet="(id) => $emit('removeSet', id)"
      />
    </template>

    <div class="set-buttons">
      <button class="exercise-btn" type="button" v-on:click="$emit('addSet', exercise)">Add set</button>
    </div>
  </div>
</template>

<script>
  import SetComponent from './SetComponent';
  import ValidatedField from '../../components/ValidatedField';

  export default {
    name: "ExerciseComponent",
    components: {ValidatedField, SetComponent},
    props: {
      exercise: {
        type: Object,
        required: true
      },
      fieldValidators: {
        type: Object,
        required: true
      },
      isSavePressed: {
        type: Boolean,
        default: false
      }
    },
    watch: {
      fieldValidators: {
        handler() {
        }
      },
      isSavePressed: {
        handler() {
        }
      }
    },
  }
</script>

<style scoped lang="scss">
  @import "../../assets/colors";

  button {
    border-color: transparent;
    border-radius: 0;
  }

  .header {
    position: relative;
  }

  .close-button {
    position: absolute;
    top: 0;
    right: 0.5rem;
  }

  .transparent-button {
    background-color: transparent;
  }

  .exercise-btn {
    width: 100%;
    color: #F0F0F0;
    background-color: #3a3a3a;
  }

  .exercise {
    width: 100%;
    background-color: #00000050;
    margin-top: 1rem;
    padding-top: 1rem;
  }

  .btn {
    margin: 1rem 0;
    background-color: #3a3a3a;
    color: #f0f0f0;
  }

  .btn:focus{
    margin: 1rem 0;
    background-color: #3a3a3a;
    color: #f0f0f0;
  }

  .buttons {
    display: flex;
    justify-content: space-evenly;
  }

  .title {
    vertical-align: sub;
  }

  .name-field {
    width: 75%;
  }

  .active-btn, .active-btn:focus {
    background-color: $primary-main;
    color: #f0f0f0;
  }
</style>