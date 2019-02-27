<template>
    <div id="x">
        <Header></Header>
        <p v-on:click="goToWorkout" class="workoutClickable">Workout</p>
    </div>
</template>

<script>

    import Vue from 'vue'
    import VueRouter from 'vue-router';
    import Header from "../components/Header";

    Vue.use(VueRouter);


    export default {
        components: {
            Header
        },
        methods: {
            goToWorkout() {
                this.$router.push('/workout/?id=6')
            }
        }
    }

</script>

<style>

    .workoutClickable {
        cursor: pointer;
    }

</style>