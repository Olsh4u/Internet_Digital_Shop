# Internet_Digital_Shop
ТЗ по созданию SpringBoot приложения для управления интернет магазином


### Инструкция по запуску приложения

Следующая инструкция описывает процесс запуска приложения на основе предоставленного исходного кода. Убедитесь, что у вас установлены все необходимые зависимости и настройки перед началом процесса.

#### Требования
Для успешного запуска приложения необходимо убедиться, что у вас установлены следующие компоненты:

- Java Development Kit (JDK) версии 11 или выше
- Maven для сборки проекта

### Шаги по запуску

-Склонируйте репозиторий с исходным кодом приложения на вашу локальную машину.
```
git clone https://github.com/Olsh4u/Internet_Digital_Shop.git
```
-Перейдите в каталог проекта.
```
cd your-project-directory
```
- Соберите проект с помощью Maven.
```
mvn clean install
```
После успешной сборки проекта вы можете запустить его с помощью следующей команды:
```
mvn spring-boot:run
```


### Использование приложения
После успешного запуска приложения вы сможете использовать его для управления товарами в интернет-магазине. Приложение предоставляет следующие функциональные возможности:

- Получение списка всех товаров в магазине
- Получение информации о конкретном товаре по его идентификатору
- Добавление нового товара в магазин
- Обновление информации о товаре

Для взаимодействия с приложением можно использовать HTTP-клиенты или отправлять HTTP-запросы напрямую.

### API эндпоинты
- GET /products/types/{type} - получение списка товаров определенного типа
- GET /products/{id} - получение информации о товаре по идентификатору
- POST /products - добавление нового товара
- PUT /products/{id} - обновление информации о товаре по идентификатору

Для взаимодействия с приложением необходимо отправлять HTTP-запросы в формате JSON. Ниже приведены API эндпоинты и примеры данных, которые можно использовать.

```
{
  "serialNumber": "SN001",
  "manufacturer": "Updated Manufacturer",
  "price": 1299.99,
  "quantity": 8,
  "screenSize": 14,
  "productType": "laptop"
}

```
### Заключение
Поздравляю! Теперь у вас есть локально запущенное приложение интернет-магазина. Вы можете использовать его для управления товарами и проведения различных операций в контексте магазина.