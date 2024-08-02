package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CalculatorPage {
//    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"2\"]")
    public WebElement digit2Button() {
        if (driver instanceof AndroidDriver) {
            return driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        } else if (driver instanceof IOSDriver) {
            return driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"2\"]"));
        }
        return null;
    };

//    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"+\"]")
    public WebElement plusButton() {
        if (driver instanceof AndroidDriver) {
            return driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        } else if (driver instanceof IOSDriver) {
            return driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"+\"]"));
        }
        return null;
    };

//    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
//    @iOSXCUITFindBy(accessibility = "=")
    public WebElement resultButton() {
        if (driver instanceof AndroidDriver) {
            return driver.findElement(By.id("com.google.android.calculator:id/eq"));
        } else if (driver instanceof IOSDriver) {
            return driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"=\"]"));
        }
        return null;
    };

//    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"4\"])[1]")
    public WebElement resultField() {
        if (driver instanceof AndroidDriver) {
            return driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        } else if (driver instanceof IOSDriver) {
            return driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"4\"])[1]"));
        }
        return null;
    };

    private  AppiumDriver driver;

    public CalculatorPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}
