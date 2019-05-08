<template>
  <div class="img-wrapper">
    <img :src="image" class="image">
  </div>
</template>

<script>
  export default {
    name: "ExerciseImage",
    computed: {
      image() {
        return this.$store.state.workoutImage || 'https://dailyburn.com/life/wp-content/uploads/2016/06/Beach-HIIT-Workouts.jpg';
      }
    },
  }
</script>

<style scoped>

  .img-wrapper {
    overflow: auto;
    margin: auto;
    border-radius: 1rem;
  }

  .image {
    max-width: 100%;
    height: auto;
  }

</style>