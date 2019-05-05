<template>
  <div>
    <Header/>
    <p v-if="success">{{ success }}</p>
    <p v-else-if="error">{{ error }}</p>
    <br v-else>
    <form @submit.prevent="signUp">
      <label for="username">Username</label>
      <input id="username" type='text' placeholder='username' autocomplete="off" v-model='username' required><br>
      <label for="password">Password</label>
      <input id="password" type='password' placeholder='password' autocomplete="off" v-model='password' required><br>
      <input type="submit" value="Sign up">
      <br>
      <a @click="routeTo('login')">Login</a>
    </form>
  </div>
</template>

<script>
  import Header from '../components/Header'

  export default {
    name: 'SignUp',
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
        }).then(() => {
            this.success = 'Account successfully created'
          })
          .catch(() => {
            this.error = 'Username already taken'
          })
      },
      routeTo(path) {
        this.$router.push({ name: path })
      }
    }
  }
</script>

<style scoped>

</style>
