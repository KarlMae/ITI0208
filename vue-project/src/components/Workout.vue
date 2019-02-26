<template>
    <div id="workout">
        <p id="workoutName">Workout name: {{ name }}</p>
        <p id="description">Description: {{ description}}</p>
    </div>
</template>

<script>

    export default {
        name: 'workout',
        data() {
            return {
                name: "Y33t",
                description: "feg"
            }
        }
    }

</script>