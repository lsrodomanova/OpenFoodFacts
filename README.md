# open-library-api-tests
![This is an image](/design/icons/Java.png)![This is an image](/design/icons/Gradle.png)![This is an image](/design/icons/Rest-Assured.png)![This is an image](/design/icons/Intelij_IDEA.png)![This is an image](/design/icons/JUnit5.png)![This is an image](/design/icons/Jenkins.png)![This is an image](/design/icons/Allure_Report.png)![This is an image](/design/icons/AllureTestOps.png)![This is an image](/design/icons/Telegram.png)
## Описание проекта
Учебный проект реализации автотестирования **Rest Api**.<br/>
>В качестве объекта тестирования выбран сайт https://openlibrary.org/ с открытым api.<br/>

![This is an image](/design/images/open-library.png)

Сайт позволяет получать информацию о книгах по автору, названию, теме, году издания, издателю, языках публикаций и прочем.

#### Особенности реализации тестового проекта
- Модели получаемых данных описаны с помощью библиотеки Lombok.
- Использован лямбда-подход для описания Allure Step.
- Использованы шаблоны форматирования логов запросов.

## Список проверок, реализованных в автотестах
Поиск на сайте может выполняться по двум видам запросов: обычном и solr-query. Поэтому для тесткейсов настроены две **Feautures: Query, Solr query**.
- [x] Solr query. Language. Поиск книг автора на русском языке
- [x] Solr query. Language. Поиск книг автора на английском языке
- [x] Solr query. Person. Поиск книг о заданной персоне
- [x] Solr query. Place. Поиск книг о заданном месте
- [x] Solr query. Publisher. Поиск книг по издателю
- [x] Solr query. Subject. Поиск книг на заданную тему
- [x] Обычный поиск. Полное наименование книги и имя-фамилия автора
- [x] Поиск по полному названию книги. Solr query
- [x] Поиск по полному названию книги. Обычный поиск
- [x] Поиск по фамилии автора. Solr query
- [x] Поиск по фамилии автора. Обычный поиск
- [x] Поиск по фамилии и имени автора. Solr query
- [x] Поиск по фамилии и имени автора. Обычный поиск
- [x] Поиск книги по фамилии и имени автора. Обычный поиск
- [x] Поиск по части названия книги. Обычный поиск

#### Пример запуска из командной строки
```bash
gradle clean test
```
## Запуск автотестов выполняется на сервере Jenkins
> <a target="_blank" href="https://jenkins.autotests.cloud/job/09-ElenaSeversk-open-library-api-tests/">Ссылка на проект в Jenkins</a>

![This is an image](/design/images/jenkins.png)

Для запуска тестов выбрать пункт **"Собрать сейчас"**

## Отчёты о результатах сборок, списки тесткейсов, аналитические dashboards хранятся в Allure TestOps
> <a target="_blank" href="https://allure.autotests.cloud/project/1021/dashboards">Сссылка на проект в AllureTestOps</a> (запрос доступа admin@qa.guru)

### Итоговые dashboard по результатам сборок
![This is an image](/design/images/dashboard_overview.png)
### Аналитическая dashboard с разбивкой кейсов по Features и Stories
![This is an image](/design/images/statistics_dashboard.png)
Приведена общая статистика по запускам, рейтинги тестов по AccessRate и длительности выполнения.<br/>
Отдельно сгруппированы результаты по:
- видам поиска (Feature = Query, Solr query)
- объектам поиска (Story = Author, Person, Title, Place, Publisher, Subject)
### Список кейсов в отчёте Allure с разбивкой по Features и Stories
![This is an image](/design/images/allure_report_features2.png)
### Пример просмотра информации о запуске конкретного launcher
![This is an image](/design/images/allure_dashboard_summary.png)
![This is an image](/design/images/grafics.png)
![This is an image](/design/images/timeline.png)
![This is an image](/design/images/launcer_result.png)

## Настроено автоматическое оповещение о результатах сборки Jenkins в Telegram-бот
![This is an image](/design/images/bot.png)


:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
