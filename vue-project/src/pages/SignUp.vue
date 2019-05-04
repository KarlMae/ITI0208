<template>
  <div>
    <Header/>
    <form @submit.prevent="signUp">
      <p v-if="success">{{ success }}</p>
      <p v-else-if="error">{{ error }}</p>
      <br v-else>
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
        password: '',
        success: null,
        error: null
      }
    },
    methods: {
      signUp() {
        const data = `{ "username": "${this.username}", "password": "${this.password}" }`;
        const headers = {
          'Content-type': 'application/json'
        };
        this.axios.post(process.env.VUE_APP_BACKEND_IP + '/user/sign-up', data, {
          headers: headers
        }).then(response => {
            this.success = response.data
          })
          .catch(error => {
            this.error = 'Username already taken'
          })
      },
      routeTo
    }
  }
</script>

<style scoped>

</style>
