[![Java CI with Gradle](https://github.com/IrinaChapurina/page-object/actions/workflows/gradle.yml/badge.svg)](https://github.com/IrinaChapurina/page-object/actions/workflows/gradle.yml)
## Описание приложения

### Бизнес часть

Приложение представляет из себя веб-сервис по покупку тура.

![](https://raw.githubusercontent.com/netology-code/qa-diploma/master/pic/service.png)

Приложение предлагает купить тур по определённой цене с помощью двух способов:

1. Обычная оплата по дебетовой карте
2. Уникальная технология: выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:

* сервису платежей (далее - Payment Gate)
* кредитному сервису (далее - Credit Gate)

---
## Предварительные условия для запуска автотестов

1. Для запуска проекта и тестов на локальном компьютере потребуются установленные
   Git, JDK 11, IntelliJ IDEA, Docker
3. Запустить Docker Desktop и установить необходимые образы в Docker Hub.
2. Склонировать репозиторий на локальный компьютер командой в Git:

   ```
   git clone https://github.com/IrinaChapurina/qa-diploma.git
   ```
4. Запустить IntelliJ IDEA и открыть проект.

---

### Запуск контейнеров

1. Установить и запустить необходимые базы данных, а также NodeJS. Параметры для запуска хранятся в файле `docker-compose.yml`. Для запуска необходимо ввести в терминале команду:
```
docker-compose up -d
```
2. В новой вкладке терминала ввести команду в для запуска приложения:

`java -jar .\artifacts\aqa-shop.jar --Dspring.datasource.url=jdbc:mysql://localhost:3306/app
`   - для MySQL

`java -jar .\artifacts\aqa-shop.jar --Dspring.datasource.url=jdbc:postgresql://localhost:5432/app
`   - для PostgreSQL


## Запуск тестов
В новой вкладке терминала ввести команду в зависимости от желаемой СУБД: 
`.\gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app
`   - для MySQL

`.\gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app
`   - для PostgreSQL


## Перезапуск приложения и тестов
Если необходимо перезапустить приложение и/или тесты необходимо выполнить остановку работы в запущенных ранее вкладках терминала, нажав в них Ctrl+С

## Формирование отчета AllureReport по результатам тестирования
В новой вкладке терминала или нажав двойной Ctrl ввести команду:
```
./gradlew allureServe
```
Сгенерированный отчет откроется в браузере автоматически. После просмотра и закрытия отчета можно остановить работу команды, нажав Ctrl+С или закрыть вкладку Run и нажать Disconnect.