## [REST API](http://localhost:8080/doc)

## Концепция:

- Spring Modulith
    - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
    - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
    - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```

- Есть 2 общие таблицы, на которых не fk
    - _Reference_ - справочник. Связь делаем по _code_ (по id нельзя, тк id привязано к окружению-конкретной базе)
    - _UserBelong_ - привязка юзеров с типом (owner, lead, ...) к объекту (таска, проект, спринт, ...). FK вручную будем
      проверять

## Аналоги

- https://java-source.net/open-source/issue-trackers

## Тестирование

- https://habr.com/ru/articles/259055/

Список выполненных задач:
1. Выполнено.
2. Выполнено.
3. Выполнено.
4. Выполнено.
Тесты можно запускать в профилях "h2" и "pg". Профиль следует задавать в переменных окружения.<br>
SPRING_PROFILES_ACTIVE=h2<br>или<br>SPRING_PROFILES_ACTIVE=pg, предварительно запустив контейнер с сервером тестовой БД
```shell
docker-compose up -d postgres-db-test
```

Название одной из колонок таблицы "contact" пришлось
поменять, так как "value" в h2 является зарезервированным словом.

5. Выполнено.
6. Выполнено.
7. Выполнено.<br>
Для просмотра всех назначенных задаче тэгов необходимо отправить GET-запрос по адресу <br>[/api/tags/{taskId}]()<br>
Для того, чтобы назначить задаче тэги необходимо отправить PATCH-запрос по адресу <br>[/api/tags/{taskId}]()<br>
Для того, чтобы найти все задачи с определенными тегами необходимо отправить GET-запрос по адресу <br>[/api/tags/tasks]()<br>

8. Выполнено. Для получения значения времени необходимо отправить GET-запрос вида <br>[/api/tasks/time-in-testing/{taskId}]()<br>или<br>[/api/tasks/time-in-progress/{taskId}]()<br>
Результатом запроса будет значение времени выполнения в формате часы:минуты:секунды.

9. Выполнено.
10. Выполнено.
```shell
mvn clean install
```
```shell
docker-compose up
```
```shell
docker-compose stop
```
```shell
docker-compose down
```
11. Выполнено. Для проверки: <br>http://localhost:8080/?lang=en <br> http://localhost:8080/?lang=ru


***Приложение всегда необходимо запускать со следующими переменными окружения***:
```
DB_URL=jdbc:postgresql://localhost:5432/jira
DB_USER=jira
DB_PWD=JiraRush
SPRING_URL=http://localhost:8080
E_PG_DATA=/var/lib/postgresql/data/pgdata
E_DB=jira
E_DB_TEST=jira-test
E_CLIENT_ID_GITHUB=3d0d8738e65881fff266
E_CLIENT_ID_GOOGLE=329113642700-f8if6pu68j2repq3ef6umd5jgiliup60.apps.googleusercontent.com
E_CLIENT_ID_GITLAB=b8520a3266089063c0d8261cce36971defa513f5ffd9f9b7a3d16728fc83a494
E_MAIL_HOST=smtp.gmail.com
E_MAIL_USERNAME=jira4jr@gmail.com
E_MAIL_PASSWORD=zdfzsrqvgimldzyj
E_MAIL_PORT=587
SPRING_PROFILES_ACTIVE=prod
```
***При тестировании вместо "prod" следует выбрать профиль "pg"***:
```
DB_URL=jdbc:postgresql://localhost:5432/jira
DB_USER=jira
DB_PWD=JiraRush
SPRING_URL=http://localhost:8080
E_PG_DATA=/var/lib/postgresql/data/pgdata
E_DB=jira
E_DB_TEST=jira-test
E_CLIENT_ID_GITHUB=3d0d8738e65881fff266
E_CLIENT_ID_GOOGLE=329113642700-f8if6pu68j2repq3ef6umd5jgiliup60.apps.googleusercontent.com
E_CLIENT_ID_GITLAB=b8520a3266089063c0d8261cce36971defa513f5ffd9f9b7a3d16728fc83a494
E_MAIL_HOST=smtp.gmail.com
E_MAIL_USERNAME=jira4jr@gmail.com
E_MAIL_PASSWORD=zdfzsrqvgimldzyj
E_MAIL_PORT=587
SPRING_PROFILES_ACTIVE=pg
```
***Или "h2"***:
```
DB_URL=jdbc:postgresql://localhost:5432/jira
DB_USER=jira
DB_PWD=JiraRush
SPRING_URL=http://localhost:8080
E_PG_DATA=/var/lib/postgresql/data/pgdata
E_DB=jira
E_DB_TEST=jira-test
E_CLIENT_ID_GITHUB=3d0d8738e65881fff266
E_CLIENT_ID_GOOGLE=329113642700-f8if6pu68j2repq3ef6umd5jgiliup60.apps.googleusercontent.com
E_CLIENT_ID_GITLAB=b8520a3266089063c0d8261cce36971defa513f5ffd9f9b7a3d16728fc83a494
E_MAIL_HOST=smtp.gmail.com
E_MAIL_USERNAME=jira4jr@gmail.com
E_MAIL_PASSWORD=zdfzsrqvgimldzyj
E_MAIL_PORT=587
SPRING_PROFILES_ACTIVE=h2
```