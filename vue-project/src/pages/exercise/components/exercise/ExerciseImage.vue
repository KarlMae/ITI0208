<template>
  <div class="img-wrapper">
    <img src="../../../../assets/1.jpg" class="image">
    <img src="../../../../assets/icons/info.svg" class="info-svg">
  </div>
</template>

<script>
  export default {
    name: "ExerciseImage"
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