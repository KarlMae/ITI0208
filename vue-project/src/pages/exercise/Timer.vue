<template>
  <div class="timer container-fluid">
    <div class="col">
    </div>
    <div @click="toggleTimer">
      <p class="timer-text col">{{ minutes }}:{{ seconds }}</p>
    </div>
    <div class="col">
    <img
        @click="resetTimer"
        src="../../assets/icons/restart.svg"
        class="restart">
    </div>
  </div>
</template>

<script>
  export default {
    name: "Timer",
    data() {
      return {
        timer: null,
        totalTime: 0,
        timerActive: false,
      }
    },
    computed: {
      minutes: function() {
        const minutes = Math.floor(this.totalTime / 60);
        return this.padTime(minutes);
      },
      seconds: function() {
        const seconds = this.totalTime - (this.minutes * 60);
        return this.padTime(seconds);
      }
    },
    methods: {
      resetTimer() {
        clearInterval(this.timer);
        this.timerActive = false;
        this.timer = null;

        this.totalTime = 0;
      },
      toggleTimer() {
        if (!this.timerActive) {
          this.timer = setInterval(() => this.countdown(), 1000);
          this.timerActive = true;
        } else {
          clearInterval(this.timer);
          this.timer = null;
          this.timerActive = false;
        }
      },
      countdown() {
        this.totalTime++;
      },
      padTime(time){
        return (time < 10 ? '0' : '') + time;
      },
    }
  }
</script>

<style scoped>
  .timer-text {
    font-size: 3rem;
    margin: 0;
    color: #101010;
  }

  .timer {
    display: flex;
    align-items: center;
    position: absolute;
    bottom: 0;
    left: 0;
  }

  .restart {
    margin: auto;
    width: 100%;
    height: 2.5rem;
  }

  .col {
    height: 100%;
    width: 100%;
  }

</style>