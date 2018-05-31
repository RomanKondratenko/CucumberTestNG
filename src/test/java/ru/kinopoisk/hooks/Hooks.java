package ru.kinopoisk.hooks;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.kinopoisk.Utils.PropertiesFile;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Hooks {
    public static WebDriver driver;

    @Before
    public void prepareData() {
        String option = PropertiesFile.readPropertiesFile("Browser");
        try {
            if (option.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                System.out.println("Run Chrome browser");
            } else if (option.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                System.out.println("Run Firefox browser");
            }
        } catch (NullPointerException e) {
            System.out.println("Введен неверный параметр");
        }

        //Неявные ожидания
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Attachment(value = "Taking Screenshot because {0}", type = "image/png", fileExtension = "png")
    public byte[] saveScreenshot(Scenario scenario) {

        byte[] bytes = null;
        String path = ".\\screenshots\\";
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        Date date = new Date();
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(path + dateFormat.format(date) + ".png"));
            bytes = IOUtils.toByteArray(new FileInputStream(file));
        } catch (Exception e) {
            System.out.println("Пиздарики");
        }
        return bytes;
    }

    @After
    public void logOut(Scenario scenario) {
        if (scenario.isFailed()) {
            saveScreenshot(scenario);
        }
        driver.close();
    }

}
