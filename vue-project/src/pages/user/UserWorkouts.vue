<template>
  <div>
    <WorkoutImage v-for="workout in workouts"
                  :src="workout.image"
                  :key="workout.id"
                  :id="workout.id"
                  :name="workout.name"
    />
  </div>
</template>

<script>

  import WorkoutImage from "../../components/WorkoutImage";

  export default {
    name: 'UserWorkouts',
    components: {
      WorkoutImage
    },
    data() {
      return {
        id: this.$store.getters.getUserId,
        workouts: Array,
        error: null
      }
    },
    mounted() {
      this.axios.get(`${process.env.VUE_APP_BACKEND_IP}/user/fetchAll/${this.id}`)
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

</style>
