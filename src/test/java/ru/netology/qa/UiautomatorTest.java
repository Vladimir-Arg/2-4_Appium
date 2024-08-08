package ru.netology.qa;

// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client

//import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UiautomatorTest {

    private AndroidDriver driver;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        var options = new DesiredCapabilities();
        options.setCapability("platformName", "Android");
        options.setCapability("appium:deviceName", "Some name");
        options.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        options.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        options.setCapability("appium:automationName", "uiautomator2");
        driver = new AndroidDriver(this.getUrl(), options);
    }

    @Test
    public void testChangeEmptyText() {
        var defaultText = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged")).getText(); // получаем текст после запуска приложения, до выполнения каких-либо операций
        var el1 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput")); // поле для ввода текста
        el1.isDisplayed();
        el1.sendKeys("  ");
        var el2 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange")); // кнопка изменения текста
        el2.isDisplayed();
        el2.click();
        var el7 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged")); // получаем элеамент, в котором находится текст уже после выполнения операций
        el7.isDisplayed();
        Assertions.assertEquals(el7.getText(), defaultText);
    }
    @Test
    public void testChangeTextNewActivity() {
        var textToSet = "2-4_Appium";
        var el3 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el3.isDisplayed();
        el3.sendKeys(textToSet);
        var el4 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
        el4.isDisplayed();
        el4.click();
        var el5 = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        el5.isDisplayed();
        el5.click();
//        let el6 = driver.findElementById("ru.netology.testing.uiautomator:id/text");
        var el6 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"ru.netology.testing.uiautomator:id/text\"]"));
        el6.isDisplayed();
        Assertions.assertEquals(el6.getText(), textToSet);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
