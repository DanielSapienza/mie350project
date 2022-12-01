
-- Hello everyone! Please remember to only use SINGLE quotations and ADD A SEMICOLON


INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (1111, 'Daniel', 'Sapienza', 20, 176.0, 135.0, '111');

INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (1111, 1, 'March4,2022', 'arm day', 2.5, 3);

INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (1111, 'Breakfast', 'January3,2022', 'eggs and toast', 300, 20.6, 34.5, 19.5, 12.7);

INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (1111, 'February10,2022', 6.5, 4, true, false, 90);

INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (1111, 1, 'I want to improve my sleep schedule and get over 6 hours more regularly.', 4, 'I have been going to bed a lot earlier and feel much more rested!');