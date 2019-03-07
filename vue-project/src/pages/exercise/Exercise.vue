<template>
  <div id="exercise-view">
    <button
        v-if="exerciseIndex > 0"
        v-on:click="previousExercise"
        class="nav-button"
        style="left: 0.5rem">
      &lt;
    </button>

    <div class="exercise-section">
      <Header />
      <ExerciseImage />

      <div class="content">
        <div class="info">
          <p id="name" class="name">{{ exercise.name }}</p>
          <p id="reps">Repetitions: {{ exercise.repetitions }}</p>
          <p id="sets">Sets: {{ exercise.sets }}</p>
          <p id="weight">Weight: {{ exercise.sets }}</p>
        </div>
      </div>

      <Timer />
    </div>

    <button
        v-if="exerciseIndex < workout.exercises.length - 1"
        v-on:click="nextExercise" class="nav-button" style="right: 0.5rem">
      &gt;
    </button>
  </div>
</template>

<script>

  import Timer from './Timer'
  import Header from './Header'
  import ExerciseImage from './ExerciseImage';

  export default {
    name: 'exercise-view',
    components: {
      ExerciseImage,
      Header,
      Timer
    },
    data: function () {
      return {
        exerciseIndex: 0
      };
    },
    props: {
      workout: Object
    },
    computed: {
      exercise() {
        return this.workout.exercises[this.exerciseIndex];
      },
    },
    methods: {
      nextExercise() {
        if (this.exerciseIndex < this.workout.exercises.length - 1) {
          this.exerciseIndex += 1;
        }
      },
      previousExercise() {
        if (this.exerciseIndex > 0) {
          this.exerciseIndex -= 1;
        }
      }
    }
  }
</script>

<style scoped>

  #exercise-view {
    height: 100%;
  }

  .name {
    font-size: 2rem;
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

  .info {
  }

  p {
    margin: 0;
  }

  .content {
    padding-top: 1.5rem;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin: auto;
    width: 90%;
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


</style>
