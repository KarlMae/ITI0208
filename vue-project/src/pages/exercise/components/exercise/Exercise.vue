<template>
  <div class="transition-wrapper">
    <img
        src="../../../../assets/icons/edit.svg"
        class="edit-icon"
        v-on:click="openEditModal"
    >

    <transition name="slide-fade">
      <div class="exercise">
        <div v-bind:key="currentSet.name">
          <h2 id="name">{{ currentSet.name }}</h2>
          <p id="reps" v-if="currentSet.repetitions">Repetitions: {{ currentSet.repetitions }}</p>
          <p id="weight" v-if="currentSet.weight !== null">Weight: {{ currentSet.weight }} kg</p>
          <p id="duration" v-if="currentSet.duration  !== null">Duration: {{ format(currentSet.duration) }}</p>
        </div>

        <div class="set-selector">
          <SetSelector
              :set-count="currentExercise.length"
              :set="currentSet.set"
              :name="currentSet.name"
              @selectSet="selectSet"
          />
        </div>
      </div>
    </transition>
  </div>
</template>

<script>

  import SetSelector from '../setSelector/SetSelector';
  export default {
    name: "Exercise",
    components: {
      SetSelector
    },
    computed: {
      currentSet() {
        return this.$store.getters.currentSet;
      },
      currentExercise() {
        return this.$store.getters.currentExercise.sets;
      },
    },
    methods: {
      format: function (duration) {
          const min = Math.floor(duration / 60);
          const sec = duration - min * 60;
          if (min === 0) {
            return `${sec} sec`
          }
          return `${min} min ${sec} sec`;
      },
      selectSet(index) {
        this.$emit('selectSet', index);
      },
      openEditModal() {
        this.$emit('openEditModal');
      },
    }
  }
</script>

<style scoped>
  p {
    margin: 0;
  }

  .exercise {
    padding: 2rem 0;
    width: 100%;
  }

  .transition-wrapper {
    position: relative;
    height: 52%;
    align-items: baseline;
    display: flex;
    flex-direction: row-reverse;
  }

  .slide-fade-enter-active {
    transition: all .5s cubic-bezier(0.5, 0.5, 0.5, 0.5);
  }

  .slide-fade-leave-active {
    transition: all revert;
  }

  .slide-fade-enter, .slide-fade-leave-to {
    transform: translateX(3rem);
    opacity: 0;
  }

  .set-selector {
    position: absolute;
    bottom: 1rem;
    left: 0;
    right: 0;
    text-align: center;
  }
</style>
