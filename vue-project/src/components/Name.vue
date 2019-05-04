<template>
  <p @click="toHome" id="name" class="name">Workout app</p>
</template>

<script>
  import routeTo from '../functions'

  export default {
    methods: {
      routeTo,
      toHome() {
        this.routeTo('/')
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
