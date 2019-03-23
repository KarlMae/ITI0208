<template>
  <div class="image-wrapper">
    <img :src="imgurl" alt="workout cover">
    <div class="workout-info">
      <h3>{{ name }}</h3>
      <p>{{ description }}</p>
    </div>
  </div>
</template>

<script>
  export default {
    name: "WorkoutImage",
    props: {
      name: String,
      description: String,
      id: Number
    },
    data() {
      return {
        imgurl: require("../assets/" + this.id + ".jpg")
      }
    }
  }
</script>

<style scoped>
  .image-wrapper {
    height: auto;
    overflow: auto;
    position: relative;
    margin: auto;
    border-radius: 1rem;
  }

  .image-wrapper::after {
    display: block;
    position: relative;
    background-image: linear-gradient(rgba(255, 255, 255, 0) 0, #000000 100%);
    margin-top: -15rem;
    height: 15rem;
    width: 100%;
    content: '';
    border-radius: 1rem;
  }

  img {
    width: 100%;
    height: 15rem;
  }

  .workout-info {
    position: absolute;
    left: 1rem;
    bottom: 0.3rem;
    font-weight: bold;
    color: white;
    z-index: 1;
  }
</style>