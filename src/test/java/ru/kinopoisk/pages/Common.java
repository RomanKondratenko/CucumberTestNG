package ru.kinopoisk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.kinopoisk.hooks.Hooks.driver;

public class Common {
    public WebElement waitVisible(WebElement element, int timeout) {
        element = (new WebDriverWait(driver, timeout, 500))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitClickable(WebElement element, int timeout) {
        element = (new WebDriverWait(driver, timeout, 500))
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
