<template>
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block v-b-toggle="'accordion-' + group" variant="secondary">{{ group }}</b-button>
      </b-card-header>
      <b-collapse :id="'accordion-' + group" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <ul v-if="workout">

              <li v-for="exercise in workout" :key="exercise.id" class="exercise-list">
                <p>{{ exercise.name }}</p>
              </li>

          </ul>
        </b-card-body>
      </b-collapse>
    </b-card>
</template>

<script>


  export default {
    name: "Accordion",
    data() {
      return {
        groupNames: [
        'Warm-up',
        'Main exercises',
        'Cool-down'
        ]
      }
    },
    props: {
      workout: Array,
      group: String
    },
  }
</script>

<style scoped>

</style>