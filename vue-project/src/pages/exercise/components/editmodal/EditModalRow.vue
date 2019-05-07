<template>
  <div class="line">
    <button @click="subtract" class="btn amount-btn">-</button>
    <div>
      <p class="title">{{ this.name }}</p>
      <p>{{ displayAmount }}</p>
    </div>
    <button @click="add" class="btn amount-btn">+</button>
  </div>
</template>

<script>
  export default {
    name: "EditModalRow",
    props: {
      name: {
        type: String,
        required: true
      },
      duration: {
        type: Number
      },
      weight: {
        type: Number
      },
      repetitions: {
        type: Number
      }
    },
    computed: {
      displayAmount() {
        if (this.duration) {
          return this.duration + "sec"
        } else if (this.weight) {
          return this.weight + "kg"
        } else {
          return this.repetitions
        }
      }
    },
    methods: {
      add() {
        this.$emit('add', this.name)
      },
      subtract() {
        this.$emit('subtract', this.name)
      }
    }
  }
</script>

<style scoped>
  .line {
    display: flex;
    justify-content: space-between;
  }

  .amount-btn {
    font-size: 2rem;
  }

  .title {
    font-size: 1.5rem;
    font-weight: bolder;
    padding-top: 1rem;
    margin-bottom: 0.5rem;
  }
</style>
