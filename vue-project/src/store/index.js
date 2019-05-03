import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
import {AUTH_REQUEST} from './constants';
import axios from 'axios';

Vue.use(Vuex);
Vue.config.devtools = true;

export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    exerciseGroups: [],
    exerciseIndex: 0,
    currentSetIndex: 0,
    user: localStorage.getItem('user') || ''
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
    },
    [AUTH_REQUEST]: (state, user) => {
      let data = 'username=' + user.username + '&password=' + user.password;
      let headers = {
        'Content-type': 'application/x-www-form-urlencoded'
      };

      axios.post(process.env.VUE_APP_BACKEND_IP + '/login', data, {
        headers: headers
      }).then(response => {
        this.state.user = user;
        localStorage.setItem('user', user);
      }).catch(error => {
        this.state.user = '';
        localStorage.removeItem('user');
      })
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
    },
    isAuthenticated: state => {
      return !!state.user
    }
  },
  actions: {
    [AUTH_REQUEST]: ({commit, dispatch}, user) => {
      return new Promise((resolve, reject) => {
        commit(AUTH_REQUEST, user);
        resolve()
      })
    }
  }
});
