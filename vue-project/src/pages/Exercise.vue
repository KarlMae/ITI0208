<template>
  <div id="exercise-view">
    <Header></Header>
    <div id="exercise-section" class="exercise-section">

      <div class="info">
        <p id="name" class="name">{{ exercise.name }}</p>
        <p id="reps">Repetitions: {{ exercise.repetitions }}</p>
        <p id="sets">Sets: {{ exercise.sets }}</p>
      </div>

      <div class="navigation">
        <button v-on:click="previousExercise">
          &lt
        </button>
        <button v-on:click="nextExercise">
          &gt
        </button>
      </div>
    </div>
    <Timer></Timer>
  </div>
</template>

<script>

  import Header from '../components/Header'
  import Timer from '../components/Timer'

  export default {
    name: 'exercise-view',
    components: {
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
  .exercise-view {
    margin: 0;
    padding: 0;
    background-color: #582841;
    color: beige;
    height: 100%;
  }

  button {
    background-color: #EF4648;
    border: 1px;
    border-radius: 0;
    width: 5rem;
    height: 5rem;
    font-size: 3rem;

  }

  #exercise-view {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
  }

  .name {
    font-size: 2rem;
  }

  .exercise-section {
    text-align: left;
    padding: 1rem;
  }

  .info {
    padding: 3rem;
  }

  .navigation {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
</style>
