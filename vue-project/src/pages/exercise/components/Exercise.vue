<template>

  <div class="transition-wrapper">
    <transition name="slide-fade">
      <div :key="exercise.name" class="exercise">
        <h2 id="name">{{ exercise.name }}</h2>
        <p id="reps">Repetitions: {{ exercise.repetitions }}</p>
        <p id="sets">Sets left: {{ exercise.set_nr }}</p>
        <p id="weight" v-if="exercise.weight">Weight: {{ exercise.weight }}</p>
      </div>
    </transition>
  </div>

</template>

<script>

  import { exerciseStore } from '../ExerciseStore';

  export default {
    name: "Exercise",
    data() {
      return {
        exerciseStore: exerciseStore,
        exercise: exerciseStore.getExercise()
      };
    },
    created() {
      this.exercise = this.exerciseStore.getExercise();
    },
    computed: {
      exerciseIndex() {
        return this.exerciseStore.state.exerciseIndex;
      }
    },
    watch: {
      exerciseIndex() {
        this.exercise = this.exerciseStore.getExercise();
      }
    }
  }

</script>

<style scoped>

  p {
    margin: 0;
  }

  .exercise {
    padding-top: 1.5rem;
    margin: auto;
    width: 90%;
  }

  .transition-wrapper {
    display: flex;
  }

  .slide-fade-enter-active {
    transition: all .5s cubic-bezier(0.5, 0.5, 0.5, 0.5);
  }
  .slide-fade-leave-active {
    transition: all revert;
  }
  .slide-fade-enter, .slide-fade-leave-to {
    transform: translateX(3rem);
    opacity: 0;
  }

</style>