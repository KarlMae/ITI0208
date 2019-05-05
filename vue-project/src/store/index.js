import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import auth from "./modules/auth";

Vue.use(Vuex);
Vue.config.devtools = true;

export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    exerciseGroups: [],
    exerciseIndex: 0,
    currentSetIndex: 0
  },
  mutations: {
    setWorkout(state, workout) {
      this.state.exerciseGroups = workout.exerciseGroups;
      this.state.exerciseIndex = workout.exerciseIndex || 0;
    },
    nextExercise() {
      this.state.exerciseIndex++;
      this.state.currentSetIndex = 0;
    },
    previousExercise() {
      this.state.exerciseIndex--;
      this.state.currentSetIndex = 0;
    },
    selectSet(state, index) {
      this.state.currentSetIndex = index;
    },
    updateCurrentExercise(state, exercise) {
      Vue.set(this.state.exerciseGroups, this.state.exerciseIndex, exercise);
    }
  },
  getters: {
    previousExercisePresent: state => {
      return state.exerciseIndex > 0
    },
    nextExercisePresent: state => {
      return state.exerciseIndex < state.exerciseGroups.length - 1
    },
    currentExercise: state => {
      return state.exerciseGroups[state.exerciseIndex]
    },
    currentSet: state => {
      return state.exerciseGroups[state.exerciseIndex].sets[state.currentSetIndex]
    }
  },
  modules: {
    auth
  }
});
