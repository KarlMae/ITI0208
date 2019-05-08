import {
  AUTH_REQUEST,
  AUTH_ERROR,
  AUTH_SUCCESS,
  AUTH_LOGOUT,
  AUTH_REQUEST_GET_ID,
  AUTH_SUCCESS_GET_ID
} from '../constants'
import axios from "axios";

const state = {
  token: localStorage.getItem('user-token') || '',
  userId: null
};

const getters = {
  isAuthenticated: state => {
    return !!state.token
  },
  getUserId: state => {
    return state.userId
  }
};

const actions = {
  [AUTH_REQUEST]: ({ commit }, user) => {
    return new Promise((resolve, reject) => {
      const data = JSON.stringify(user);
      const headers = {
        'Content-type': 'application/json'
      };

      axios.post(`${process.env.VUE_APP_BACKEND_IP}/login`, data, {
        headers: headers
      })
        .then(response => {
          const token = response.headers.authorization;
          localStorage.setItem('user-token', token);
          axios.defaults.headers.common['Authorization'] = token;
          commit(AUTH_SUCCESS, token);
          resolve(response)
        }).catch(error => {
          localStorage.removeItem('user-token');
          commit(AUTH_ERROR);
          reject(error)
        })
    })
  },
  [AUTH_REQUEST_GET_ID]: ({ commit, reject }, username) => {
    return new Promise(resolve => {
      axios.get(`${process.env.VUE_APP_BACKEND_IP}/user/getId/${username}`)
        .then(response => {
          const userId = response.data;
          commit(AUTH_SUCCESS_GET_ID, userId);
          resolve(response)
        }).catch(error => {
          localStorage.removeItem('user-token');
          commit(AUTH_ERROR);
          reject(error)
        })
      })
  },
  [AUTH_LOGOUT]: ({ commit }) => {
    return new Promise((resolve) => {
      commit(AUTH_LOGOUT);
      localStorage.removeItem('user-token');
      delete axios.defaults.headers.common['Authorization'];
      resolve()
    })
  }
};

const mutations = {
  [AUTH_SUCCESS]: (state, token) => {
    state.token = token
  },
  [AUTH_SUCCESS_GET_ID]: (state, userId) => {
    state.userId = userId;
  },
  [AUTH_ERROR]: (state) => {
    state.token = '';
    state.userId = ''
  },
  [AUTH_LOGOUT]: (state) => {
    state.token = '';
    state.userId = ''
  }
};

export default {
  state,
  getters,
  actions,
  mutations,
}
