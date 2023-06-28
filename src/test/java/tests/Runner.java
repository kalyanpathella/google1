package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features/googleHome.feature","src/test/resources/features/googleHome1.feature"},

                 glue="gluecode",
                 plugin={"pretty","json:target/cucumber-reports.json"},
                 monochrome=true)

public class Runner  {

}
