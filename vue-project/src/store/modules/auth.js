import { AUTH_REQUEST, AUTH_ERROR, AUTH_SUCCESS, AUTH_LOGOUT } from '../constants'
import axios from "axios";

const state = {
  token: localStorage.getItem('user-token') || ''
};

const getters = {
  isAuthenticated: state => {
    return !!state.token
  }
};

const actions = {
  [AUTH_REQUEST]: ({ commit }, user) => {
    return new Promise((resolve, reject) => {
      const data = JSON.stringify(user);
      const headers = {
        'Content-type': 'application/json'
      };

      axios({url: `${process.env.VUE_APP_BACKEND_IP}/login`, data: data, headers: headers, method: 'POST'})
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
  [AUTH_ERROR]: (state) => {
    state.token = ''
  },
  [AUTH_LOGOUT]: (state) => {
    state.token = ''
  }
};

export default {
  state,
  getters,
  actions,
  mutations,
}
