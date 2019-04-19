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
  training.exercises (set, repetitions, name, category, weight, duration, group_id, workout_id)
VALUES
(1, 5, 'Plank', 'Warm-up', 100, 100, 1, 1);

INSERT INTO
  training.exercises (set, repetitions, name, category, weight, duration, group_id, workout_id)
VALUES
(2, 5, 'Plank', 'Warm-up', 100, 100, 1, 1);

INSERT INTO
  training.exercises (set, repetitions, name, category, weight, duration, group_id, workout_id)
VALUES
(3, 5, 'Plank', 'Warm-up', 100, 100, 1, 1);

INSERT INTO
  training.exercises (set, repetitions, name, category, weight, duration, group_id, workout_id)
VALUES
(1, 5, 'Pushup', 'Warm-up', 100, 100, 2, 1);

INSERT INTO
  training.exercises (set, repetitions, name, category, weight, duration, group_id, workout_id)
VALUES
(2, 5, 'Pushup', 'Warm-up', 100, 100, 2, 1);

INSERT INTO
  training.exercises (set, repetitions, name, category, weight, duration, group_id, workout_id)
VALUES
(3, 5, 'Pushup', 'Warm-up', 100, 100, 2, 1);


INSERT INTO
  training.users (username, password)
VALUES
  ('r', 'l')