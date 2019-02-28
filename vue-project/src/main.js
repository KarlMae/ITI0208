import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueRouter from 'vue-router';
import Index from './pages/Index';
import WorkoutView from "./pages/WorkoutView";
import Exercise from "./pages/Exercise";

Vue.prototype.axios = axios;

Vue.config.productionTip = false;

Vue.use(VueRouter);

const routes = [
  {path: "/", component: Index},
  {path: "/workout", component: WorkoutView},
  {path: "/exercise", component: Exercise}
];

const router = new VueRouter({
  routes
});

new Vue({
  render: h => h(App),
  router
}).$mount('#app');
