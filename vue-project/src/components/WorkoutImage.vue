<template>
  <div v-on:click="selectWorkout" id="workout" class="image-wrapper">
    <img v-bind:src="displaySource" alt="workout cover">
    <div class="workout-info">
      <h3>{{ name }}</h3>
    </div>
  </div>
</template>

<script>
  export default {
    name: "WorkoutImage",
    props: {
      name: String,
      id: Number,
      src: String,
      route: {
        type: String,
        default: '/workout/?id='
      }
    },
    methods: {
      selectWorkout() {
        if (this.id) {
          this.$router.push('/workout/?id=' + this.id)
        }
      }
    },
    computed: {
      displaySource() {
        return this.src || 'https://dailyburn.com/life/wp-content/uploads/2016/06/Beach-HIIT-Workouts.jpg'
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
    text-align: left;
    width: 100%;

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