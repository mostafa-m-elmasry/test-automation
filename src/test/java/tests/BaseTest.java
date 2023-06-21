package tests;

import com.flairstech.util.Util;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

public abstract class BaseTest extends AbstractTestNGCucumberTests {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void launchApplication() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("-inprivate");

        driver = new EdgeDriver(options);

        WebDriver.Options manage = driver.manage();

        manage.window().setSize(new Dimension(1024, 768));
        manage.window().maximize();
        manage.timeouts().implicitlyWait(Duration.ofSeconds(120));
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    @AfterMethod
    public void takeScreenShotForFailingTests(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Util.takeScreenshot(driver, result.getName());
        }
    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
