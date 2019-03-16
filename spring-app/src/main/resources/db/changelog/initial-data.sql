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
  training.exercises(name, category)
VALUES
('Jumping jacks', 'Warm-up');

INSERT INTO
  training.exercises(name)
VALUES
  ('Tuck planche');

INSERT INTO
  training.exercises(name)
VALUES
  ('Burpee');

INSERT INTO
  training.exercises(name, weight)
VALUES
('Pull up', 10);

INSERT INTO
  training.exercises(name, weight)
VALUES
('Push up', 10);

INSERT INTO
  training.exercises(name, weight)
VALUES
('Squat', 80);

INSERT INTO
  training.exercises(name, duration)
VALUES
('Plank', 30);

INSERT INTO
  training.exercises(name, weight)
VALUES
('Lunges', 20);

INSERT INTO
  training.exercises(name, category, duration)
VALUES
('Swan position', 'Cool-down', 150);




INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(1, 1, 2);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
  (2, 1, 8);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(2, 1, 7, 2);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions, set_nr)
VALUES
(2, 1, 6, 3);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
  (3, 1, 12);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(2, 3, 8);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(3, 3, 12);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(4, 3, 12);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(5, 3, 12);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(6, 3, 12);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(7, 3, 12);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(8, 3, 12);

INSERT INTO
  training.workout_exercises (exercise_id, workout_id, repetitions)
VALUES
(9, 1, 1);