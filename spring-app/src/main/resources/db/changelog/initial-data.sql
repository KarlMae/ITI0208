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
  training.exercises (workout_id, set, repetitions, name, category, weight, duration)
VALUES
(1, 1, 5, 'Plank', 'Warm-up', 100, 100);


INSERT INTO
  training.exercises (workout_id, set, repetitions, name, category, weight, duration)
VALUES
(1, 2, 5, 'Plank', 'Warm-up', 100, 100);


INSERT INTO
  training.exercises (workout_id, set, repetitions, name, category, weight, duration)
VALUES
(1, 3, 5, 'Plank', 'Warm-up', 100, 100);


INSERT INTO
  training.exercises (workout_id, set, repetitions, name, category, weight, duration)
VALUES
(1, 1, 5, 'Pushup', 'Main exercises', 20, null);

INSERT INTO
  training.exercises (workout_id, set, repetitions, name, category, weight, duration)
VALUES
(1, 2, 5, 'Pushup', 'Main exercises', null, 30);


INSERT INTO
  training.exercises (workout_id, set, repetitions, name, category)
VALUES
(1, 3, 5, 'Pushup', 'Main exercises');
