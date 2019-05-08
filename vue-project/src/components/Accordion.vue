<template>
  <b-card no-body class="mb-1">
    <b-card-header header-tag="header" class="p-1" role="tab">
      <b-button block v-b-toggle="'accordion-' + group" variant="secondary">{{ group }}</b-button>
    </b-card-header>
    <b-collapse :id="'accordion-' + group" accordion="my-accordion" role="tabpanel">
      <b-card-body>
        <template v-for="exercise in workout">
          <p class="exercise">{{ exercise.name }}</p>
        </template>
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
  .exercise {
    margin-bottom: 1rem;
    margin-top: 1rem;
  }

  .card-body {
    padding: 0;
  }
</style>