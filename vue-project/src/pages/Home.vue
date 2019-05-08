<template>
  <div>
    <div id="workouts" class="workouts">
      <WorkoutImage v-for="workout in workouts"
                    :src="workout.image"
                    :key="workout.id"
                    :id="workout.id"
                    :name="workout.name"
      />
    </div>
  </div>
</template>

<script>
  import WorkoutImage from '../components/WorkoutImage'

  export default {
    name: 'Home',
    components: {
      WorkoutImage
    },
    data() {
      return {
        workouts: Array,
        isError: Array
      }
    },
    mounted() {
      this.axios
        .get(process.env.VUE_APP_BACKEND_IP + '/workout/fetchAll')
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
  #workout {
    margin-bottom: 2rem;
  }
</style>
