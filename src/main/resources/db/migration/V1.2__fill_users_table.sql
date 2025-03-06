insert into users (id, name, email)
values (1, 'Gabe', 'gabe@maxima.com'),
(2, 'Max', 'max@maxima.com'),
(3, 'Alex', 'alex@maxima.com'),
(4, 'Ethan', 'ethan@maxima.com'),
(5, 'Jared', 'jared@maxima.com');

select setval('users_id_seq', 5, true);