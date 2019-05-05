<template>
  <div>
    <Header/>
    <p v-if="error">{{ error }}</p>
    <br v-else>
    <form id="login" @submit.prevent="login">
      <label for="username">Username</label>
      <input id="username" type='text' placeholder='username' autocomplete="off" v-model='username' required><br>
      <label for="password">Password</label>
      <input id="password" type='password' placeholder='password' autocomplete="off" v-model='password' required><br>
      <input type="submit" value="Login">
      <br>
      <a @click="routeTo('signUp')">Sign up</a>
    </form>
  </div>
</template>

<script>
  import Header from '../components/Header'
  import {AUTH_REQUEST} from '../store/constants'

  export default {
    name: 'Login',
    components: {
      Header
    },
    data() {
      return {
        username: '',
        password: '',
        error: null
      }
    },
    methods: {
      routeTo(path) {
        this.$router.push({ name: path })
      },
      login () {
        const { username, password } = this;
        this.$store.dispatch(AUTH_REQUEST, { username, password })
          .then(() => {
            this.routeTo('userWorkouts')
          }).catch(() => {
            this.error = 'Bad credentials'
        })
      }
    }
  }
</script>

<style scoped>

</style>
