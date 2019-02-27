<template>
    <div id="workout" class="workout">
        <p id="name" class="name">{{ name }}</p>
        <p id="description" class="description">{{ description }}</p>
        <div id="exercises" class="exercises">
            <ul v-for="exercise in exercises" :key="exercise.id">
                <li>{{ exercise }}</li>
            </ul>
        </div>
<<<<<<< HEAD
        <button v-on:click="selectWorkout">Select</button>
=======
>>>>>>> master
    </div>
</template>

<script>

<<<<<<< HEAD
    import Vue from 'vue'
    import VueRouter from 'vue-router';

    Vue.use(VueRouter);

=======
>>>>>>> master
    export default {
        name: 'workout',
        props: {
            name: String,
            description: String,
            exercises: Array
<<<<<<< HEAD
        },
        methods: {
            selectWorkout() {
                this.$router.push('/workout/?id=1')
            }
=======
>>>>>>> master
        }
    }

</script>

<style>

    .workout {
        border: solid 3px #582841;
        border-radius: 0.4rem;
        width: 22rem;
        text-align: center;
        margin: 1rem;
    }

    .name {
        font-size: 1.5rem;
    }

<<<<<<< HEAD
    button {
        color: #494949;
        text-transform: uppercase;
        background: #ffffff;
        padding: 5px;
        margin: 10px;
        border: 2px solid #494949;
        border-radius: 6px;
        display: inline-block;
        font-size: large;
    }

=======
>>>>>>> master
    .exercises {
        display: inline-block;
        text-align: left;
        font-size: 0.8rem;
    }

</style>