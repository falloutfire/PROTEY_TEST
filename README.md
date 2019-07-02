# PROTEY_TEST
Тестовое задание для Протей

## Задание:

Написать серверную часть Web-приложения согласно следующим требованиям:

Средства разработки: Java 1.7 (или выше)
Инструменты: Spring Framework
Протокол: HTTP
База данных: PostgreSQL

### Функционал:
* Добавление нового пользователя. Передаем на сервер данные пользователя (имя пользователя, email, phoneNumber и т.д.). Сохраняем информацию в базе данных. Ответ сервера — уникальный ID нового пользователя
* Получение информации о пользователе. Передаем на сервер уникальный ID пользователя. Читаем информацию из базы данных. Ответ сервера — данные пользователя
* Изменение статуса пользователя (Online, Away, Offline). Передаем на сервер уникальный ID пользователя и новый статус. Изменяем статус пользователя. Ответ сервера — уникальный ID пользователя, новый и предыдущий статус
* Перевод в статус Away должен делаться автоматически через 5 минут после последнего изменения статуса на online. Таким образом, если “подтверждать” статус online пользователя каждые 5 минут - автоматического перехода в Away не должно быть

### Обязательные требования:
— RESTful
— Все данные в формате JSON
— Обработка ошибок

## База данных
В файле application.properties заменить на свое:
```
spring.datasource.url=jdbc:postgresql://{Хост}:{Порт}/{Название базы данных}
spring.datasource.username={Логин}
spring.datasource.password={Пароль}
```

## Сборка и запуск
Для сборки в JAR необходимо выполнить команду
```
./gradlew build
```
Затем запустить JAR-файл:
```
java -jar build/libs/test-1.0.jar
```
## Использование
Для получения информации обо всех пользователях:
```
curl -X GET http://localhost:8080/users/ 
```

Для получения информации об одном пользователе:
```
curl -X GET http://localhost:8080/users/{id}
```
где {id} - Id пользователя.

Для создания нового пользователя:
```
curl -X POST \
  http://localhost:8080/users/ \
  -H 'Content-Type: application/json' \
  -d '{
    "username": "user",
    "email": "123@mail.com",
    "phoneNumber": "12313"
}'
```

Для обновлнения статуса пользователя: 
```
curl -X POST \
  http://localhost:8080/users/status \
  -H 'Content-Type: application/json' \
  -d '{
	"id": 1,
	"newStatus": "Online"
}'
```
