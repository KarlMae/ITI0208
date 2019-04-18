import Vue from 'vue';
import App from './App.vue';
import axios from 'axios';
import VueRouter from 'vue-router';
import Index from './pages/Index';
import Login from "./pages/Login";
import WorkoutView from "./pages/WorkoutView";
import Exercise from "./pages/exercise/ExerciseView";
import WorkoutEdit from "./pages/workoutEdit/WorkoutEdit";
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import BootstrapVue from 'bootstrap-vue'
import store from './store/index'
import SecretPage from "./pages/SecretPage";

Vue.use(BootstrapVue);

Vue.prototype.axios = axios;

Vue.config.productionTip = false;

Vue.use(VueRouter);

const routes = [
  { name: "home", path: "/", component: Index },
  { path: '*', component: Index },
  { name: "login", path: "/login", component: Login },
  { name: "workout", path: "/workout", component: WorkoutView, props: true },
  { name: "exercise", path: "/exercise", component: Exercise, props: true },
  { name: "workoutEdit", path: "/workoutEdit", component: WorkoutEdit, props: true },
  { name: "newWorkout", path: "/newWorkout", component: WorkoutEdit, props: true },
  { name: "secretPage", path: "/secret", component: SecretPage }
];

const router = new VueRouter({
  mode: 'history',
  routes
});

/*router.beforeEach((to, from, next) => {
  const publicPages = ['/login'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = store.getters.isAuthenticated;

  if (authRequired && !loggedIn) {
    return next('/login');
  }
  next();
});*/

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app');
