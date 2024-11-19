INSERT INTO users(name, username, password)
VALUES ('Jhon Doe', 'jhondoe@gmail.com', '$2a$12$5MRk/Q7KPnn4qDVxvjZy.O/yOBAzpGqp6kqA5qWwFA6mlsujQd9/C'),
       ('Mike Smith', 'mikesmith@yahoo.com', '$2a$12$yc7laOOeBGeu9s5eT/E9P.NoUYdxv1YEW/iBIM/k0xQCQ2kYRGaMG');


INSERT INTO tasks(title, description, status, expiration_date)
VALUES ('Buy cheese', null, 'TODO', '2023-01-29 12:00:00'),
       ('Do homework', 'Math, Physics, Literature', 'ON_PROGRESS', '2023-01-31 00:00:00'),
       ('Clean rooms', null, 'DONE', null),
       ('Call Mike', 'Ask about meeting', 'TODO', '2023-02-01 00:00:00');


INSERT INTO users_tasks(task_id, user_id)
VALUES (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);


INSERT INTO users_roles (user_id, role)
VALUES (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');