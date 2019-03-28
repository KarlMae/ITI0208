<template>
  <div class="transition-wrapper">
    <img
        src="../../../../assets/icons/edit.svg"
        class="edit-icon"
        v-on:click="openEditModal"
    >

    <transition name="slide-fade">
      <div v-bind:key="currentSet.name" class="exercise">
        <h2 id="name">{{ currentSet.name }}</h2>
        <p id="reps">Repetitions: {{ currentSet.repetitions }}</p>
        <p id="weight" v-if="currentSet.weight">Weight: {{ currentSet.weight }}</p>
        <p id="duration" v-if="currentSet.duration">Duration: {{ format(currentSet.duration) }}</p>
      </div>
    </transition>
  </div>
</template>

<script>
  import {exerciseStore} from '../../ExerciseStore';

  export default {
    name: "Exercise",
    data() {
      return {
        exerciseStore: exerciseStore,
        exercise: exerciseStore.getExercise(),
        setIndex: 0
      };
    },
    created() {
      this.exercise = this.exerciseStore.getExercise();
    },
    computed: {
      exerciseIndex() {
        return this.exerciseStore.state.exerciseIndex;
      },
      currentSet() {
        return this.exerciseStore.getExercise().sets[this.setIndex];
      }
    },
    watch: {
      exerciseIndex() {
        this.exercise = this.exerciseStore.getExercise();
      },
      currentSet() {
        console.log("pede")
      }
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
      openEditModal() {
        this.$emit('openEditModal');
      }
    }
  }
</script>

<style scoped>
  p {
    margin: 0;
  }

  .exercise {
    padding-top: 1.5rem;
    margin: auto;
    width: 90%;
  }

  .transition-wrapper {
    display: flex;
    position: relative;
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

  .edit-icon {
    position: absolute;
    right: 1rem;
    top: 2rem;
  }
</style>