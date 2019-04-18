<template>
  <div>

    <Header />

    Y33t
    <br>
    {{ content }}

  </div>
</template>

<script>
  import Header from "../components/Header";
  export default {
    name: "SecretPage",
    components: {Header},
    data() {
      return {
        content: String
      }
    },
    mounted() {
      this.axios.get(process.env.VUE_APP_BACKEND_IP + '/fetchSecret')
        .then(response => {
          this.content = response.data;
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
</script>

<style scoped>

</style>