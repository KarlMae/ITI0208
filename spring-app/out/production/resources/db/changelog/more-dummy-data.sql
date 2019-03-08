INSERT INTO
  training.workouts(name, description)
VALUES
  ('Demo workout', 'Best workout for demo purposes');

INSERT INTO
  training.exercises(name, category)
VALUES
  ('Pull up', 'Compound exercise');

INSERT INTO
  training.exercises(name, category)
VALUES
  ('Push up', 'Compound exercise');


INSERT INTO
  training.exercises(name, category)
VALUES
  ('Squat', 'Compound exercise');

INSERT INTO
  training.exercises(name, category)
VALUES
  ('Plank', 'Compound exercise');


INSERT INTO
  training.exercises(name, category)
VALUES
  ('Lunges', 'Compound exercise');


INSERT INTO
  "training"."workout_exercises" ("exercise_id", "workout_id", "repetitions", "sets")
VALUES
  (1, 3, 8, 4);

INSERT INTO
  "training"."workout_exercises" ("exercise_id", "workout_id", "repetitions", "sets")
VALUES
  (2, 3, 12, 3);

INSERT INTO
  "training"."workout_exercises" ("exercise_id", "workout_id", "repetitions", "sets")
VALUES
  (3, 3, 12, 3);

INSERT INTO
  "training"."workout_exercises" ("exercise_id", "workout_id", "repetitions", "sets")
VALUES
  (4, 3, 12, 3);

INSERT INTO
  "training"."workout_exercises" ("exercise_id", "workout_id", "repetitions", "sets")
VALUES
  (5, 3, 12, 3);

INSERT INTO
  "training"."workout_exercises" ("exercise_id", "workout_id", "repetitions", "sets")
VALUES
  (6, 3, 12, 3);

INSERT INTO
  "training"."workout_exercises" ("exercise_id", "workout_id", "repetitions", "sets")
VALUES
  (7, 3, 12, 3);