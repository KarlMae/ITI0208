import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueRouter from 'vue-router';
import Index from './pages/Index';
import WorkoutView from "./pages/WorkoutView";
import Exercise from "./pages/exercise/Exercise";
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

Vue.prototype.axios = axios;

Vue.config.productionTip = false;

Vue.use(VueRouter);

const routes = [
  {path: "/", component: Index},
  {name: "workout", path: "/workout", component: WorkoutView, props: true},
  {name: "exercise", path: "/exercise", component: Exercise, props: true}
];

const router = new VueRouter({
  routes
});

new Vue({
  render: h => h(App),
  router
}).$mount('#app');
