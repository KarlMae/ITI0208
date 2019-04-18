<template>
  <div>
    <div id="header" class="header">
      <span v-on:click="openNav"><img src="../assets/icons/menu.svg" alt="alt" class="menu-icon"></span>
      <Name class="name"/>
    </div>

    <div id="mySidenav" class="sidenav">
      <a href="javascript:void(0)" class="closebtn" v-on:click="closeNav">&times;</a>
      <a v-on:click="routeTo('home')">Home</a>
      <a v-on:click="routeTo('login')">Login</a>
      <a v-on:click="routeTo('newWorkout')">Add workout</a>
      <a v-on:click="routeTo('secretPage')">Secret</a>
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
    methods: {
      openNav() {
        document.getElementById("mySidenav").style.width = "180px";
      },
      closeNav() {
        document.getElementById("mySidenav").style.width = "0";
      },
      routeTo(path) {
        this.$router.push({name: path});
      }
    }
  }
</script>

<style lang="scss" scoped>

  @import '../assets/colors.scss';

  .header {
    min-height: 4.5rem;
    width: 100%;
    display: flex;
  }

  .name {
    color: #3a3a3a;
    font-size: 2rem;
    margin-top: auto;
    margin-bottom: auto;
    margin-right: 36px;
    white-space: nowrap;
  }

  img {
    width: 4rem;
    height: 4rem;
    padding: 1rem;
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

  .menu-icon {
    cursor: pointer;
  }

</style>