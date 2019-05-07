import Vue from 'vue';
import App from './App.vue';
import axios from 'axios';
import VueRouter from 'vue-router';
import Index from './pages/Home';
import WorkoutView from "./pages/workout/WorkoutView";
import Exercise from "./pages/exercise/ExerciseView";
import WorkoutEdit from "./pages/workoutEdit/WorkoutEdit";
import Login from './pages/Login';
import SignUp from './pages/SignUp';
import UserWorkouts from './pages/user/UserWorkouts';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import BootstrapVue from 'bootstrap-vue';
import store from './store/index';
import Vuelidate from 'vuelidate';

Vue.prototype.axios = axios;
Vue.config.productionTip = false;
Vue.use(BootstrapVue);
Vue.use(VueRouter);
Vue.use(Vuelidate);

const routes = [
  { name: 'home', path: '/', component: Index },
  { path: '*', component: Index },
  { name: 'login', path: '/login', component: Login },
  { name: 'signUp', path: '/signUp', component: SignUp },
  { name: 'workout', path: '/workout', component: WorkoutView, props: true },
  { name: 'exercise', path: '/exercise', component: Exercise, props: true },
  { name: 'workoutEdit', path: '/workoutEdit', component: WorkoutEdit, props: true },
  { name: 'newWorkout', path: '/newWorkout', component: WorkoutEdit, props: true },
  { name: 'userWorkouts', path: '/user/myWorkouts', component: UserWorkouts, props: true, meta: { requiresAuth: true }}
];

const router = new VueRouter({
  mode: 'history',
  routes
});

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    const loggedIn = store.getters.isAuthenticated;
    if (!loggedIn) {
      next({ name: 'login' })
    } else {
      next()
    }
  } else {
    next()
  }
});

const token = localStorage.getItem('user-token');
if (token) {
  axios.defaults.headers.common['Authorization'] = token
}

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app');
