package com.flairstech.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class Util {

    private Util() {
        throw new AssertionError("Utility class should not be instantiated.");
    }

    public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + screenshotName + ".png";
        File destFile = new File(destinationPath);
        FileHandler.copy(srcFile, destFile);
    }

    public static JsonObject getJsonObject(String path) throws FileNotFoundException {
        return JsonParser.parseReader(new FileReader(path)).getAsJsonObject();
    }

    public static void clickOnElementUsingJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
