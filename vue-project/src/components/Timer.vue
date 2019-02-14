<template>
  <div id="timer" class="timer">
    <img class="reset" src="../assets/menu-logo.svg">
    <p class="timer-text">Timer: {{ time }}</p>
    <img class="start-pause" src="../assets/menu-logo.svg">
  </div>
</template>

<script>
  export default {
    name: "Timer",
    computed: {
      time() {
        return 5;
      }
    }
  }
</script>

<style scoped>
  .timer-text {
    font-size: 1.5rem;
  }
  
  .timer {
    min-height: 4rem;
    width: 100%;
    background-color: #CC2A49;
    padding: 1rem;
    display: flex;
    position: absolute;
    bottom: 0;
    justify-content: center;
  }

  .start-pause {
    align-self: end;
  }
</style>