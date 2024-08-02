package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.MainScreen;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.IOSMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@TestInstance(Lifecycle.PER_CLASS)
public class CalculatorTest {

    enum Platform {Android, iOS}

    Platform platform = Platform.Android;

    private AppiumDriver driver;
    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
    CalculatorPage calculatorPage;

    @BeforeEach
    public void setUp() {
        var options = new DesiredCapabilities();
        if (platform == Platform.Android) {
            options.setCapability(PLATFORM_NAME, "android");
            options.setCapability(DEVICE_NAME, "any name");
            options.setCapability(APP_PACKAGE, "com.google.android.calculator");
            options.setCapability(APP_ACTIVITY, "com.android.calculator2.Calculator");
        } else if (platform == Platform.iOS) {
            options.setCapability(PLATFORM_NAME, "iOS");
            options.setCapability(DEVICE_NAME, "iPhone 11");
            options.setCapability(BUNDLE_ID, "com.shubham-iosdev.Calculator-UI");
            options.setCapability(AUTOMATION_NAME, "XCUITest");
        }
        calculatorPage = new CalculatorPage(driver);
    }
    @Test
    public void sampleTest() {
        calculatorPage.digit2Button().isDisplayed();
        calculatorPage.digit2Button().click();
        calculatorPage.plusButton().isDisplayed();
        calculatorPage.plusButton().click();
        calculatorPage.digit2Button().isDisplayed();
        calculatorPage.digit2Button().click();
        calculatorPage.resultButton().isDisplayed();
        calculatorPage.resultButton().click();
        calculatorPage.resultField().isDisplayed();
        Assertions.assertEquals(calculatorPage.resultField().getText(), "4");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
