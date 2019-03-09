INSERT INTO
  training.workouts(name, description)
VALUES
  ('Planche basics', 'The most popular calisthenics move');

INSERT INTO
  training.workouts(name, description)
VALUES
  ('Killer workout 5000', 'Väga ull workout');

INSERT INTO
  training.workouts(name, description)
VALUES
('Demo workout', 'Best workout for demo purposes');



INSERT INTO
  training.exercises(name, category, unit)
VALUES
  ('Tuck planche', 'Compound exercise', 0);

INSERT INTO
  training.exercises(name, category, unit)
VALUES
  ('Burpee', 'Compound exercise', 0);

INSERT INTO
  training.exercises(name, category, unit)
VALUES
('Pull up', 'Compound exercise', 10);

INSERT INTO
  training.exercises(name, category, unit)
VALUES
('Push up', 'Compound exercise', 10);

INSERT INTO
  training.exercises(name, category, unit)
VALUES
('Squat', 'Compound exercise', 80);

INSERT INTO
  training.exercises(name, category, unit)
VALUES
('Plank', 'Compound exercise', 30);

INSERT INTO
  training.exercises(name, category, unit)
VALUES
('Lunges', 'Compound exercise', 20);



INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
  (1, 1, 8, 1);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(1, 1, 7, 2);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(1, 1, 6, 3);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
  (2, 1, 12, 1);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(1, 3, 8, 1);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(2, 3, 12, 1);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(3, 3, 12, 1);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(4, 3, 12, 1);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(5, 3, 12, 1);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(6, 3, 12, 1);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(7, 3, 12, 1);