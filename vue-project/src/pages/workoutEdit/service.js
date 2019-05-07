import axios from 'axios';

async function insert(workout) {
  let workoutId;

  await axios.post(process.env.VUE_APP_BACKEND_IP + '/workout/insert', workout)
    .then(function (response) {
      workoutId = response.data.id;
    })
    .catch(e => {
      this.errors.push(e)
    });

  return workoutId;
}

async function update(workout) {
  let workoutId;

  await axios.post(process.env.VUE_APP_BACKEND_IP + '/workout/update', workout)
    .then(function (response) {
      workoutId = response.data.id;
    })
    .catch(e => {
      this.errors.push(e)
    });

  return workoutId;
}

export async function sendRequest(workout, path) {
  if (path === '/workoutEdit') {
    return update(workout)
  } else {
    return insert(workout)
  }
}