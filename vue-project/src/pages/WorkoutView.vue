<template>
    <div>
        <Header></Header>
        <div class="workout">
        <ul v-if="workout">
            <p>{{ workout }}</p>

            <h2>{{ workout.name }}</h2>
            <h5>{{ workout.description }}</h5>
            <h4>Exercises: </h4>
            <div v-on:click="toExercise" class="exercise">
                <h3>*nimi*</h3>
                <p>Repetitions: *reps*</p>
                <p>Sets: *setid*</p>
            </div>
        </ul>
        <p v-else>Error on loading workout.</p>
        </div>
    </div>

</template>



<script>

    import axios from 'axios';
    import Header from '../components/Header.vue';
    import Vue from 'vue'
    import VueRouter from 'vue-router';

    Vue.use(VueRouter);

    export default {
        components: {
            Header
        },
        data() {
            return {
                workout: Object
            }
        },
        methods: {
            toExercise() {
                this.$router.push('/')
            }
        },
        created() {
            let workoutId = this.$route.query.id;
            axios.get('http://localhost:8090/fetchById/' + workoutId)
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

    .workout h4 {
        text-align: left;
    }

    .exercise {
        border: 1px solid black;
        border-radius: 3px;
        display: flex;
        flex-direction: column;
        text-align: left;
        padding: 10px;
        cursor: pointer;
    }

    .exercise p, h3 {
        margin: 5px;
    }

</style>