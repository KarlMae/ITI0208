<template>
  <div class="modal" @click='closeModal'>
    <div class="modal-dialog" @click.stop='() => {}'>
      <div class="modal-content">
        <div class="modal-header">
          <button v-on:click="closeModal" class="close">
            <span>&lt;</span>
          </button>
          <h5 class="modal-title">Validation error</h5>
        </div>

        <div class="modal-body">
          <p>{{message}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: "ErrorModal",
    props: {
      message: String
    },
    methods: {
      closeModal() {
        this.$emit('close')
      },
    }
  }
</script>

<style lang="scss" scoped>
</style>