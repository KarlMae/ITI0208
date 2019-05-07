<template>

  <p v-on:click="toHome" id="name" class="name">Workout app</p>

</template>

<script>

  export default {
    methods: {
      toHome() {
        this.$router.push('/')
      }
    }
  }

</script>

<style>

  .name {
    cursor: pointer;
  }

</style>