<template>
    <div id="app">
        <Header></Header>
        <div id="workouts" class="workouts">
            <Workout></Workout>
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
                workouts: []
            }
        },
        async mounted() {
            this.axios
               .get('http://192.168.99.100:8090/fetchAll')
               .then(response => {
                    this.workouts = response.data
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
        margin: 1.5rem;
    }

</style>
