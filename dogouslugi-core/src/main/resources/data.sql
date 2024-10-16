-- banners
INSERT INTO banner (id, bg, title, text, imgurl)
values (0,
        'linear-gradient(86deg, #FFFEDD 0%, #8B4513  100%)',
        'Открыта вакансия',
        'Ищем в команду лучшего песика для разработки dogуслуг',
        'corgi9.png');
INSERT INTO banner (id, bg, title, text, imgurl)
values (1,
        'linear-gradient(86deg, #8B4513 0%, #FFFEDD 60%, #8B4513 100%)',
        'Хотите завести щеночка?',
        'Услуга «Верный друг» поможет подобрать собачий-приют и щенка',
        'corgi18.png');
INSERT INTO banner (id, bg, title, text, imgurl)
values (2,
        'linear-gradient(86deg, #8B4513 0%, #FFFEDD  100%)',
        'Как избавится от шерсти в доме?',
        'Услуга «Груминг» поможет подобрать необходимый уход за собачкой',
        'corgi.png');

-- dog
INSERT INTO dog (id, name, age, sex, breed)
values (0,
        'Шон',
        '1',
        'male',
        'labrador_retriever');
INSERT INTO dog (id, name, age, sex, breed)
values (1,
        'Пуля',
        '1',
        'female',
        'bully');

-- service
INSERT INTO service(id, mnemonic, icon, title, description)
values (0,
        'new_family',
        'corgi19.png',
        'Верный друг',
        'Начните дружбу на лапках — мы поможем выбрать верного друга!');
INSERT INTO service(id, mnemonic, icon, title, description)
values (1,
        'vet',
        'corgi11.png',
        'Запись на прием к ветеринару',
        'Подходи ответственно к здоровью собачки. Здоровый он - счастливы вы');
INSERT INTO service(id, mnemonic, icon, title, description)
values (2,
        'spa',
        'corgi5.png',
        'SPA-процедуры',
        'СПА-день для пушистых — блаженство для питомцев, спокойствие для вас!');
INSERT INTO service(id, mnemonic, icon, title, description)
values (3,
        'grooming',
        'corgi7.png',
        'Груминг',
        'Устали от бесконечной линьки? Пора записать  песика к нам');

-- category
INSERT INTO category
values (0, 'Семья');
INSERT INTO category
values (1, 'Медицина');
INSERT INTO category
values (2, 'Отдых и развлечение');
INSERT INTO category
values (3, 'Уход');

-- service_to_category
INSERT INTO service_category
values (0, 0);
INSERT INTO service_category
values (1, 1);
INSERT INTO service_category
values (2, 2);
INSERT INTO service_category
values (3, 3);
