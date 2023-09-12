## Дипломный проект по профессии «Тестировщик»
Автоматизация тестирования возможности покупки тура в приложении на веб-сервисе обычной оплатой по дебетовой карте или с помощью кредита по данным банковской карты.<br>
Приложение не обрабатывает данные по картам, а пересылает их банковским сервисам (Payment Gate, Credit Gate).<br>

### Запуск<br>
Для установки и запуска проекта, необходим NodeJS и базы данных MySQL и PostgreSQL.<br> 
Параметры для запуска хранятся в файле docker-compose.yml.<br> 
Запустить Docker Desktop<br>
Открыть проект в IntelliJ IDEA<br>
В терминале IDEA запустить контейнеры: docker-compose up-d
 
В новой вкладке терминала ввести следующую команды для баз данных:
* для MySQL: 
java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar<br>
* для PostgreSQL
java -Dspring.datasource-postgresql.url=jdbc:postgresql://localhost:5432/app -jar artifacts/aqa-shop.jar<br>
Запустить приложение app run по адресу: http://localhost:8080/

### Запуск тестов
Перейти в новую вкладку терминала и ввести команду:
* для MySQL: 
gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app
* для PostgreSQL:
gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app 

### Формирование отчета AllureReport по результатам тестирования
В новой вкладке терминала или нажав двойной Ctrl ввести команду: gradlew allureServe<br>
Для завершения работы allureServe выполнить команду: Ctrl+C<br>
Для остановки работы контейнеров выполнить команду: docker-compose down

