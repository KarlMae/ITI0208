<template>

</template>

<script>
import Timer from './components/Timer'
import Header from './components/Header'
import ExerciseImage from './components/exercise/ExerciseImage';
import Exercise from './components/exercise/Exercise';
import EditModal from './components/editmodal/EditModal'

export default {
  name: 'exercise-view',
  components: {
    Exercise,
    ExerciseImage,
    Header,
    Timer,
    EditModal
  },
  data() {
    return {
      isModalVisible: false
    };
  },
  methods: {
    nextExercise() {
      this.$store.commit('nextExercise');
    },
    previousExercise() {
      this.$store.commit('previousExercise');
    },
    toggleEditModal() {
      this.isModalVisible = !this.isModalVisible;
    },
  },
  computed: {
    previousExercisePresent() {
      return this.$store.getters.previousExercisePresent;
    },
    nextExercisePresent() {
      return this.$store.getters.nextExercisePresent;
    }
  }
}
</script>

<style scoped>

  #exercise-view {
    height: 100%;
  }

  .exercise-section {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    background-color: #F0F0F0;
    height: 100%;
    width: 100%;
    text-align: left;
    padding: 2rem;
  }

  .nav-button {
    border: 0;
    border-radius: 0;
    font-size: 2rem;
    font-weight: bold;
    align-self: center;
    background-color: transparent;
    position: absolute;
    top: 50%;
  }

  .content-slide-enter-active {
    animation: bounce-in .5s;
  }

  .content-slide-leave-active {
    animation: bounce-in .5s reverse;
  }

</style>