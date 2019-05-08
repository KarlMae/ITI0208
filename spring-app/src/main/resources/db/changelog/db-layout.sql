CREATE SCHEMA training;

SET search_path TO training;

CREATE TABLE workouts (
  id SERIAL PRIMARY KEY,
  user_id INTEGER,
  name VARCHAR(255) NOT NULL,
  image VARCHAR(255)
);

CREATE TABLE exercises (
  id SERIAL PRIMARY KEY,
  group_id INTEGER NOT NULL,
  workout_id INTEGER NOT NULL,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(255) NOT NULL DEFAULT 'Main exercises',
  set INTEGER NOT NULL,
  repetitions INTEGER NOT NULL,
  weight FLOAT DEFAULT NULL,
  duration INTEGER DEFAULT NULL
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE user_workouts (
  workout_id INTEGER REFERENCES workouts(id),
  user_id INTEGER REFERENCES users(id)
);
