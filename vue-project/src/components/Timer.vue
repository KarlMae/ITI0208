<template>
  <div id="timer" class="timer">
    <p class="timer-text">{{ time }}</p>
  </div>
</template>

<script>
  export default {
    name: "Timer",
    computed: {
      time() {
        return '00:00';
      }
    }
  }
</script>

<style scoped>
  .timer-text {
    font-size: 2rem;
    color: aliceblue;
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