<template>
  <div class="img-wrapper">
    <img :src="image" class="image">
    <img src="../../../../assets/icons/info.svg" class="info-svg">
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
    height: 15rem;
    overflow: auto;
    position: relative;
    margin: auto;
    border-radius: 1rem;
  }

  .image {
    max-width: 100%;
    height: auto;
  }

  .info-svg {
    position: absolute;
    right: 1rem;
    bottom: 1rem;
  }

</style>