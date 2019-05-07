<template>
  <div class="text-input">
    <label
        for="workoutName"
        v-bind:class="{'text-red': isError}"
        class="label"
    > {{ label }} </label>

    <input
        id="workoutName"
        v-model="fieldValue"
        v-bind:class="{'border-red': isError}"
    >
    <p
        :v-if="isError"
        class="error-message"
    >{{ errorMessage }}</p>

  </div>
</template>

<script>
  export default {
    name: "ValidatedField",
    data() {
      return {
        fieldValue: this.defaultValue,
      }
    },
    props: {
      label: {
        type: String,
        required: true,
      },
      validationErrors: {
        type: Object,
        required: true,
      },
      defaultValue: {
        type: String,
      },
      hasBeenUsed: false,
    },
    watch: {
      validationErrors: {
        handler() {
        }
      },
      fieldValue: {
        handler(newValue) {
          this.$emit('valueChanged', newValue);
        }
      },
      defaultValue: {
        handler(newValue) {
          this.fieldValue = newValue;
        }
      }
    },
    computed: {
      errorMessage() {
        if (!this.validationErrors.minLength && this.hasBeenUsed) {
          return 'Must be at least 5 characters long';
        }

        if (!this.validationErrors.required && this.hasBeenUsed) {
          return 'Must have a value';
        }

        return '';
      },
      isError() {
        return (!this.validationErrors.minLength || !this.validationErrors.required) && this.hasBeenUsed;
      }
    }
  }
</script>

<style scoped>
  .error-message {
    font-size: 0.75rem;
    text-align: left;
  }

  .border-red {
    border-color: red;
  }

  .text-red {
    color: red;
  }

  .label {
    text-align: left;
  }
</style>