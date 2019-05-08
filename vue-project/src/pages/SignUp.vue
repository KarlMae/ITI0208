<template>
  <div>
    <br>
    <form @submit.prevent="validateInput">
      <validated-field
        label="Username"
        type="text"
        :default-value="username"
        :validation-errors="$v.username"
        :has-been-used="isSavePressed"
        @valueChanged="(value) => username = value"
      />
      <validated-field
        label="Password"
        type="password"
        :default-value="password"
        :validation-errors="$v.password"
        :has-been-used="isSavePressed"
        @valueChanged="(value) => password = value"
      />
      <button type="submit" class="btn exercise-btn">Sign up</button><br>
      <a v-on:click="routeTo('login')">Login</a>
    </form>
  </div>
</template>

<script>
  import ValidatedField from "../components/ValidatedField";
  import { minLength, required } from "vuelidate/lib/validators";

  export default {
    name: 'SignUp',
    components: {
      ValidatedField
    },
    data() {
      return {
        username: '',
        password: '',
        isSavePressed: false
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
            alert('Account successfully created')
          })
          .catch(() => {
            alert('Username already taken')
          })
      },
      routeTo(path) {
        this.$router.push({ name: path })
      },
      validateInput() {
        if (!this.validate()) {
          this.signUp()
        }
      },
      validate() {
        this.isSavePressed = true;

        this.$v.$touch();
        return !!this.$v.$invalid;
      },
    },
    validations: {
      username: {
        minLength: minLength(5),
        required
      },
      password: {
        minLength: minLength(5),
        required
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "../assets/colors";

  a, button {
    border-radius: 0;
    border-color: transparent;
  }

  .btn, .btn:hover, .btn:focus {
    margin: 1rem 0;
    background-color: $primary-main !important;
    color: #f0f0f0 !important;
  }

  .exercise-btn {
    width: 100%;
  }
</style>
