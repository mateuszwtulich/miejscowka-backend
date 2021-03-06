-- PERMISSIONS
INSERT INTO public.permission(id, description, name)
VALUES (1, 'User has possibility to delete USERS.', 'DELETE_USER');
INSERT INTO public.permission(id, description, name)
VALUES (2, 'User has possibility to edit USERS.', 'EDIT_USER');
INSERT INTO public.permission(id, description, name)
VALUES (3, 'User has possibility to add USERS.', 'ADD_USER');
INSERT INTO public.permission(id, description, name)
VALUES (4, 'User has possibility to get USERS.', 'GET_USERS');
INSERT INTO public.permission(id, description, name)
VALUES (5, 'User has possibility to delete ROLES.', 'DELETE_ROLE');
INSERT INTO public.permission(id, description, name)
VALUES (6, 'User has possibility to edit ROLES.', 'EDIT_ROLE');
INSERT INTO public.permission(id, description, name)
VALUES (7, 'User has possibility to add ROLES.', 'ADD_ROLE');
INSERT INTO public.permission(id, description, name)
VALUES (8, 'User has possibility to get ROLES.', 'GET_ROLES');
INSERT INTO public.permission(id, description, name)
VALUES (13, 'User has possibility to get PLACES.', 'EDIT_PLACE');
INSERT INTO public.permission(id, description, name)
VALUES (14, 'User has possibility to get PLACES.', 'ADD_PLACE');
INSERT INTO public.permission(id, description, name)
VALUES (15, 'User has possibility to get PLACES.', 'DELETE_PLACE');
INSERT INTO public.permission(id, description, name)
VALUES (16, 'User has possibility to get PLACES.', 'GET_PLACES');
INSERT INTO public.permission(id, description, name)
VALUES (17, 'User has possibility to get TASKS.', 'EDIT_CATEGORY');
INSERT INTO public.permission(id, description, name)
VALUES (18, 'User has possibility to get TASKS.', 'ADD_CATEGORY');
INSERT INTO public.permission(id, description, name)
VALUES (19, 'User has possibility to get TASKS.', 'DELETE_CATEGORY');
INSERT INTO public.permission(id, description, name)
VALUES (20, 'User has possibility to get TASKS.', 'GET_CATEGORIES');
INSERT INTO public.permission(id, description, name)
VALUES (21, 'User has possibility to get favourite places.', 'GET_FAVOURITE');
INSERT INTO public.permission(id, description, name)
VALUES (22, 'User has possibility to perform administrator tasks.', 'A_CRUD_SUPER');
-- ROLES
INSERT INTO public.role(id, description, name)
VALUES (102, 'Standard user with no special permissions', 'USER');
INSERT INTO public.role(id, description, name)
VALUES (100, 'User that has all permissions', 'ADMIN');
-- ROLE-PERMISSION
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (21, 102);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (22, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (21, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (1, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (2, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (3, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (4, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (5, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (6, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (7, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (8, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (13, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (14, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (15, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (16, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (17, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (18, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (19, 100);
INSERT INTO public.role_permissions(permission_id, role_id)
VALUES (20, 100);
-- ACCOUNTS
INSERT INTO public.account(id, username, password, email, is_activated)
VALUES (1000000, 'user1', '$2a$10$5P2URNSo/nu0wIwR7dirNO.M5xJr8/JXrKA7vfLn0QBvcQXNjAUSe', 'user1@test.com', true);
INSERT INTO public.account(id, username, password, email, is_activated)
VALUES (1000002, 'admin', '$2a$10$5P2URNSo/nu0wIwR7dirNO.M5xJr8/JXrKA7vfLn0QBvcQXNjAUSe', 'admin@test.com', true);
INSERT INTO public.VERIFICATION_TOKEN(id, token, account_id)
VALUES (1000000, 'token', 1000000);
INSERT INTO public.backend_user(id, name, surname, role_id, account_id)
VALUES (1000000, 'Klient', 'Nazwisko', 102, 1000000);
INSERT INTO public.backend_user(id, name, surname, role_id, account_id)
VALUES (1000002, 'Admin', 'Nazwisko', 100, 1000002);
-- CATEGORIES
INSERT INTO public.category(id, name, description)
VALUES (1000000, 'Restauracja', 'Restauracja');
INSERT INTO public.category(id, name, description)
VALUES (1000001, 'Bar', 'Bar');
INSERT INTO public.category(id, name, description)
VALUES (1000002, 'Basen', 'Basen');
INSERT INTO public.category(id, name, description)
VALUES (1000003, 'Si??owania', 'Si??ownia');
INSERT INTO public.category(id, name, description)
VALUES (1000004, 'Hala sportowa', 'Hala sportowa');
INSERT INTO public.category(id, name, description)
VALUES (1000005, 'Billard Club', 'Billard Club');
INSERT INTO public.category(id, name, description)
VALUES (1000006, 'Biblioteka', 'Biblioteka');
-- PLACES
INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000000, 'Cybermachina', 52, null, 23, 'Szczytnicka', 1000001,
        'Cybermachina - pub inny ni?? wszystkie! Gry planszowe i na konsole bez dodatkowych op??at, wy??mienite piwo i smaczne drinki, a nad dobr?? zabaw?? czuwa zesp???? pomocnych barman??w. Wst??p tylko dla pe??noletnich!');

INSERT INTO public.place_image(
    id, url, place_id)
    VALUES (1000000, 'https://i.imgur.com/k2d5AeC.jpg', 1000000);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000000, '2021-11-20', 13, 60);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000000, '16:00', '23:00', '16:00', '23:00', '16:00', '23:00', '16:00', '1:00', '16:00', '1:00', '16:00',
        '1:00', '16:00', '1:00');

INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000001, 'Remont', 20, null, 26, 'plac Grunwaldzki', 1000000,
        'Pyszne dania i przek??ski w sta??ym menu oraz codziennie inna zupa, danie dnia. Do tego dobre piwo, lu??na atmosfera, stylowe wn??trze i studencki klimat.');

INSERT INTO public.place_image(
    id, url, place_id)
    VALUES (1000001, 'https://i.imgur.com/1cGPCkE.jpg', 1000001);


INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000001, '2021-11-20', 8, 36);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000001, '16:00', '23:00', '16:00', '23:00', '16:00', '23:00', '16:00', '1:00', '16:00', '1:00', '16:00',
        '1:00', '16:00', '1:00');

INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000002, 'Pizzeria Bravo', 18, null, 30, 'plac Grunwaldzki', 1000000,
        'Pizzeria BRAVO - przestronny lokal z klimatem, skierowany mi??dzy innymi do student??w. S??yniemy z wy??mienitej i zawsze gor??cej pizzy, na kt??r?? nie czeka si?? d??ugo i nie p??aci du??o. Znajdujemy si?? w samym sercu Placu Grunwaldzkiego.');

INSERT INTO public.place_image(
    id, url, place_id)
    VALUES (1000002, 'https://i.imgur.com/f2a9xPs.jpg', 1000002);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000002, '2021-11-20', 15, 50);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000002, '16:00', '23:00', '16:00', '23:00', '16:00', '23:00', '16:00', '1:00', '16:00', '1:00', '16:00',
        '1:00', '16:00', '1:00');

INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000003, 'Fuga Mundi', 12, null, 40, 'plac Grunwaldzki', 1000005,
        'Klub sk??ada si?? z 5 sal: sali g????wnej, gdzie usytuowany jest bar i 7 sto????w pool-bilardowych, sal?? poolow?? z 8 sto??ami do gry, sal?? snookerow?? z 3 sto??ami do gry snookera, salk?? VIP.');

INSERT INTO public.place_image(
    id, url, place_id)
    VALUES (1000003, 'https://i.imgur.com/ypUSNi1.jpg', 1000003);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000003, '2021-11-20', 30, 77);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000003, '16:00', '23:00', '16:00', '23:00', '16:00', '23:00', '16:00', '1:00', '16:00', '1:00', '16:00',
        '1:00', '16:00', '1:00');

INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000004, 'Basen GEM', 2, null, 30, 'J??zefa Mianowskiego', 1000002,
        'Zapraszamy do korzystania z obiekt??w sportowych na terenie Hotelu Gem: basen kryty, korty tenisowe, hala wielofunkcyjna, sala fitness, boiska pi??karskie, siatk??wka pla??owa.');

INSERT INTO public.place_image(
    id, url, place_id)
    VALUES (1000004, 'https://i.imgur.com/l2eDx5O.jpg', 1000004);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000004, '2021-11-20', 5, 15);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000004, '16:00', '23:00', '16:00', '23:00', '16:00', '23:00', '16:00', '1:00', '16:00', '1:00', '16:00',
        '1:00', '16:00', '1:00');
-- BIBLIOTEKA 1
INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000005, 'Biblioteka miejska', 2, null, 40, 'Wyszy??skiego', 1000006,
        'Biblioteka z ksi????kami');

