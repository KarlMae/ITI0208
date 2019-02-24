CREATE SCHEMA training;

SET search_path TO training;

CREATE TABLE exercises (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(255)
);

CREATE TABLE workouts (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255)
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE workout_exercises (
  exercise_id INTEGER REFERENCES exercises(id),
  workout_id INTEGER REFERENCES workouts(id),
  repetitions INTEGER,
  sets INTEGER
);

CREATE TABLE user_workouts (
  workout_id INTEGER REFERENCES workouts(id),
  user_id INTEGER REFERENCES users(id)
);