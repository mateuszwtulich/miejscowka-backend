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
VALUES (1000003, 'Siłowania', 'Siłownia');
INSERT INTO public.category(id, name, description)
VALUES (1000004, 'Hala sportowa', 'Hala sportowa');
INSERT INTO public.category(id, name, description)
VALUES (1000005, 'Billard Club', 'Billard Club');
INSERT INTO public.category(id, name, description)
VALUES (1000006, 'Biblioteka', 'Biblioteka');
-- PLACES
INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000000, 'Cybermachina', 52, null, 23, 'Szczytnicka', 1000001,
        'Cybermachina - pub inny niż wszystkie! Gry planszowe i na konsole bez dodatkowych opłat, wyśmienite piwo i smaczne drinki, a nad dobrą zabawą czuwa zespół pomocnych barmanów. Wstęp tylko dla pełnoletnich!');

INSERT INTO public.place_image(id, url, place_id)
VALUES (1000000, 'https://media-cdn.tripadvisor.com/media/photo-s/0d/0b/25/33/getlstd-property-photo.jpg', 1000000);

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
        'Pyszne dania i przekąski w stałym menu oraz codziennie inna zupa, danie dnia. Do tego dobre piwo, luźna atmosfera, stylowe wnętrze i studencki klimat.');

INSERT INTO public.place_image(id, url, place_id)
VALUES (1000001, 'https://media-cdn.tripadvisor.com/media/photo-s/11/aa/29/05/remont-bar-w-nowej-odslonie.jpg',
        1000001);

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
        'Pizzeria BRAVO - przestronny lokal z klimatem, skierowany między innymi do studentów. Słyniemy z wyśmienitej i zawsze gorącej pizzy, na którą nie czeka się długo i nie płaci dużo. Znajdujemy się w samym sercu Placu Grunwaldzkiego.');

INSERT INTO public.place_image(id, url, place_id)
VALUES (1000002, 'https://media-cdn.tripadvisor.com/media/photo-s/11/aa/29/05/remont-bar-w-nowej-odslonie.jpg',
        1000002);

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
        'Klub składa się z 5 sal: sali głównej, gdzie usytuowany jest bar i 7 stołów pool-bilardowych, salę poolową z 8 stołami do gry, salę snookerową z 3 stołami do gry snookera, salkę VIP.');

INSERT INTO public.place_image(id, url, place_id)
VALUES (1000003, 'https://media-cdn.tripadvisor.com/media/photo-s/0d/0b/25/33/getlstd-property-photo.jpg', 1000003);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000003, '2021-11-20', 30, 77);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000003, '16:00', '23:00', '16:00', '23:00', '16:00', '23:00', '16:00', '1:00', '16:00', '1:00', '16:00',
        '1:00', '16:00', '1:00');

INSERT INTO public.place(id, name, building_number, apartment_number, capacity, street, CATEGORY_ID, description)
VALUES (1000004, 'Basen GEM', 2, null, 30, 'Józefa Mianowskiego', 1000002,
        'Zapraszamy do korzystania z obiektów sportowych na terenie Hotelu Gem: basen kryty, korty tenisowe, hala wielofunkcyjna, sala fitness, boiska piłkarskie, siatkówka plażowa.');

INSERT INTO public.place_image(id, url, place_id)
VALUES (1000004, 'http://www.gemhotel.pl/sites/default/files/20141208/DSC05252.jpg', 1000004);

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
VALUES (1000005, 'Biblioteka miejska', 2, null, 40, 'Wyszyńskiego', 1000006,
        'Biblioteka z książkami');

INSERT INTO public.place_image(id, url, place_id)
VALUES (1000005, 'https://upload.wikimedia.org/wikipedia/commons/0/07/Dolnoslaska_Biblioteka_Publiczna_1.JPG', 1000005);

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
VALUES (1000006, 'Biblioteka Uniwersytetu Wrocławskiego', 31, null, 100, 'Kołątaja', 1000006,
        'Biblioteka z książkami');

INSERT INTO public.place_image(id, url, place_id)
VALUES (1000006,
        'https://upload.wikimedia.org/wikipedia/commons/a/a4/Wroclaw_University_Library_2017_%28cropped%29.jpg',
        1000006);

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
VALUES (1000007, 'Hala Orbita', 1, null, 300, 'Wrocławska', 1000004,
        'Siownie, Baseny, Korty Tenisowe, Bar');

INSERT INTO public.place_image(id, url, place_id)
VALUES (1000007, 'https://www.wroclaw.pl/twg2017/files/news/hala-orbita9-jpg.jpg', 1000007);

INSERT INTO public.occupancy(place_id, time_id, number_of_people, percentage)
VALUES (1000007, '2021-11-20', 50, 16);

INSERT INTO public.opening_hours(place_id, monday_opening_hour, monday_closing_hour, tuesday_opening_hour,
                                 tuesday_closing_hour, wednesday_opening_hour, wednesday_closing_hour,
                                 thursday_opening_hour, thursday_closing_hour, friday_opening_hour, friday_closing_hour,
                                 saturday_opening_hour, saturday_closing_hour, sunday_opening_hour, sunday_closing_hour)
VALUES (1000007, '6:00', '23:00', '6:00', '23:00', '6:00', '23:00', '6:00', '23:00', '6:00', '23:00', '6:00', '23:00',
        '6:00', '23:00');