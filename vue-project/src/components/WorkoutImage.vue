<template>
    <div class="image-wrapper">
        <div class="workout-info">
            <h2>{{name}}</h2>
            <p>{{description}}</p>
        </div>
    </div>
</template>

<script>
  export default {
    name: "WorkoutImage",
    props: {
      name: String,
      description: String
    }
  }
</script>

<style scoped>

    .image-wrapper {
        height: 15rem;
        overflow: auto;
        position: relative;
        margin: auto;
        border-radius: 1rem;
        background:
                linear-gradient(rgba(255, 255, 255, 0.3), rgba(0, 0, 0, 0.5)),
                url("../assets/DSC07713-5.jpg");
                background-size: cover;

    }


    .workout-image {
        max-width: 100%;
    }

    .workout-image {
        content: " ";
        width: 100%;
        height: 100%;
        position: absolute;
        z-index: -1;
        top: 0;
        left: 0;
    }

    .workout-info {
        position: absolute;
        left: 1rem;
        bottom: 0.3rem;
        font-weight: bold;
        color: white;
    }

</style>