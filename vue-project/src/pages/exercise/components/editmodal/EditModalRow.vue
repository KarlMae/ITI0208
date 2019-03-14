<template>
  <div class="line">
    <button
        v-on:click="subtract"
        class="btn amount-btn"
    >
      -
    </button>
    <div>
      <p class="title">{{ this.name }}</p>
      <p>{{ this.amount + this.unit }}</p>
    </div>
    <button
        v-on:click="add"
        class="btn amount-btn"
    >
      +
    </button>
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
      amount: {
        type: Number,
        default: 0
      },
      unit: {
        type: String,
        default: ''
      }
    },
    methods: {
      add() {
        this.$emit('add', this.name);
      },
      subtract() {
        this.$emit('subtract', this.name);
      }
    },
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