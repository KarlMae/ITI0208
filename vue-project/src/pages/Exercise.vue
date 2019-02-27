<template>
    <div id="exercise-view">
        <Header></Header>
        <div id="exercise-section" class="exercise-section">
            <p id="name" class="name">{{ exerciseName }}</p>
            <p id="reps" class="info">Repetitions: {{ repetitions }}</p>
            <p id="sets" class="info">Sets: {{ sets }}</p>
            <p></p>
        </div>
        <Timer></Timer>
    </div>
</template>

<script>

    import Header from '../components/Header'
    import Timer from '../components/Timer'

    export default {
        name: 'exercise-view',
        components: {
            Header,
            Timer
        },
        data() {
            return {
                exerciseName: "Push up",
                repetitions: 10,
                sets: 3
            }
        }
    }
</script>

<style>

    body {
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;

    }

    #exercise-view {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
    }

    .name {
        font-size: 2rem;
    }

    .exercise-section {
        text-align: left;
        padding: 5rem;
    }
</style>
