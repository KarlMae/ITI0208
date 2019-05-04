<template>

  <div @click="selectWorkout" id="workout" class="workout">
    <WorkoutImage
      :id="id"
      :name="name"
      :description="description"
    />
  </div>

</template>

<script>

  import Vue from 'vue'
  import VueRouter from 'vue-router';
  import WorkoutImage from '../components/WorkoutImage';
  import routeTo from '../functions'

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
    },
    methods: {
      routeTo,
      selectWorkout() {
        this.routeTo('/workout/?id=' + this.id)
      }
    }
  }

</script>

<style>

  .workout {
    text-align: left;
    width: 100%;
    padding: 1rem;
  }

  ul {
    list-style-type: none;
  }

</style>
