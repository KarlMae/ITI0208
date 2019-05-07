<template>
  <div>
    <div id="header" class="header">
      <span v-on:click="openNav"><img src="../assets/icons/menu.svg" alt="alt" class="menu-icon"></span>
      <Name class="name"/>
    </div>

    <div id="mySidenav" class="sidenav" v-bind:style="sideNavStyle">
      <a class="closebtn" v-on:click="closeNav">&times;</a>
      <a v-on:click="routeTo('home')">Home</a>
      <a v-on:click="routeTo('newWorkout')">Add workout</a>
    </div>

  </div>

</template>

<script>
  import Name from './Name'


  export default {
    name: "Header",
    components: {
      Name,
    },
    data() {
      return {
        isOpen : false
      }
    },
    computed: {
      sideNavStyle() {
        return {
          width: this.isOpen ? '180px' : '0px',
        }
      },
    },
    methods: {
      openNav() {
        this.isOpen = true;
      },
      closeNav() {
        this.isOpen = false;
      },
      routeTo(path) {
        this.$router.push({name: path});
      }
    }
  }
</script>

<style lang="scss" scoped>

  @import '../assets/colors.scss';

  p {
    margin-bottom: 0;
  }

  .header {
    min-height: 4.5rem;
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index: 2;
  }

  .name {
    color: #3a3a3a;
    font-size: 2rem;
  }

  img {
    height: 4rem;
    padding: 1rem 0;
  }


  .sidenav {
    height: 100%; /* 100% Full-height */
    width: 0; /* 0 width - change this with JavaScript */
    position: fixed; /* Stay in place */
    z-index: 2; /* Stay on top */
    top: 0; /* Stay at the top */
    left: 0;
    background-color: $primary-main;
    overflow-x: hidden; /* Disable horizontal scroll */
    padding-top: 60px; /* Place content 60px from the top */
    transition: 0.5s; /* 0.5 second transition effect to slide in the sidenav */
  }

  /* The navigation menu links */
  .sidenav a {
    padding: 8px 8px 8px 8px;
    text-decoration: none;
    font-size: 20px;
    color: #f1f1f1;
    display: block;
    transition: 0.3s;
    white-space: nowrap;
  }

  /* When you mouse over the navigation links, change their color */
  .sidenav a:hover {
    color: #ffffff;
  }

  .sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
  }

  .menu-icon, .closebtn, a {
    cursor: pointer;
  }

</style>