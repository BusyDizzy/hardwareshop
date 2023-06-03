# Тестовое задание EasyBot 

## Цель: Создать небольшое приложение на базе Spring Boot.
### Описание: 
#### Магазин, торгующий компьютерами и комплектующими со следующим типом товаров:
- Настольные компьютеры
- Ноутбуки
- Мониторы
- Жесткие диски
#### Каждый товар имеет следующие свойства:
- номер серии
- производитель
- цена
- количество единиц продукции на складе

#### Дополнительные свойства:
- Настольные компьютеры имеют форм-фактор: десктопы, неттопы, моноблоки
- Ноутбуки подразделяются по размеру: 13, 14, 15, 17 дюймовые
- Мониторы имеют диагональ
- Жесткие диски имеют объем

### Задание: Необходимо реализовать back-end приложение, которое имеет RESTful HTTP методы выполняющие:
1. Добавление товара
2. Редактирование товара
3. Просмотр всех существующих товаров по типу
4. Просмотр товара по идентификатору

В качестве базы данных использовать in memory database, например H2

# Инструкция по запуску
## Приложение работает на базе Oracle Open JDK 19.0.1, Spring Boot и БД H2
#### Для запуска приложения:
- Клонировать репозиторий из командной строки: git clone https://github.com/BusyDizzy/hardwareshop.git
## Два варианта запуска
1. Запустить приложение используя IDE (Intellij IDEA Ultimate Edition)
2. Собрать локально (должен быть установлен Maven и JRE 19.0.1)
### Варианта запуска №2, без использования IDE
#### 1. После клонирования набрать в консоли(командной строке):
- cd hardwareshop
- maven package или mvn install
#### 2. Запустите приложение Spring Boot с помощью команды java –jar
- java -jar target/hardwareshop-0.0.1-SNAPSHOT.jar
#### 2a. Либо запустите приложение Spring Boot с помощью Maven
- mvn spring-boot:run

#### Приложение включает в себя:
- Исходные данные для заполнения таблиц H2
- Тестовые данные
- Тесты: Unit Tests - 24 шт. для проверки работоспособности методов

## Техническая документация: <a href="http://localhost:8080/swagger-ui/index.html">Swagger REST API documentation</a>
##  Репозиторий: <a href="https://github.com/BusyDizzy/hardwareshop">GitHub</a>