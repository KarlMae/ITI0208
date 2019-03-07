<template>
  <div class="header container-fluid">
      <p class="logo">Logo</p>
      <img src="../../assets/icons/menu.svg" class="menu-svg">
  </div>
</template>

<script>
  export default {
    name: "Header"
  }
</script>

<style scoped>

  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-bottom: 1.5rem;
  }

  .menu-svg {
    width: 3rem;
  }

  .logo {
    font-size: 1.5rem;
    margin-bottom: 0;
  }

</style>