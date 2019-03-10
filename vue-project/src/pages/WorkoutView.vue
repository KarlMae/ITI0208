<template>
  <div>
    <Header></Header>
    <div class="workout-view">
      <ul v-if="workout">
        <h2>{{ workout.name }}</h2>
        <h5>{{ workout.description }}</h5>
        <h4>Exercises: </h4>

        <div v-for="exercise in workout.exercises" class="exercise">
          <h3>{{ exercise.name }}</h3>
          <p>Repetitions: {{ exercise.repetitions }}</p>
          <p>Sets: {{ exercise.sets }}</p>
        </div>
      </ul>
      <p v-else>Error on loading workout.</p>
    </div>
    <button
        v-on:click="startWorkout"
        v-if="workout.exercises"
    >
      Start
    </button>
  </div>
</template>


<script>
  import axios from 'axios';
  import Header from '../components/Header.vue';
  import Vue from 'vue'
  import VueRouter from 'vue-router';
  import { exerciseStore } from './exercise/ExerciseStore';

  Vue.use(VueRouter);

  export default {
    components: {
      Header
    },
    data() {
      return {
        workout: null,
        exerciseStore: exerciseStore
      }
    },
    methods: {
      startWorkout() {
        this.exerciseStore.setWorkout(this.workout);
        this.$router.push({ name: 'exercise' });
      }
    },
    created() {
      let workoutId = this.$route.query.id;
      axios.get('http://localhost:8090/fetchById/' + workoutId)
        .then(response => {
          this.workout = response.data;
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }

</script>

<style scoped>
  .workout-view h4 {
    text-align: left;
  }

  .exercise {
    border: 1px solid black;
    border-radius: 3px;
    display: flex;
    flex-direction: column;
    text-align: left;
    padding: 10px;
    margin-bottom: 10px;
  }

  .exercise p, h3 {
    margin: 5px;
  }

</style>