CREATE SCHEMA training;

CREATE TABLE training.exercises (
  id INTEGER,
  name VARCHAR(255),
  category VARCHAR(255)
);

CREATE TABLE training.workouts (
  id INTEGER,
  name VARCHAR(255),
  description VARCHAR(255)
);


CREATE TABLE training.users (
  id INTEGER,
  usernam VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE training.workout_exercises (
  exercise_id INTEGER,
  workout_id INTEGER,
  repetitions INTEGER,
  sets INTEGER
);

CREATE TABLE training.user_workouts (
  workout_id INTEGER,
  user_id INTEGER
);