<template>
  <div class="radio-group">
    <template v-for="set in setCount">
      <input type="radio" :id="set" :value="set" v-model="selectedSet" />
      <label :for="set">{{ set }}</label>
    </template>
  </div>
</template>

<script>
  export default {
    name: "SetSelector",
    data() {
      return {
        selectedSet: this.set,
      }
    },
    props: {
      setCount: Number,
      set: Number,
    },
    watch: {
      selectedSet(value) {
        this.$emit('selectSet', value - 1)
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import '../../../../assets/colors';

  $bg: $primary-main;
  $fg: $primary-main;
  $borderWidth: 3px;

  input[type=radio] {
    position: absolute;
    visibility: hidden;
    display: none;
  }

  label {
    color: $primary-main;
    display: inline-block;
    cursor: pointer;
    font-weight: bold;
    padding: 5px 20px;
    margin-bottom: 0;
  }

  input[type=radio]:checked + label{
    color: $primary-main;
    background: $secondary-main;
  }

  label + input[type=radio] + label {
    border-left: solid $borderWidth $primary-main;
  }
  .radio-group {
    border: solid $borderWidth $primary-main;
    display: inline-block;
    margin: 5px;
    border-radius: 10px;
    overflow: hidden;
  }

</style>