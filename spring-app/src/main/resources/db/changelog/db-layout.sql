CREATE SCHEMA training;

SET search_path TO training;

CREATE TABLE workouts (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255)
);

CREATE TABLE exercises (
  id SERIAL PRIMARY KEY,
  workout_id INTEGER REFERENCES workouts(id),
  name VARCHAR(255) NOT NULL,
  category VARCHAR(255) NOT NULL DEFAULT 'Main exercises',
  set INTEGER NOT NULL DEFAULT 1,
  repetitions INTEGER NOT NULL,
  weight INTEGER DEFAULT NULL,
  duration INTEGER DEFAULT NULL
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE user_workouts (
  workout_id INTEGER REFERENCES workouts(id),
  user_id INTEGER REFERENCES users(id)
);