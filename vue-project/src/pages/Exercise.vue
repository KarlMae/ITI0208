<template>
    <div id="exercise-view">
        <Header></Header>
        <div id="exercise-section" class="exercise-section">
            <p id="name" class="name">{{ exercise.name }}</p>
            <p id="reps" class="info">Repetitions: {{ exercise.repetitions }}</p>
            <p id="sets" class="info">Sets: {{ exercise.sets }}</p>

          <div class="navigation">
            <button v-on:click="nextExercise">
              <p> &lt </p>
            </button>
            <button v-on:click="previousExercise">
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
        data: function() {
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
            console.log(this.workout.exercises.length);
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

<style>

    body {
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;

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
        padding: 5rem;
    }

    .navigation {
      display: flex;
      flex-direction: row;
    }
</style>
