<template>
    <div>
        <ul v-if="posts.length">
            <li v-for="post of posts">
                <p>{{ post }}</p>
            </li>
        </ul>
        <p v-else>Error</p>
    </div>

</template>



<script>

    import axios from 'axios';

    export default {
        data() {
            return {
                posts: [],
                errors: []
            }
        },
        created() {
            axios.get('http://localhost:8090/fetchAll')
                .then(response => {
                    this.posts = response.data;
                })
                .catch(e => {
                    this.errors.push(e)
                })
        }
    }

</script>