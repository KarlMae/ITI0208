<template>
  <div class="header container-fluid">
    <Slide width="170" noOverlay/>
    <p v-on:click="toHome" class="logo">Logo</p>
  </div>
</template>

<script>
    import { Slide } from 'vue-burger-menu'

    export default {
    name: "Header",
    components: {
      Slide
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

  .menu-svg {
    width: 3rem;
  }

  .logo {
    font-size: 1.5rem;
    margin-bottom: 0;
    cursor: pointer;
  }

</style>