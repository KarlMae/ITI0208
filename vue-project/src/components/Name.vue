<template>
  <p @click="toHome" id="name" class="name">Workout app</p>
</template>

<script>
  export default {
    methods: {
      toHome() {
        this.$router.push({ name: 'home' })
      }
    }
  }
</script>

<style>
  .name {
    margin: 0 auto;
    cursor: pointer;
  }
</style>
