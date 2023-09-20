package com.browserstack.stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleSteps {
    private AndroidDriver<AndroidElement> driver;

    public SampleSteps() {
    }

    @Before
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        driver = new AndroidDriver<AndroidElement>(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);
    }

    @Given("I have opened the TV App")
    public void I_am_on_the_website() throws Throwable {
        Thread.sleep(2000);
        System.out.println("App Started!");
    }

    @And("I wait for 5000 ms")
    public void I_select_a_product_and_add_to_cart() throws Throwable {
        driver.findElementByXPath("//android.view.View[@content-desc='Next']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.View[@content-desc='Next']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.View[@content-desc='Next']").click();
        Thread.sleep(2000);
        driver.findElementById("com.example.android.tvleanback:id/button_start").click();
        Thread.sleep(5000);
    }

    @And("I navigate to a video")
    public void product_should_be_added_to_cart() {
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
    }

    @Then("I find a Video Focused")
    public void page_title_should_contain() {
        String videoName = driver.findElementByXPath("//android.widget.FrameLayout[@focused='true']")
                .getText();
        Assert.assertNotNull(videoName);
    }

    @After
    public void teardown(Scenario scenario) throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}