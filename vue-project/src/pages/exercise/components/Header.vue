<template>
  <div class="header container-fluid">
    <p v-on:click="toHome" class="logo">Logo</p>
  </div>
</template>

<script>

    export default {
    name: "Header",
    components: {

    },
    methods: {
        toHome() {
            this.$router.push('/')
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