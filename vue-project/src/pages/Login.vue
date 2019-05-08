<template>
  <div>
    <p v-if="error">{{ error }}</p>
    <br v-else>
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
      <button type="submit" class="btn exercise-btn">Login</button><br>
      <a v-on:click="routeTo('signUp')">Sign up</a>
    </form>
  </div>
</template>

<script>
  import ValidatedField from "../components/ValidatedField";
  import { minLength, required } from "vuelidate/lib/validators";
  import {AUTH_REQUEST, AUTH_REQUEST_GET_ID} from '../store/constants'

  export default {
    name: 'Login',
    components: {
      ValidatedField
    },
    data() {
      return {
        username: '',
        password: '',
        isSavePressed: false,
        error: null
      }
    },
    methods: {
      routeTo(path) {
        this.$router.push({ name: path })
      },
      validateInput() {
        if (!this.validate()) {
          this.login()
        }
      },
      validate() {
        this.isSavePressed = true;

        this.$v.$touch();
        return !!this.$v.$invalid;
      },
      login () {
        const { username, password } = this;
        this.$store.dispatch(AUTH_REQUEST, { username, password })
          .then(() => {
            this.$store.dispatch(AUTH_REQUEST_GET_ID, username)
              .then(() => {
                this.routeTo('userWorkouts')
              })
          }).catch(() => {
            this.error = 'Bad credentials'
        })
      }
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