INSERT INTO public.place_image(
    id, url, place_id)
    VALUES (1000005, 'https://i.imgur.com/888WDdE.jpg', 1000005);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000005, '2021-11-20', 8, 20);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000005, '8:00', '18:00', '8:00', '18:00', '8:00', '18:00', '8:00', '18:00', '8:00', '18:00', '8:00',
        '14:00', '8:00', '14:00');

-- BIBLIOTEKA 2
INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000006, 'Biblioteka Uniwersytetu Wroc??awskiego', 31, null, 100, 'Ko????taja', 1000006,
        'Biblioteka z ksi????kami');

INSERT INTO public.place_image(
    id, url, place_id)
    VALUES (1000006, 'https://i.imgur.com/cjxngEb.jpg', 1000006);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000006, '2021-11-20', 33, 33);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000006, '8:00', '18:00', '8:00', '18:00', '8:00', '18:00', '8:00', '18:00', '8:00', '18:00', '8:00',
        '14:00', '8:00', '14:00');

-- HALA_ORBITA
INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000007, 'Hala Orbita', 1, null, 300, 'Wroc??awska', 1000004,
        'Siownie, Baseny, Korty Tenisowe, Bar');

INSERT INTO public.place_image(
    id, url, place_id)
    VALUES (1000007, 'https://i.imgur.com/y6plTvY.jpg', 1000007);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000007, '2021-11-20', 50, 16);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000007, '6:00', '23:00', '6:00', '23:00', '6:00', '23:00', '6:00', '23:00', '6:00', '23:00', '6:00', '23:00',
        '6:00', '23:00');