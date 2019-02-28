<template>
    <div id="header" class="header">
        <img src="../assets/menu-logo.svg">
        <Name class="name"></Name>
    </div>
</template>

<script>

    import Name from './Name'

    export default {
        name: "Header",
        components: {
            Name
        }
    }

</script>

<style scoped>

    .header {
        min-height: 4rem;
        width: 100%;
        background-color: #CC2A49;
        padding: 1rem;
        display: flex;
    }

    .name {
        color: aliceblue;
        font-size: 4rem;
    }

</style>