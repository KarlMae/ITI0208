<template>
  <div>
    <Header />
    <form id="login" action="/login" v-on:submit.prevent="login">
      <label for="username">Username</label>
      <input id="username" type='text' placeholder='username' autocomplete="off" v-model='username'><br>
      <label for="password">Password</label>
      <input id="password" type='password' placeholder='password' autocomplete="off" v-model='password'><br>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
  import Header from "../components/Header";
  import {AUTH_REQUEST} from "../store/constants";

  export default {
    name: "Login",
    components: {
      Header
    },
    data() {
      return {
        username: '',
        password: ''
      }
    },
    methods: {
      login () {
        const { username, password } = this;
        this.$store.dispatch(AUTH_REQUEST, {username, password}).then(() => {
          this.$router.push('/')
        })
      }
    }
  }
</script>

<style scoped>

</style>