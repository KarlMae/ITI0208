<template>
  <div>
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
      <a v-on:click="routeTo('login')">Login</a>
    </form>
  </div>
</template>

<script>

  export default {
    name: 'SignUp',
    components: {
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
            this.success = null;
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
