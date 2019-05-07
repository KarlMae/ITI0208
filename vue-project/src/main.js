import Vue from 'vue';
import App from './App.vue';
import axios from 'axios';
import VueRouter from 'vue-router';
import Index from './pages/Home';
import WorkoutView from "./pages/workout/WorkoutView";
import Exercise from "./pages/exercise/ExerciseView";
import WorkoutEdit from "./pages/workoutEdit/WorkoutEdit";
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
  { name: "home", path: "/", component: Index },
  { path: '*', component: Index },
  { name: "workout", path: "/workout", component: WorkoutView, props: true },
  { name: "exercise", path: "/exercise", component: Exercise, props: true },
  { name: "workoutEdit", path: "/workoutEdit", component: WorkoutEdit, props: true },
  { name: "newWorkout", path: "/newWorkout", component: WorkoutEdit, props: true },
];

const router = new VueRouter({
  mode: 'history',
  routes
});

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app');
