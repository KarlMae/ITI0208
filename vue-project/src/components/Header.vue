<template>

  <div id="header" class="header">
    <Slide width="170" noOverlay/>
    <Name class="name"/>
  </div>

</template>

<script>
  import Name from './Name'
  import { Slide } from 'vue-burger-menu'


  export default {
    name: "Header",
    components: {
      Name,
      Slide
    }
  }
</script>

<style scoped>
  .header {
    min-height: 4.5rem;
    width: 100%;
    display: flex;
  }

  .name {
    color: #3a3a3a;
    font-size: 2rem;
    margin-top: auto;
    margin-right: 36px;
    white-space: nowrap;
  }

  img {
    width: 4rem;
    height: 4rem;
    padding: 1rem;
  }
</style>