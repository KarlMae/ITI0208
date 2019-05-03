<template>
  <div>
    <Header />
    <!-- action="/login"-->
    <form @submit.prevent="signUp">
      <label for="username">Username</label>
      <input id="username" type='text' placeholder='username' autocomplete="off" v-model='username'><br>
      <label for="password">Password</label>
      <input id="password" type='password' placeholder='password' autocomplete="off" v-model='password'><br>
      <input type="submit" value="Sign up">
      <br>
      <a @click="routeTo('login')">Login</a>
    </form>
  </div>
</template>

<script>
  import Header from '../components/Header'
  import routeTo from '../functions'

  export default {
    name: 'signUp',
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
      signUp() {
        const { username, password } = this;

      },
      routeTo
    }
  }
</script>

<style scoped>

</style>
