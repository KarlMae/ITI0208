<template>

  <div>
    <div class="workout-view margin-bottom">
      <WorkoutImage
          :src="workout.image"
      />
      <div class="workout-info">
        <h3 class="name">{{ workout.name }}</h3>
      </div>
    </div>

    <div role="tablist" class="tablist">
      <template v-for="group in groupNames">
        <Accordion
            v-if="getWorkout(group).length"
            :workout="getWorkout(group)"
            :group="group"/>
      </template>
    </div>


    <div class="absolute">
      <div class="footer-buttons">
        <button class="btn btn-edit" v-on:click="editWorkout">Edit</button>
        <button class="btn btn-start" v-on:click="startWorkout">Start</button>
      </div>
    </div>
  </div>

</template>


<script>
  import axios from 'axios';
  import WorkoutImage from "../../components/WorkoutImage";
  import Accordion from "../../components/Accordion";

  export default {
    components: {
      Accordion,
      WorkoutImage,
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
        this.$router.push({name: 'exercise'});
      },
      editWorkout() {
        this.$router.push({name: 'workoutEdit', params: {editWorkout: this.workout}});
      },
      getWorkout(category) {
        return this.workout.exerciseGroups.filter(group => group.category === category);
      }
    },
    mounted() {
      let workoutId = this.$route.query.id;
      axios.get(process.env.VUE_APP_BACKEND_IP + '/workout/fetchById/' + workoutId)
        .then(response => {
          this.workout = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        })
    }
  }

</script>

<style lang="scss" scoped>
  @import "../../assets/colors";

  p {
    margin-bottom: 0;
  }

  .name {
    font-weight: bolder;
    text-align: left;
    margin-top: 1rem;
  }

  .margin-bottom {
    margin-bottom: 1rem;
  }

  .btn {
    width: 35%;
    height: 90%;
  }

  .btn-start {
    background-color: $primary-shade;
  }

  .btn-edit {
    background-color: $secondary-shade;
  }

  .absolute {
    position: absolute;
    left: 50%;
    bottom: 1.5rem;
  }

  .footer-buttons {
    width: 100vw;
    position: relative;
    display: flex;
    align-items: center;
    justify-content: space-around;
    min-height: 4rem;
    left: 50%;
    right: 50%;
    margin-left: -50vw;
    margin-right: -50vw;
    bottom: -1.5rem;
    background-color: #dfdfdf;
    -webkit-box-shadow: inset 0px 10px 5px -10px rgba(0, 0, 0, 0.75);
    -moz-box-shadow: inset 0px 10px 5px -10px rgba(0, 0, 0, 0.75);
    box-shadow: inset 0px 10px 5px -10px rgba(0, 0, 0, 0.75);
  }

</style>