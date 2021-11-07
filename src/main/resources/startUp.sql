INSERT INTO public.permission(
	id, description, name)
	VALUES (1, 'User has possibility to delete USERS.', 'DELETE_USER');
INSERT INTO public.permission(
	id, description, name)
	VALUES (2, 'User has possibility to edit USERS.', 'EDIT_USER');
INSERT INTO public.permission(
	id, description, name)
	VALUES (3, 'User has possibility to add USERS.', 'ADD_USER');
INSERT INTO public.permission(
    id, description, name)
    VALUES (4, 'User has possibility to get USERS.', 'GET_USERS');
INSERT INTO public.permission(
    id, description, name)
    VALUES (5, 'User has possibility to delete ROLES.', 'DELETE_ROLE');
INSERT INTO public.permission(
    id, description, name)
    VALUES (6, 'User has possibility to edit ROLES.', 'EDIT_ROLE');
INSERT INTO public.permission(
    id, description, name)
    VALUES (7, 'User has possibility to add ROLES.', 'ADD_ROLE');
    INSERT INTO public.permission(
    id, description, name)
    VALUES (8, 'User has possibility to get ROLES.', 'GET_ROLES');
INSERT INTO public.permission(
    id, description, name)
    VALUES (9, 'User has possibility to get TASKS.', 'DELETE_TASK');
    INSERT INTO public.permission(
    id, description, name)
    VALUES (10, 'User has possibility to get TASKS.', 'EDIT_TASK');
INSERT INTO public.permission(
    id, description, name)
    VALUES (11, 'User has possibility to get TASKS.', 'ADD_TASK');
INSERT INTO public.permission(
id, description, name)
VALUES (12, 'User has possibility to get PLACES.', 'GET_TASKS');
INSERT INTO public.permission(
id, description, name)
VALUES (13, 'User has possibility to get TASKS.', 'EDIT_PLACE');
INSERT INTO public.permission(
id, description, name)
VALUES (14, 'User has possibility to get TASKS.', 'ADD_PLACE');
INSERT INTO public.permission(
id, description, name)
VALUES (15, 'User has possibility to get TASKS.', 'DELETE_PLACE');
INSERT INTO public.permission(
id, description, name)
VALUES (16, 'User has possibility to get TASKS.', 'GET_PLACES');
INSERT INTO public.permission(
id, description, name)
VALUES (17, 'User has possibility to get TASKS.', 'EDIT_CATEGORY');
INSERT INTO public.permission(
id, description, name)
VALUES (18, 'User has possibility to get TASKS.', 'ADD_CATEGORY');
INSERT INTO public.permission(
id, description, name)
VALUES (19, 'User has possibility to get TASKS.', 'DELETE_CATEGORY');
INSERT INTO public.permission(
id, description, name)
VALUES (20, 'User has possibility to get TASKS.', 'GET_CATEGORIES');


INSERT INTO public.role(
	id, description, name)
	VALUES (101, 'Manager with all permissions in order management', 'MANAGER');
INSERT INTO public.role(
	id, description, name)
	VALUES (102, 'Standard user with no special permissions', 'USER');
INSERT INTO public.role(
	id, description, name)
	VALUES (100, 'User that has all permissions', 'ADMIN');

INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (4, 101);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (9, 101);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (10, 101);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (11, 101);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (12, 101);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (12, 102);

INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (1, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (2, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (3, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (4, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (5, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (6, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (7, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (8, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (9, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (10, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (11, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (12, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (13, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (14, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (15, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (16, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (17, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (18, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (19, 100);
INSERT INTO public.role_permissions(
	permission_id, role_id)
	VALUES (20, 100);

INSERT INTO public.account(
    id, username, password, email, is_activated)
    VALUES (1000000, 'user1', '$2a$10$5P2URNSo/nu0wIwR7dirNO.M5xJr8/JXrKA7vfLn0QBvcQXNjAUSe', 'user1@test.com', true);

INSERT INTO public.account(
    id, username, password, email, is_activated)
    VALUES (1000001, 'user2', '$2a$10$5P2URNSo/nu0wIwR7dirNO.M5xJr8/JXrKA7vfLn0QBvcQXNjAUSe', 'user2@test.com', true);

INSERT INTO public.account(
    id, username, password, email, is_activated)
    VALUES (1000002, 'user3', '$2a$10$5P2URNSo/nu0wIwR7dirNO.M5xJr8/JXrKA7vfLn0QBvcQXNjAUSe', 'user3@test.com', true);

INSERT INTO public.VERIFICATION_TOKEN(
    id, token, account_id)
    VALUES (1000000, 'token', 1000000);

INSERT INTO public.backend_user(
    id, name, surname, role_id, account_id)
    VALUES (1000000, 'Klient', 'Nazwisko', 102, 1000000);

INSERT INTO public.backend_user(
    id, name, surname, role_id, account_id)
    VALUES (1000001, 'Menedżer', 'Nazwisko', 101, 1000001);

INSERT INTO public.backend_user(
    id, name, surname, role_id, account_id)
    VALUES (1000002, 'Admin', 'Nazwisko', 100, 1000002);