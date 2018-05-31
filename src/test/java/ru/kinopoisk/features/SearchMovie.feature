# language: ru
@search
Функция: поиск фильмов на сайте

  Структура сценария: поиск фильмов
    Дано открыли страницу "http://kinopoisk.ru"

    Когда ввели логин "<login>" и пароль "<password>" и нажали кнопку войти
    Тогда в личном кабинете увидели логин "<login>"

    Когда нажали кнопку "Навигатор по фильмам"
    Тогда перешли на страницу "kinopoisk.ru/top/navigator/"

    Когда выбрали жанр "<genre>", регион "<country>", годы создания от "<years_from>" и до "<years_to>"
    И выбрали рейтинг от "<min_rating>", рейтинг IMDb от "<min_rating_IMDb>", рейтинг критиков от "<min_rating_of_crit>", рейтинг положительных рецензий от "<min_positive_crit>" до"<max_positive_crit>"
    И выбрали другие настройки: возраст "<age>", количество оценок "<min_marks_count>", бюджет от "<min_budget>" до "<max_budget>", кассовые сборы от "<min_cash>", регион "<region_of_cash>"
    Тогда увидели всплывающее окно с количеством найденных фильмов
    Когда нажали "Показать фильмы"
    Тогда увидели список фильмов соответствующих настройкам: регион "<country>", жанр "<genre>", рейтинг от"<min_rating>", рейтинг IMDb от "<min_rating_IMDb>"

    Когда нажали кнопку выйти
    Тогда проверили корректность выхода из профиля

    Примеры:
      | login     | password   | genre      | country | years_from | years_to | min_rating | min_rating_IMDb | min_rating_of_crit | min_positive_crit | max_positive_crit | age | min_marks_count | min_budget | max_budget | min_cash | region_of_cash |
      | autotest1 | test123123 | комедия    | США     | 1998       | 2000     | 7          | 7               | 80                 | 90                | 95                | 12+ | 2000            | 50         | 100        | 25       | США            |
      | autotest2 | test234234 | драма      | США     | 2009       | 2010     | 6          | 6               | 50                 | 50                | 100               | 12+ | 1500            | 50         | 100        | 5        | США            |
      | autotest3 | test345345 | фантастика | США     | 2014       | 2015     | 7          | 7               | 80                 | 70                | 90                | 12+ | 1000            | 150        | 300        | 50       | США            |

