<template>
  <div>
    {{ userWorkouts }}
  </div>
</template>

<script>

  export default {
    name: 'UserWorkouts',
    components: {
    },
    data() {
      return {
        userWorkouts: String,
        error: null
      }
    },
    mounted() {
      this.axios.get(process.env.VUE_APP_BACKEND_IP + '/user/fetchAllWorkouts')
        .then(response => {
          this.userWorkouts = response.data
        })
        .catch(error => {
          this.error = error;
        })
    }
  }
</script>

<style scoped>

</style>
