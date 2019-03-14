<template>
 <div class="transition-wrapper">
   <img
       src="../../../assets/icons/edit.svg"
       class="edit-icon"
       v-on:click="openEditModal"
   >

   <transition name="slide-fade">
      <div v-bind:key="exercise.name" class="exercise">
        <h2 id="name">{{ exercise.name }}</h2>
        <p id="reps">Repetitions: {{ exercise.repetitions }}</p>
        <p id="sets">Sets left: {{ exercise.set_nr }}</p>
        <p id="weight" v-if="exercise.weight">Weight: {{ exercise.weight }}</p>
        <p id="duration" v-if="exercise.duration">Duration: {{ format(exercise.duration) }}</p>
      </div>
    </transition>
  </div>
</template>

<script>
  import { exerciseStore } from '../ExerciseStore';

  export default {
    name: "Exercise",
    data() {
      return {
        exerciseStore: exerciseStore,
        exercise: exerciseStore.getExercise()
      };
    },
    created() {
      this.exercise = this.exerciseStore.getExercise();
    },
    computed: {
      exerciseIndex() {
        return this.exerciseStore.state.exerciseIndex;
      }
    },
    watch: {
      exerciseIndex() {
        this.exercise = this.exerciseStore.getExercise();
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