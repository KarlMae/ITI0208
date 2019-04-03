<template>

  <div>
    <Header />
    <div class="workout-view">
      <ul v-if="workout">
        <Workout :id = workout.id />
        <div class="workout-info">
          <h3>{{ workout.name }}</h3>
          <p>{{ workout.description }}</p>
        </div>
      </ul>
    </div>

    <div role="tablist" class="tablist">
      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block href="#" v-b-toggle.accordion1 variant="secondary">Warm-up</b-button>
        </b-card-header>
        <b-collapse id="accordion1" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <ul v-if="workout">
              <li v-for="exercise in getWorkout('Warm-up')" :key="exercise.id" class="exercise-list">
                <p>{{ exercise.name }}</p>
              </li>
            </ul>
          </b-card-body>
        </b-collapse>
      </b-card>

      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block href="#" v-b-toggle.accordion2 variant="secondary">Main exercises</b-button>
        </b-card-header>
        <b-collapse id="accordion2" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <ul v-if="workout">
              <li v-for="exercise in getWorkout('Main exercises')" :key="exercise.id" class="exercise-list">
                <p>{{ exercise.name }}</p>
              </li>
            </ul>
          </b-card-body>
        </b-collapse>
      </b-card>

      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block href="#" v-b-toggle.accordion3 variant="secondary">Cool-down</b-button>
        </b-card-header>
        <b-collapse id="accordion3" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <ul v-if="workout">
              <li v-for="exercise in getWorkout('Cool-down')" :key="exercise.id" class="exercise-list">
                <p>{{ exercise.name }}</p>
              </li>
            </ul>
          </b-card-body>
        </b-collapse>
      </b-card>
    </div>

    <b-button variant="danger"
        v-on:click="startWorkout"
        v-if="workout.exerciseGroups && workout.exerciseGroups.length > 0"
    >Start</b-button>
  </div>

</template>


<script>
  import axios from 'axios';
  import Header from '../components/Header.vue';
  import Vue from 'vue'
  import VueRouter from 'vue-router';
  import Workout from "../components/Workout";

  Vue.use(VueRouter);

  export default {
    components: {
      Workout,
      Header
    },
    data() {
      return {
        workout: {
          exerciseGroups: []
        },
      };
    },
    methods: {
      startWorkout() {
          this.$store.commit('setWorkout', this.workout);
          this.$router.push({ name: 'exercise' });
      },
      getWorkout(category) {
        return this.workout.exerciseGroups.filter(group => group.category === category)
      }
    },
    mounted() {
      let workoutId = this.$route.query.id;
      axios.get(process.env.VUE_APP_BACKEND_IP + '/fetchWorkout/' + workoutId)
        .then(response => {
          this.workout = response.data;
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }

</script>

<style scoped>

  ul {
    margin: 0;
    padding: 0;
  }

  body {
    padding: 1rem;
  }

  p {
    margin: 0;
    padding: 0.5rem;
  }

  .workout-view h4 {
    text-align: left;
  }

  .workout-info {
    padding-left: 1rem;
    text-align: left;
  }

  .workout-info h3, p {
    font-weight: bolder;
  }

  .tablist {
    padding: 1rem;
  }

  .exercise-list {
    display: flex;
    justify-content: center;
    align-items: center;
    border-bottom: 1px solid black;
  }

  .exercise-list:last-child {
    border-bottom: none;
  }

  .b-card-body {
    padding: 0;
  }

  .exercise {
    border: 1px solid black;
    border-radius: 3px;
    display: flex;
    flex-direction: column;
    text-align: left;
    padding: 10px;
    margin-bottom: 10px;
  }


</style>