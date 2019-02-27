<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: 'app',
        components: {
        },
        data() {
            return {
                testField: String
            }
        },
        async mounted () {
            this.testField = this.axios
                .get('http://localhost:8090/')
                .then(response => (this.testField = response.data));
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