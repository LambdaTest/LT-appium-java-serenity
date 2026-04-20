package com.lambdatest.extensions;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.serenitybdd.core.webdriver.RemoteDriver;
import net.serenitybdd.core.webdriver.enhancers.AfterAWebdriverScenario;
import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;

// Correct Serenity 4.x imports
import net.thucydides.model.domain.TestOutcome;       // Fixed from net.thucydides.core.model
import net.thucydides.model.util.EnvironmentVariables; // Fixed from net.thucydides.core.util
import net.thucydides.core.webdriver.SupportedWebDriver;

public class LambdaTestScenario implements AfterAWebdriverScenario, BeforeAWebdriverScenario {

    @Override
    public void apply(EnvironmentVariables environmentVariables, TestOutcome testOutcome, WebDriver driver) {

        if ((driver == null) || (!RemoteDriver.isARemoteDriver(driver))) {
            return;
        }

        try {
            String sessionId = RemoteDriver.of(driver).getSessionId().toString();

            String username = System.getenv("LT_USERNAME");
            if (username == null) {
                username = environmentVariables.getProperty("lt.user");
            }

            String accessKey = System.getenv("LT_ACCESS_KEY");
            if (accessKey == null) {
                accessKey = environmentVariables.getProperty("lt.key");
            }

            String environment = System.getProperty("environment");

            URI uri = new URI("https://" + username + ":" + accessKey
                + "@api.lambdatest.com/automation/api/v1/sessions/" + sessionId);
            HttpPatch putRequest = new HttpPatch(uri);

            String result = "completed";
            if (testOutcome.isSuccess()) {
                result = "passed";
            } else if (testOutcome.isFailure() || testOutcome.isError() || testOutcome.isCompromised()) {
                result = "failed";
            }

            StringEntity entity;

            // Updated check to use the correct EnvironmentVariables API
            if (environment != null && environmentVariables.getKeys().contains(".name")) {
                entity = new StringEntity("{\"status_ind\":" + "\"" + result + "\"}");
            } else {
                entity = new StringEntity("{\"name\":\"" + testOutcome.getStoryTitle() + " - " + testOutcome.getTitle()
                    + "\",\"status_ind\":" + "\"" + result + "\"}");
            }

            putRequest.setEntity(entity);
            HttpClientBuilder.create().build().execute(putRequest);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isActivated(EnvironmentVariables environmentVariables) {
        return AfterAWebdriverScenario.super.isActivated(environmentVariables);
    }

    // Deprecated for DesiredCapabilities, but kept for compatibility
    public DesiredCapabilities apply(EnvironmentVariables environmentVariables, SupportedWebDriver driver,
        TestOutcome testOutcome, DesiredCapabilities capabilities) {
        capabilities.setCapability("name", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        return capabilities;
    }

    // Recommended method for Serenity 4.x using MutableCapabilities
    @Override
    public MutableCapabilities apply(EnvironmentVariables environmentVariables, SupportedWebDriver supportedWebDriver,
        TestOutcome testOutcome, MutableCapabilities mutableCapabilities) {
        mutableCapabilities.setCapability("name", testOutcome.getStoryTitle() + " - " + testOutcome.getTitle());
        return mutableCapabilities;
    }
}