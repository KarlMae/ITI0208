<template>
  <div id="exercise-view">
    <button
        v-if="exerciseStore.previousExercisePresent()"
        v-on:click="previousExercise"
        class="nav-button"
        style="left: 0.5rem">
      &lt;
    </button>

    <div class="exercise-section">
      <Header />
      <ExerciseImage />
      <Exercise />
      <Timer />
    </div>

    <button
        v-if="exerciseStore.nextExercisePresent()"
        v-on:click="nextExercise()" class="nav-button" style="right: 0.5rem">
      &gt;
    </button>
  </div>
</template>

<script>

  import Timer from './components/Timer'
  import Header from './components/Header'
  import ExerciseImage from './components/ExerciseImage';
  import Exercise from './components/Exercise';
  import { exerciseStore } from './ExerciseStore.js';
  import * as Cookies from 'js-cookie';


  export default {
    name: 'exercise-view',
    components: {
      Exercise,
      ExerciseImage,
      Header,
      Timer
    },
    data() {
      return {
        exerciseStore: exerciseStore
      };
    },
    created() {
      this.exerciseStore.setWorkout(JSON.parse(Cookies.get('state')));
    },
    methods: {
      nextExercise() {
        this.exerciseStore.nextExercise();
      },
      previousExercise() {
        this.exerciseStore.previousExercise();
      }
    }
  }
</script>

<style scoped>

  #exercise-view {
    height: 100%;
  }

  .exercise-section {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    background-color: #F0F0F0;
    height: 100%;
    width: 100%;
    text-align: left;
    padding: 2rem;
  }

  .nav-button {
    border: 0;
    border-radius: 0;
    font-size: 2rem;
    font-weight: bold;
    align-self: center;
    background-color: transparent;
    position: absolute;
    top: 50%;
  }

  .content-slide-enter-active {
    animation: bounce-in .5s;
  }

  .content-slide-leave-active {
    animation: bounce-in .5s reverse;
  }

</style>
