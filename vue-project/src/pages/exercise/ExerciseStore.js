import * as Cookies from 'js-cookie';

export var exerciseStore = {
  state: {
    exerciseGroups: [],
    exerciseIndex: 0,
    setIndex: 0,
    isEditModalVisible: false
  },

  setWorkout(workout) {
    this.state.exerciseGroups = workout.exerciseGroups;
    this.state.exerciseIndex = workout.exerciseIndex | 0;

    Cookies.set('state', this.state)
  },
  nextExercise() {
    this.state.exerciseIndex += 1;
    Cookies.set('state', this.state)
  },
  previousExercise() {
    this.state.exerciseIndex -= 1;
    Cookies.set('state', this.state)
  },
  getExercise() {
    return this.state.exerciseGroups[this.state.exerciseIndex];
  },
  updateCurrentExercise(exercise) {
    debugger;
    this.state.exerciseGroups[this.state.exerciseIndex] = exercise;
  },
  previousExercisePresent() {
    return this.state.exerciseIndex > 0;
  },
  nextExercisePresent() {
    return this.state.exerciseIndex < this.state.exerciseGroups.length - 1;
  },
  toggleEditModal() {
    this.state.isEditModalVisible = !this.state.isEditModalVisible;
  },
  isEditModalVisible() {
    return this.state.isEditModalVisible;
  }
};