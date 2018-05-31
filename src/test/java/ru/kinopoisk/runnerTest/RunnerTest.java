package ru.kinopoisk.runnerTest;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(


        features = ".\\src\\test\\java\\ru\\kinopoisk\\features",
        glue = {"ru.kinopoisk.hooks", "ru.kinopoisk.stepDefinitions"},
        tags = {"@search"},
        plugin ={"pretty"}
//        настройки для репортов Cucumber
//        plugin = {"json:/reports/report/output.json","html:/reports/report"},
//        snippets = SnippetType.CAMELCASE

)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
