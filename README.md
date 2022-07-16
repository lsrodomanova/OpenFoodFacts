## Проект по автоматизации тестирования сайта openfoodfacts.org"
> <a target="_blank" href="https://world.openfoodfacts.org/">Ссылка на главную страницу сайта</a>
### <img width="100%" title="Zaryad" src="images/logo/logo.svg">
## Описание проекта
Учебный проект реализации автотестирования. Включает web, api и мобильные тесты.
>В качестве объекта тестирования выбран сайт https://world.openfoodfacts.org/ и мобильное приложение с открытым api.<br/>

Сайт позволяет получать подробную информацию о продуктах, выпускаемых во всем мире, а также самому добавлять продукты, которых нет в базе проекта.

###  Проект реализован с использованием
<p align="center">IntelliJ IDEA Java Gradle Selenide Selenoid JUnit5 Jenkins Allure Report Allure TestOps Telegram </p>
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="8%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Allure TestOps" src="images/logo/testops.svg">

###  Проект включает в себя:
- [x] UI-автотесты веба
- [x] API тесты
- [x] UI-автотесты мобильного приложения
###  Список проверок, реализованных в проекте
- [x] Авторизация
- [x] Поиск продуктов по названию
- [x] Поиск продуктов по баркоду
- [x] Поиск продуктов по странам
- [x] Поиск категорий
- [x] Onboarding тест мобильного приложения
- [x] Добавление продукта на сайт
- [x] Проверка экранов в мобильном приложении

#### Пример запуска из командной строки
```bash
gradle clean web
gradle clean api
gradle clean android
```
## Запуск автотестов выполняется на сервере Jenkins
> <a target="_blank" href="https://jenkins.autotests.cloud/job/lrodomanova_diploma_openfoodfacts">Ссылка на проект в Jenkins</a>

![This is an image](images/screenshots/jenkins.png)

Для запуска тестов выбрать пункт **"Собрать сейчас"**

## Отчёты о результатах сборок, списки тесткейсов, аналитические dashboards хранятся в Allure TestOps
> <a target="_blank" href="https://allure.autotests.cloud/project/1468/dashboards">Сссылка на проект в AllureTestOps</a> (запрос доступа admin@qa.guru)

![This is an image](images/screenshots/testops.png)

![This is an image](images/screenshots/testops2.png)

![This is an image](images/screenshots/testops3.png)

### Список кейсов в отчёте Allure
![This is an image](images/screenshots/allurereport.png)

## Настроено автоматическое оповещение о результатах сборки Jenkins в Telegram-бот
![This is an image](images/screenshots/Telegram.png)

> К каждому тесту в отчете прилагается видео.
<p align="center">
  <img title="Selenoid Video" src="images/screenshots/web.gif" >
</p>

> Видео прохождения мобильного теста.
<p align="center">
  <img title="Selenoid Video" src="images/screenshots/mobile.gif" >
</p>