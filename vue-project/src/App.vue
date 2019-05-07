<template>
  <div id="app">
    <Header />
    <router-view></router-view>
  </div>
</template>

<script>
  import {AUTH_LOGOUT} from './store/constants'
  import Header from './components/Header'

  export default {
    name: 'App',
    components: {
      Header
    },
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
  html, body, #app {
    height: 100%;
    overflow: auto;
    background-color: #F0F0F0;
  }

  p {
    margin-bottom: 0;
  }

  #app {
    font-family: 'Panton', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    padding: 0 2rem 2rem;
  }

  @font-face {
    font-family: "Panton";
    src: url("./assets/font/PantonDemo-LightItalic.otf");
  }
</style>
