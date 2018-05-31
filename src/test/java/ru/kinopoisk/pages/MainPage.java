package ru.kinopoisk.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static ru.kinopoisk.hooks.Hooks.driver;

public class MainPage extends Common {

    private String expectedTitle;
    private String actual;


    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "svg-background_yes")
    private WebElement page;

    public void goToMainPage(String pageName) {
        init(driver);
        driver.get(pageName);
        waitVisible(page, 15);
        checkPageTitle();
    }

    public void checkPageTitle() {
        expectedTitle = "КиноПоиск — Все фильмы планеты";
        actual = driver.getTitle();
        Assert.assertEquals(expectedTitle, actual);
    }

    @FindBy(className = "header-fresh-user-partial-component__login-button")
    private WebElement enterButton;

    public void pressEnterButton() {
        waitClickable(enterButton, 15);
        enterButton.click();
    }

    @FindBy(name = "kp2-authapi-iframe")
    private WebElement loginFrame;
    @FindBy(css = "input[autocomplete = 'username']")
    private WebElement fieldLogin;

    public void setLogin(final String login) {

        waitVisible(loginFrame, 15);
        Assert.assertTrue(loginFrame.isEnabled());
        driver.switchTo().frame(loginFrame);
        waitVisible(fieldLogin, 15);
        fieldLogin.click();
        fieldLogin.sendKeys(login);
        fieldLogin.sendKeys(Keys.TAB);
    }

    @FindBy(name = "password")
    private WebElement fieldPassword;

    public void setPassword(final String password) {

        waitVisible(fieldPassword, 10);
        fieldPassword.click();
        fieldPassword.sendKeys(password);
        fieldPassword.sendKeys(Keys.TAB);
    }

    @FindBy(xpath = "//span [contains(.,'Вход')]/..")
    private WebElement loginButton;

    public void pressLoginButton() {
        waitClickable(loginButton, 15).click();
    }

    @FindBy(css = "div.header-fresh-user-partial-component__button")
    private WebElement loginPicture;
    @FindBy(css = "a[href$=\"/go/\"]")
    private WebElement loginName;

    public void checkLogin(final String expectedName) {
        driver.switchTo().defaultContent();
        waitVisible(loginPicture, 15);
        Actions toLoginPicture = new Actions(driver);
        toLoginPicture.moveToElement(loginPicture).perform();
        waitVisible(loginName, 15);
        actual = loginName.getText();
        Assert.assertEquals(actual, expectedName);
    }

    @FindBy(xpath = "//li[text()='Фильмы']")
    private WebElement filmsFrame;
    @FindBy(css = "a[href^=\"/top/navigator/\"]")
    private WebElement navigator;

    public void goToNavigator() {
        init(driver);
        waitVisible(filmsFrame, 10);
        Actions toFilmsFrame = new Actions(driver);
        toFilmsFrame.moveToElement(filmsFrame).perform();
        waitClickable(navigator, 10);
        Actions toNavigator = new Actions(driver);
        toNavigator.moveToElement(navigator).click().perform();
    }

}
