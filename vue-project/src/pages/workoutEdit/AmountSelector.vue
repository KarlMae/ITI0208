<template>
  <div>
    <label>{{ name }}</label>
    <div class="set-parameter">
      <button v-on:click="() => remove()" class="btn amount-btn">-</button>
      <input class="set-parameter" v-model="actualValue">
      <button v-on:click="() => add()" class="btn amount-btn">+</button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "AmountSelector",
    props: {
      value: Number,
      name: String,
      unit: String,
    },
    data() {
      return {
        actualValue: this.value
      }
    },
    watch: {
      value(newVal, oldVal) {
        newVal = parseInt(newVal);

        if (isNaN(newVal) || newVal > 100) {
          this.actualValue = oldVal;
        } else {
          this.actualValue = newVal;
        }
      },
      actualValue(newVal) {
        this.$emit('set', newVal);
      }
    },
    methods: {
      add() {
        if (this.actualValue < 100) {
          this.$emit('add');
        }
      },
      remove() {
        if (this.actualValue > 0) {
          this.$emit('remove');
        }

      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "../../assets/colors";

  .set-parameter {
    display: flex;
    justify-content: space-around;

    .btn {
      min-width: 3rem;
      min-height: 3rem;
      margin: 1rem 0;
      color: #F0F0F0;
      background-color: #3a3a3a;
      border-radius: .1rem;
    }

    input {
      margin: 1rem;
      display: inline-block;
      text-align: center;
      background-color: #F0F0F0;
      border: transparent;
      width: 3rem;
      height: 3rem;
    }
  }
</style>