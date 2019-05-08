<template>
  <div class="radio-group">
    <template v-for="set in setCount">
      <input type="radio" :id="name + set" :value="set" v-model="selectedSet"/>
      <label :for="name + set">{{ set }}</label>
    </template>
  </div>
</template>

<script>
  export default {
    name: 'SetSelector',
    data() {
      return {
        selectedSet: this.set,
      }
    },
    props: {
      setCount: Number,
      set: Number,
      name: String
    },
    watch: {
      selectedSet(value) {
        this.$emit('selectSet', value - 1)
      },
      set: {
        handler(newValue) {
          this.selectedSet = newValue
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import '../../../../assets/colors';

  $bg: #3a3a3a;
  $fg: $primary-main;
  $borderWidth: 2px;

  input[type=radio] {
    position: absolute;
    visibility: hidden;
    display: none;
  }

  label {
    color: #3a3a3a;
    display: inline-block;
    cursor: pointer;
    font-weight: bold;
    padding: 5px 20px;
    margin-bottom: 0;
  }

  input[type=radio]:checked + label {
    color: #3a3a3a;
    background: $primary-main;
  }

  label + input[type=radio] + label {
    border-left: solid $borderWidth #3a3a3a;
  }

  .radio-group {
    border: solid $borderWidth #3a3a3a;
    display: inline-block;
    margin: 5px;
    border-radius: .2rem;
    overflow: hidden;
  }

</style>
