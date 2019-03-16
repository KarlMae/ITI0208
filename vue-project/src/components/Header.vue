<template>

  <div id="header" class="header">
    <img src="../assets/icons/menu.svg" alt="menu">
    <Name class="name" />
  </div>

</template>

<script>

  import Name from './Name'

  export default {
    name: "Header",
    components: {
      Name
    }
  }

</script>

<style scoped>
  .header {
    min-height: 4rem;
    width: 100%;
    display: flex;
  }

  .name {
    color: #3a3a3a;
    font-size: 2rem;
    margin: auto 2rem;
    white-space: nowrap;
  }

  img {
    width: 4rem;
    height: 4rem;
    padding: 1rem;
  }
</style>