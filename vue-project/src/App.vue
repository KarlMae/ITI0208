<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: 'app',
    components: {},
    data() {
      return {
        testField: String
      }
    },
  }
</script>

<style>
  html {
    height: 100%;
  }

  body {
    margin: 0;
    padding: 0;
    height: 100%;
    width: 100%;
    background-color: #f4f4f4;
  }

  #app {
    font-family: 'Panton', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    height: 100%;
  }

  @font-face {
    font-family: "Panton";
    src: url("./assets/font/PantonDemo-LightItalic.otf");
  }
</style>