package ru.kinopoisk.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static ru.kinopoisk.hooks.Hooks.driver;

public class NavigatorPage extends Common {

    private String expectedTitle;
    private String actual;
    private WebElement parent;
    private WebElement child;
    private WebElement webElement;


    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text() = 'Навигатор по лучшим фильмам']")
    private WebElement page;

    public void checkPageTitle() {
        init(driver);
        waitVisible(page, 15);
        expectedTitle = "Навигатор по базе фильмов — КиноПоиск";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expectedTitle);
    }

    @FindBy(css = "div[onclick = 'KP.navigator.openSelect(\"genreList\");']")
    private WebElement genreListTitle;
    @FindBy(id = "genreList")
    private WebElement genreList;

    public void chooseGenre(final String name) {

        waitClickable(genreListTitle, 15);
        genreListTitle.click();
        //поиск родителя
        parent = driver.findElement(By.xpath("//div[text()='Выберите жанры']/.."));
        //поиск элемента по родителю
        child = parent.findElement(By.cssSelector("input[data-name ='" + name));
        waitVisible(genreList, 15);
        child.click();
        Actions actions = new Actions(driver);
        actions.click(genreListTitle);
    }

    @FindBy(css = "div#countryListTitle")
    private WebElement countryListTitle;
    @FindBy(css = "ul#countryList")
    private WebElement countryList;

    public void chooseCountry(final String name) {
        waitClickable(countryListTitle, 15);
        countryListTitle.click();
        waitVisible(countryList, 15);
        //поиск родителя
        parent = driver.findElement(By.xpath("//div[text()='Страны производства']/.."));
        //поиск элемента по родителю
        child = parent.findElement(By.cssSelector("input[data-name ='" + name));
        child.click();
    }

    @FindBy(name = "m_act[years][min]")
    private WebElement yearsMinTitle;

    public void chooseYearsMin(final int year) {
        waitClickable(yearsMinTitle, 15);
        yearsMinTitle.click();
        webElement = driver.findElement(By.cssSelector("select[name='m_act[years][min]'] option[value='" + year));
        webElement.click();
    }

    @FindBy(name = "m_act[years][max]")
    private WebElement yearsMaxTitle;

    public void chooseYearsMax(final int year) {
        waitClickable(yearsMaxTitle, 15);
        yearsMaxTitle.click();
        webElement = driver.findElement(By.cssSelector("select[name='m_act[years][max]'] option[value='" + year));
        webElement.click();
    }

    private void chooseParams(final String param, WebElement element) {
        waitVisible(element, 15);
        element.click();
        element.clear();
        element.sendKeys(param);
        element.sendKeys(Keys.TAB);
    }

    @FindBy(name = "m_act[rating][min]")
    private WebElement minRating;

    public void chooseMinRating(final String param) {
        chooseParams(param, minRating);
    }

    @FindBy(name = "m_act[ex_rating][min]")
    private WebElement minRatingIMDb;

    public void chooseMinRatingIMDb(final String param) {
        chooseParams(param, minRatingIMDb);
    }

    @FindBy(name = "m_act[tomat_rating][min]")
    private WebElement minRatingOfCrit;

    public void chooseMinRatingOfCrit(final String param) {
        chooseParams(param, minRatingOfCrit);
    }

    @FindBy(name = "m_act[review_procent][min]")
    private WebElement minPositiveCrit;

    public void chooseMinPositiveCrit(final String param) {
        chooseParams(param, minPositiveCrit);
    }

    @FindBy(name = "m_act[review_procent][max]")
    private WebElement maxPositiveCrit;

    public void chooseMaxPositiveCrit(final String param) {
        chooseParams(param, maxPositiveCrit);
    }

    @FindBy(name = "m_act[restriction]")
    private WebElement ageTitle;

    public void chooseAge(final String param) {
        ageTitle.click();
        webElement = ageTitle.findElement(By.cssSelector("option[value='" + param));
        webElement.click();
        ageTitle.click();
    }

    @FindBy(name = "m_act[budget][min]")
    private WebElement minBudgetTitle;

    public void chooseMinBudget(final String param) {
        minBudgetTitle.click();
        webElement = minBudgetTitle.findElement(By.cssSelector("option[value='" + param));
        webElement.click();
    }

    @FindBy(name = "m_act[budget][max]")
    private WebElement maxBudgetTitle;

    public void chooseMaxBudget(final String param) {
        maxBudgetTitle.click();
        webElement = maxBudgetTitle.findElement(By.cssSelector("option[value='" + param));
        webElement.click();
    }

    @FindBy(name = "m_act[gross][min]")
    private WebElement minCash;

    public void chooseMinCash(final String param) {
        minCash.click();
        webElement = minCash.findElement(By.cssSelector("option[value='" + param));
        webElement.click();
        // minCash.click();
    }

    @FindBy(name = "m_act[gross_type]")
    private WebElement regionOfCash;

    public void regionOfCash(final String param) {
        regionOfCash.click();
        webElement = regionOfCash.findElement(By.xpath("//option[text()='" + param + "']"));
        webElement.click();
    }

    public Double getMinMark(final int value) throws Exception {
        double count = 16.6597;
        if (value == 500) {
            count = 16.6597;
        } else if (value == 1000) {
            count = 37.4844;
        } else if (value == 1500) {
            count = 58.309;
        } else if (value == 2000) {
            count = 79.1337;
        } else {
            System.out.println("Введено не стандартное значение параметра");
            throw new Exception();
        }
        return count;
    }

    @FindBy(id = "num_voterange")
    private WebElement sliderTrack;

    public void chooseMinCountMarks(final int value) throws Exception {
        double count = getMinMark(value);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        webElement = sliderTrack.findElement(By.cssSelector("a"));
        js.executeScript("arguments[0].setAttribute('style', 'left: " + count + "%;')", webElement);
    }

    @FindBy(css = "input[value='показать фильмы']")
    private WebElement button;
    @FindBy(className = "result")
    private WebElement result;

    public void checkFilmsCount() {
        waitClickable(button, 20);
        webElement = result.findElement(By.cssSelector("a[onclick='KP.navigator.loadResult()']"));
        Assert.assertTrue(webElement.getText().matches("^\\d{1,5}\\sфильм.*"));

    }
    public void pressButtonShow() {

        button.click();

    }

    @FindBy(css = "div#results>table")
    WebElement table;
    @FindBy(css = "div.pagesFromTo")
    WebElement resultCount;

    public void checkResult(String param1, String param2, String param3, String param4) {
        waitVisible(table, 15);
        String text = resultCount.getText();
        int count = Integer.parseInt(text.substring(text.indexOf('з') + 2));

        for (int i = 1; i <= count; i++) {
            webElement = driver.findElement(By.cssSelector("div#itemList>div:nth-child(" + i + ")>div.info"));

            Assert.assertTrue(webElement.getText().matches("[^\"]*" + param1 + "[^\"]*"));
            Assert.assertTrue(webElement.getText().matches("[^\"]*" + param2 + "[^\"]*"));

            webElement = driver.findElement(By.cssSelector("div#itemList>div:nth-child(" + i + ") div.ratingGreenBG"));
            double result = Double.parseDouble(webElement.getText().split(" ")[0]);
            Assert.assertTrue(result >= Double.parseDouble(param3));

            webElement = driver.findElement(By.cssSelector("div#itemList>div:nth-child(" + i + ") div.imdb"));
            result = Double.parseDouble(webElement.getText().split("\\n")[0].split(" ")[1]);
            Assert.assertTrue(result >= Double.parseDouble(param4));
        }
    }

    @FindBy(css = "div[class = 'header-user header-fresh-partial-component__user']")
    private WebElement loginPicture;
    @FindBy(xpath = "//a[text()='Выйти']")
    private WebElement buttonExit;
    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement enterButton;
    @FindBy(css = "#GoUpButton")
    private WebElement goUpButton;


    public void logout() {
        waitClickable(goUpButton, 20);
        goUpButton.click();
        waitVisible(loginPicture, 15);
        Actions toLoginPicture = new Actions(driver);
        toLoginPicture.moveToElement(loginPicture).perform();
        waitVisible(buttonExit, 15);
        buttonExit.click();

    }

    public void checkButtonEnter() {
        waitVisible(enterButton, 15);
        Assert.assertEquals("Войти", enterButton.getText());
    }

}
