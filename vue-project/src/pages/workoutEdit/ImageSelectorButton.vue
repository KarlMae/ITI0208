<template>
  <div class="image-select-button" v-on:click="() => $emit('clicked')">
    <div v-if="image">
      <img :src="image" alt="alt" class="svg-icon">
    </div>

    <div v-if="!image">
      <img src="../../assets/icons/camera.svg" alt="alt" class="svg-icon">
    </div>

  </div>
</template>

<script>
  export default {
    name: "ImageSelectorButton",
    props: {
      image: String
    }
  }
</script>

<style scoped>
  .image-select-button {
    min-width: 90%;
    min-height: 5rem;
    background-color: #00000010;
    border-radius: 0.2rem;
    border: #3a3a3a solid 1px;
  }

  .svg-icon {
    max-height: 5rem;
  }
</style>