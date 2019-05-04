<template>
  <div class="header container-fluid">
    <p @click="toHome" class="logo">Logo</p>
  </div>
</template>

<script>
  import routeTo from '../../../functions'

  export default {
  name: 'header',
  methods: {
    routeTo,
    toHome() {
      this.routeTo('/')
    }
  }
}
</script>

<style scoped>
  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-bottom: 1.5rem;
  }

  .logo {
    font-size: 1.5rem;
    margin-bottom: 0;
    cursor: pointer;
  }
</style>
