package com.lambdatest;

import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import net.thucydides.core.webdriver.DriverSource;

public class LambdaTestSerenityDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        // Corrected credentials based on your environment
        String username = "##"; 
        String accessKey = "##"; 

        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Use a HashMap for the W3C lt:options block
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("w3c", true);
        ltOptions.put("isRealMobile", true);
        ltOptions.put("app", "app-id"); // Your uploaded App URL
        ltOptions.put("platformName", "Android");
        ltOptions.put("deviceName", "Galaxy.*");
        ltOptions.put("platformVersion", "13");
        ltOptions.put("build", "Java25_Modern_Build");
        ltOptions.put("name", "Proverbial_App_Test");

        // Set the primary capability key for LambdaTest
        capabilities.setCapability("lt:options", ltOptions);
        capabilities.setCapability("platformName", "Android");

        try {
            String url = "https://" + username + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub";
            System.out.println("Connecting to LambdaTest Mobile Hub...");
            return new RemoteWebDriver(new URL(url), capabilities);
        } catch (Exception e) {
            System.err.println("Driver initialization failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}