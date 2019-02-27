<template>
    <div id="app">
        <Header></Header>
        <div id="workouts" class="workouts">
            <Workout v-for="workout in workouts"
                :key="workout.id"
                :name="workout.name"
                :description="workout.description"
                :exercises="workout.exercises"
            ></Workout>
        </div>
    </div>
</template>

<script>

    import Header from '../components/Header'
    import Workout from '../components/Workout'

    export default {
        name: 'app',
        components: {
            Header,
            Workout
        },
        data() {
            return {
                workouts: Array,
                error: Array
            }
        },
        async mounted() {
            this.axios
                .get('http://localhost:8090/fetchAll')
                .then(response => {
                    this.workouts = response.data
                })
                .catch(error => {
                    this.error = error;
                })
        }
    }

</script>

<style>

    body {
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }

    .workouts {
        display: flex;
        margin: 1rem;
    }

</style>
