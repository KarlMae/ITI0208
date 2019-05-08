<template>
  <div class="set">
    <button
        class="transparent-button close-button"
        type="button"
        v-on:click="$emit('removeSet', set.id)">
      X
    </button>

    <amount-selector
        name="Repetitions"
        :value="set.repetitions"
        @add="() => set.repetitions = parseFloat(set.repetitions) + 1"
        @remove="() => set.repetitions = parseFloat(set.repetitions) - 1"
        @set="(newVal) => set.repetitions = parseFloat(newVal)"
    />

    <amount-selector
        v-if="timed"
        name="Duration"
        unit="s"
        :value="set.duration"
        @add="() => set.duration = parseFloat(set.duration) + 1"
        @remove="() => set.duration = parseFloat(set.duration) - 1"
        @set="(newVal) => set.duration = parseFloat(newVal)"
    />

    <amount-selector
        v-if="weighed"
        name="Weight"
        unit="kg"
        :value="set.weight"
        @add="() => set.weight = parseFloat(set.weight) + 1"
        @remove="() => set.weight = parseFloat(set.weight) - 1"
        @set="(newVal) => set.weight = parseFloat(newVal)"
    />
  </div>
</template>

<script>
  import AmountSelector from './AmountSelector';
  export default {
    name: "SetComponent",
    components: {
      AmountSelector

    },
    props: {
      weighed: {
        type: Boolean,
        default: false
      },
      timed: {
        type: Boolean,
        default: false
      },
      set: Object
    },
  }
</script>

<style scoped>
  .set {
    position: relative;
    -webkit-box-shadow: inset 1px 1px 5px 0px rgba(255,255,255,1);
    -moz-box-shadow: inset 1px 1px 5px 0px rgba(255,255,255,1);
    box-shadow: inset 1px 1px 5px 0px rgba(255,255,255,1);
    padding: 1rem 0.5rem;
  }

  .close-button {
    background-color: transparent;
    border-color: transparent;
    position: absolute;
    top: 0.9rem;
    right: 1rem;
    border-radius: 0;
  }

  .transparent-button {
    background-color: transparent;
    border-color: transparent;
    border-radius: 0;
  }
</style>