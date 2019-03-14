<template>
  <div id="app">
    <Header></Header>
    <div id="workouts" class="workouts">
      <Workout v-for="workout in workouts"
               :id="workout.id"
               :name="workout.name"
               :description="workout.description"
      ></Workout>
    </div>
  </div>
</template>

<script>

  import Header from '../components/Header'
  import Workout from '../components/Workout'

  export default {
    name: 'app',
    components: {
      Header,
      Workout,
    },
    data() {
      return {
        workouts: Array,
        error: Array
      }
    },
    async mounted() {
      this.axios
        .get('http://192.168.99.100:8090/fetchAll')
        .then(response => {
          this.workouts = response.data
        })
        .catch(error => {
          this.error = error;
        })
    }
  }

</script>

<style scoped>
  body {
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
  }

  #app {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }

  .workouts {
    display: flex;
    flex-direction: column;
    width: 100%;
  }
</style>
