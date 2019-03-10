import * as Cookies from 'js-cookie';

export var exerciseStore = {
  state: {
    exercises: [],
    exerciseIndex: 0,
  },

  setWorkout(workout) {
    this.state.exercises = workout.exercises;
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
    return this.state.exercises[this.state.exerciseIndex];
  },
  previousExercisePresent() {
    return this.state.exerciseIndex > 0;
  },
  nextExercisePresent() {
    return this.state.exerciseIndex < this.state.exercises.length - 1;
  }
};