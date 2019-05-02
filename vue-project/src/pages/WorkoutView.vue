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
      <template v-for="group in groupNames">
        <Accordion
          :workout="getWorkout(group)"
          :group="group"/>
      </template>

    </div>

    <button class="btn btn-edit" v-on:click="editWorkout">Edit</button>

    <button class="btn btn-start" v-on:click="startWorkout" v-if="workout.exerciseGroups && workout.exerciseGroups.length > 0">
      Start
    </button>

  </div>

</template>


<script>
  import axios from 'axios';
  import Header from '../components/Header.vue';
  import Vue from 'vue'
  import VueRouter from 'vue-router';
  import Workout from "../components/Workout";
  import Accordion from "../components/Accordion";

  Vue.use(VueRouter);

  export default {
    components: {
      Accordion,
      Workout,
      Header
    },
    data() {
      return {
        workout: {
          exerciseGroups: []
        },
        groupNames: [
          'Warm-up',
          'Main exercises',
          'Cool-down'
        ]
      };
    },
    methods: {
      startWorkout() {
          this.$store.commit('setWorkout', this.workout);
          this.$router.push({ name: 'exercise' });
      },
      editWorkout() {
        this.$router.push({ name: 'workoutEdit', params: {editWorkout: this.workout} });
      },
      getWorkout(category) {

        return this.workout.exerciseGroups.filter(group => group.category === category)
      }
    },
    mounted() {
      let workoutId = this.$route.query.id;
      axios.get(process.env.VUE_APP_BACKEND_IP + '/workout/fetchById/' + workoutId)
        .then(response => {
          this.workout = response.data;
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }

</script>

<style lang="scss" scoped>
@import "../assets/colors";

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

  .btn-start {
    margin: 3rem;
    width: 10rem;
    height: 3rem;
    background-color: $primary-shade;
  }

  .btn-edit {
    margin: 3rem;
    width: 10rem;
    height: 3rem;
    background-color: $secondary-shade;
  }


</style>