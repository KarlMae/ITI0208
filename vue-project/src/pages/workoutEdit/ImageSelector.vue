<template>
  <div class="modal" v-on:click="$emit('close')">
    <div class="modal-dialog" @click.stop='() => {}'>
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Select image</h5>
          <button v-on:click="() => $emit('close')" class="close">
            <span>X</span>
          </button>
        </div>

        <div class="modal-body">
          <template v-for="image in images">
            <div
                v-on:click="selected = image"
                v-bind:class="{'selected': selected === image}"
                class="image"
            >
              <b-img :src="image" fluid> </b-img>
            </div>
          </template>
        </div>

        <div class="modal-footer">
          <button
              v-on:click="select"
              v-bind:class="{'disabled': selected === undefined}"
              class="btn"
          >Select</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "ImageSelector",
    data() {
      return {
        images:
          [
            'https://evofitness.ch/wp-content/uploads/2017/02/14A.jpg',
            'https://www.mensjournal.com/wp-content/uploads/2018/08/WeightLossWorkoutMain.jpg?w=1200',
            'https://d2z0k43lzfi12d.cloudfront.net/blog/vcdn252/wp-content/uploads/2017/06/09.06._Things-you-should-never-do-after-a-workout-1.jpg'
          ],
        selected: undefined,
      }
    },
    methods: {
      select() {
        if (this.selected !== undefined) {
          this.$emit('close');
          this.$emit('selectImage', this.selected);
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  @import "../../assets/colors";
  .modal {
    display: block;
    padding-top: 2rem;
    background-color: #00000070;
  }

  .modal-body {
    max-height: 50vh;
    overflow: scroll;
  }

  .image {
    margin-bottom: 1rem;
  }

  .selected {
    filter: contrast(200%);
    filter: drop-shadow(1px 1px 5px $primary-main);
  }

  .btn {
    background-color: $primary-main;
    color: white;
  }

  .disabled {
    background-color: black;
  }

  .disabled:focus {
    color: white;
  }

</style>