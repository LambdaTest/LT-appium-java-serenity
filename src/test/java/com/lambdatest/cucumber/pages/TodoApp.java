package com.lambdatest.cucumber.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://lambdatest.github.io/sample-todo-app/")
public class TodoApp extends PageObject {
    @FindBy(id = "com.lambdatest.proverbial:id/color")
    WebElementFacade color;
    @FindBy(id = "com.lambdatest.proverbial:id/Text")
    WebElementFacade text;
    @FindBy(id = "com.lambdatest.proverbial:id/toast")
    WebElementFacade toast;
    @FindBy(id = "com.lambdatest.proverbial:id/notification")
    WebElementFacade notification;
    @FindBy(id = "com.lambdatest.proverbial:id/geoLocation")
    WebElementFacade geo;

    public void clickOnColor() throws InterruptedException {
        color.click();
    }

    public void clickOnText() throws InterruptedException {
        text.click();
    }

    public void clickOnNotification() throws InterruptedException {
        notification.click();
    }

    public void clickOnToast() throws InterruptedException {
        toast.click();
    }

    public void clickOnGeolocation() throws InterruptedException {
        geo.click();
    }

}