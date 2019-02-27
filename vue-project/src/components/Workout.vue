<template>
    <div id="workout" class="workout">
        <p id="name" class="name">{{ name }}</p>
        <p id="description" class="description">{{ description }}</p>
        <div id="exercises" class="exercises">
            <ul v-for="exercise in exercises" :key="exercise.id">
                <li>{{ exercise }}</li>
            </ul>
        </div>
    </div>
</template>

<script>

    export default {
        name: 'workout',
        props: {
            name: String,
            description: String,
            exercises: Array
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

    .exercises {
        display: inline-block;
        text-align: left;
        font-size: 0.8rem;
    }

</style>