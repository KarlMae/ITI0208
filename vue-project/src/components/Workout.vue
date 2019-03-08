<template>
  <div id="workout" class="workout">
    <WorkoutImage
            :name="name"
            :description="description"
    />
    <div id="exercises" class="exercises">
      <ul v-for="exercise in exercises" :key="exercise.id">
        <li>{{ exercise.name }}</li>
      </ul>
    </div>
    <button v-on:click="selectWorkout">Select</button>
  </div>
</template>

<script>

  import Vue from 'vue'
  import VueRouter from 'vue-router';
  import WorkoutImage from '../components/WorkoutImage';

  Vue.use(VueRouter);

  export default {
    name: 'workout',
    components: {
      WorkoutImage
    },
    props: {
      id: Number,
      name: String,
      description: String,
      exercises: Array
    },
    methods: {
      selectWorkout() {
        this.$router.push('/workout/?id=' + this.id)
      }
    }
  }

</script>

<style>

  .workout {
    border-bottom: solid 2px #582841;
    text-align: left;
    width: 100%;
    padding: 0.5rem;
  }

  .name {
    font-size: 1.5rem;
    color: black;
    font-weight: bolder;
  }

  button {
    color: #494949;
    text-transform: uppercase;
    background: #ffffff;
    padding: 5px;
    margin: 10px;
    border: 2px solid #494949;
    border-radius: 6px;
    display: inline-block;
    font-size: large;
  }

  .exercises {
    display: flex;
    flex-direction: column;
    text-align: left;
    font-size: 0.8rem;
  }

  ul {
    list-style-type: none;
  }

</style>