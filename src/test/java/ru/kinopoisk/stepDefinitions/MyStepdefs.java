package ru.kinopoisk.stepDefinitions;


import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.kinopoisk.pages.MainPage;
import ru.kinopoisk.pages.NavigatorPage;


public class MyStepdefs {
    public WebDriver driver;
    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    NavigatorPage navigatorPage = PageFactory.initElements(driver, NavigatorPage.class);

    @Step("^открыли страницу \"([^\"]*)\"$")
    @Дано("^открыли страницу \"([^\"]*)\"$")
    public void открылиСтраницу(String arg1) {
        mainPage.goToMainPage(arg1);

    }

    @Step("^ввели логин \"([^\"]*)\" и пароль \"([^\"]*)\" и нажали кнопку войти$")
    @Когда("^ввели логин \"([^\"]*)\" и пароль \"([^\"]*)\" и нажали кнопку войти$")
    public void ввелиЛогинИПарольИНажалиКнопкуВойти(String arg1, String arg2) {
        mainPage.pressEnterButton();
        mainPage.setLogin(arg1);
        mainPage.setPassword(arg2);
        mainPage.pressLoginButton();
    }

    @Step("^в личном кабинете увидели логин \"([^\"]*)\"$")
    @Тогда("^в личном кабинете увидели логин \"([^\"]*)\"$")
    public void вЛичномКабинетеУвиделиЛогин(String arg1) {
        mainPage.checkLogin(arg1);
    }

    @Step("^нажали кнопку \"([^\"]*)\"$")
    @Когда("^нажали кнопку \"([^\"]*)\"$")
    public void нажалиКнопку(String arg1) {
        mainPage.goToNavigator();
    }

    @Step("^перешли на страницу \"([^\"]*)\"$")
    @Тогда("^перешли на страницу \"([^\"]*)\"$")
    public void перешлиНаСтраницу(String arg1) {
        navigatorPage.checkPageTitle();
    }

    @Step("^выбрали жанр \"([^\"]*)\", регион \"([^\"]*)\", годы создания от \"([^\"]*)\" и до \"([^\"]*)\"$")
    @Когда("^выбрали жанр \"([^\"]*)\", регион \"([^\"]*)\", годы создания от \"([^\"]*)\" и до \"([^\"]*)\"$")
    public void выбралиЖанрРегионГодыСозданияОтИДо(String arg1, String arg2, int arg3, int arg4) {
        navigatorPage.chooseGenre(arg1);
        navigatorPage.chooseYearsMin(arg3);
        navigatorPage.chooseYearsMax(arg4);
        navigatorPage.chooseCountry(arg2);

    }

    @Step("^выбрали рейтинг от \"([^\"]*)\", рейтинг IMDb от \"([^\"]*)\", рейтинг критиков от \"([^\"]*)\", рейтинг положительных рецензий от \"([^\"]*)\" до\"([^\"]*)\"$")
    @Когда("^выбрали рейтинг от \"([^\"]*)\", рейтинг IMDb от \"([^\"]*)\", рейтинг критиков от \"([^\"]*)\", рейтинг положительных рецензий от \"([^\"]*)\" до\"([^\"]*)\"$")
    public void выбралиРейтингОтРейтингIMDbОтРейтингКритиковОтРейтингПоложительныхРецензийОтДо(String arg1, String arg2, String arg3, String arg4, String arg5) {
        navigatorPage.chooseMinRating(arg1);
        navigatorPage.chooseMinRatingIMDb(arg2);
        navigatorPage.chooseMinRatingOfCrit(arg3);
        navigatorPage.chooseMaxPositiveCrit(arg5);
        navigatorPage.chooseMinPositiveCrit(arg4);

    }

    @Step("^выбрали другие настройки: возраст \"([^\"]*)\", количество оценок \"([^\"]*)\", бюджет от \"([^\"]*)\" до \"([^\"]*)\", кассовые сборы от \"([^\"]*)\", регион \"([^\"]*)\"$")
    @Когда("^выбрали другие настройки: возраст \"([^\"]*)\", количество оценок \"([^\"]*)\", бюджет от \"([^\"]*)\" до \"([^\"]*)\", кассовые сборы от \"([^\"]*)\", регион \"([^\"]*)\"$")
    public void выбралиДругиеНастройкиВозрастКоличествоОценокБюджетОтДоКассовыеСборыОтРегион(String arg1, int arg2, String arg3, String arg4, String arg5, String arg6) throws Exception {
        navigatorPage.chooseAge(arg1);
        navigatorPage.chooseMinCountMarks(arg2);
        navigatorPage.chooseMinBudget(arg3);
        navigatorPage.chooseMaxBudget(arg4);
        navigatorPage.chooseMinCash(arg5);
        navigatorPage.regionOfCash(arg6);

    }
    @Step("^увидели всплывающее окно с количеством найденных фильмов$")
    @Тогда("^увидели всплывающее окно с количеством найденных фильмов$")
    public void увиделиВсплывающееОкноСКоличествомНайденныхФильмов()  {
        navigatorPage.checkFilmsCount();
    }
    @Step("^нажали \"([^\"]*)\"$")
    @Когда("^нажали \"([^\"]*)\"$")
    public void нажали(String arg1) {
        navigatorPage.pressButtonShow();
    }

    @Step("^увидели список фильмов соответствующих настройкам: регион \"([^\"]*)\", жанр \"([^\"]*)\", рейтинг от\"([^\"]*)\", рейтинг IMDb от \"([^\"]*)\"$")
    @Тогда("^увидели список фильмов соответствующих настройкам: регион \"([^\"]*)\", жанр \"([^\"]*)\", рейтинг от\"([^\"]*)\", рейтинг IMDb от \"([^\"]*)\"$")
    public void увиделиСписокФильмовСоответствующихНастройкамРегионЖанрРейтингОтРейтингIMDbОт(String arg1, String arg2, String arg3, String arg4) {
        navigatorPage.checkResult(arg1, arg2, arg3, arg4);
    }

    @Step("^нажали кнопку выйти$")
    @Когда("^нажали кнопку выйти$")
    public void нажалиКнопкуВыйти() {
        navigatorPage.logout();
    }

    @Step("^проверили корректность выхода из профиля$")
    @Тогда("^проверили корректность выхода из профиля$")
    public void проверилиКорректностьВыходаИзПрофиля() {
        navigatorPage.checkButtonEnter();
    }


}