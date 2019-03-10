<template>
  <div id="header" class="header">
    <img src="../assets/icons/menu.svg">
    <Name class="name"></Name>
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
    background-color: #CC2A49;
    display: flex;
  }

  .name {
    color: aliceblue;
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