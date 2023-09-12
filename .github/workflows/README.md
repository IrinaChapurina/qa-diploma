## Дипломный проект по профессии «Тестировщик»
Автоматизация тестирования возможности покупки тура в приложении на веб-сервисе обычной оплатой по дебетовой карте или с помощью кредита по данным банковской карты.
Приложение не обрабатывает данные по картам, а пересылает их банковским сервисам (Payment Gate, Credit Gate)
Приложение расположено в файле aqa-shop.jar и запускается стандартным способом java -jar aqa-shop.jar на порту 8080.

### Запуск
Для установки и запуска проекта, необходим NodeJS и базы данных MySQL и PostgreSQL. 
Параметры для запуска хранятся в файле docker-compose.yml. 
Запустить Docker Desktop
Открыть проект в IntelliJ IDEA
В терминале IDEA запустить контейнеры: docker-compose up-d
Для запуска необходимо ввести в терминале команду: docker-compose up
 
В новой вкладке терминала ввести следующую команды для баз данных:
* для MySQL: 
java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar
* для PostgreSQL
java -Dspring.datasource-postgresql.url=jdbc:postgresql://localhost:5432/app -jar artifacts/aqa-shop.jar
Запустить приложение app run по адресу: http://localhost:8080/

### Запуск тестов
Перейти в новую вкладку терминала и ввести команду:
* для MySQL: 
gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app
* для PostgreSQL:
gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app 

### Формирование отчета AllureReport по результатам тестирования
В новой вкладке терминала или нажав двойной Ctrl ввести команду: gradlew allureServe

Для завершения работы allureServe выполнить команду: Ctrl+C
Для остановки работы контейнеров выполнить команду: docker-compose down

