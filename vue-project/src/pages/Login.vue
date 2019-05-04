<template>
  <div>
    <Header/>
    <br>
    <!-- action="/login"-->
    <form id="login" @submit.prevent="login">
      <label for="username">Username</label>
      <input id="username" type='text' placeholder='username' autocomplete="off" v-model='username'><br>
      <label for="password">Password</label>
      <input id="password" type='password' placeholder='password' autocomplete="off" v-model='password'><br>
      <input type="submit" value="Login">
      <br>
      <a @click="routeTo('signUp')">Sign up</a>
    </form>
  </div>
</template>

<script>
  import Header from '../components/Header'
  import {AUTH_REQUEST} from '../store/constants'
  import routeTo from '../functions'

  export default {
    name: 'login',
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
      routeTo,
      login () {
        const { username, password } = this;
        this.$store.dispatch(AUTH_REQUEST, {username, password}).then(() => {
          this.routeTo('userWorkouts')
        })
      }
    }
  }
</script>

<style scoped>

</style>
