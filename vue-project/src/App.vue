<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
  import {AUTH_LOGOUT} from "./store/constants";

  export default {
    created: function () {
      this.axios.interceptors.response.use(undefined, function (err) {
        return new Promise(function() {
          if (err.status === 401 && err.config && !err.config.__isRetryRequest) {
            this.$store.dispatch(AUTH_LOGOUT);
          }
          throw err;
        });
      });
    }
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
    background-color: #F0F0F0;
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
