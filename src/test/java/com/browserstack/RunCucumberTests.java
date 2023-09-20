package com.browserstack;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        glue = "com.browserstack.stepdefs",
        features = "src/test/resources/features"
)

@RunWith(Cucumber.class)
public class RunCucumberTests {
}
