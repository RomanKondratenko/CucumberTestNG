# language: ru
@search2
Функция: поиск фильмов на сайте (вариант с предысторией)

  Предыстория:
    Дано открыли страницу "http://kinopoisk.ru"
    Когда ввели логин "autotest1" и пароль "test123123" и нажали кнопку войти
    Тогда в личном кабинете увидели логин "autotest1"

  Структура сценария: поиск фильмов

    Когда нажали кнопку "Навигатор по фильмам"
    Тогда перешли на страницу "kinopoisk.ru/top/navigator/"

    Когда выбрали жанр "<genre>", регион "<country>", годы создания от "<years_from>" и до "<years_to>"
    И выбрали рейтинг от "<min_rating>", рейтинг IMDb от "<min_rating_IMDb>", рейтинг критиков от "<min_rating_of_crit>", рейтинг положительных рецензий от "<min_positive_crit>" до"<max_positive_crit>"
    И выбрали другие настройки: возраст "<age>", количество оценок "<min_marks_count>", бюджет от "<min_budget>" до "<max_budget>", кассовые сборы от "<min_cash>", регион "<region_of_cash>"
    И нажали "Показать фильмы"
    Тогда увидели список фильмов соответствующих настройкам: регион "<country>", жанр "<genre>", рейтинг от"<min_rating>", рейтинг IMDb от "<min_rating_IMDb>"

    Когда нажали кнопку выйти
    Тогда проверили корректность выхода из профиля

    Примеры:
      | genre      | country | years_from | years_to | min_rating | min_rating_IMDb | min_rating_of_crit | min_positive_crit | max_positive_crit | age | min_marks_count | min_budget | max_budget | min_cash | region_of_cash |
      | комедия    | США     | 1998       | 2000     | 7          | 7               | 80                 | 90                | 95                | 12+ | 2000            | 50         | 100        | 25       | США            |
      | драма      | США     | 2009       | 2010     | 6          | 6               | 50                 | 50                | 100               | 12+ | 1500            | 50         | 100        | 5        | США            |
      | фантастика | США     | 2014       | 2015     | 7          | 7               | 80                 | 70                | 90                | 12+ | 1000            | 150        | 300        | 50       | США            |

