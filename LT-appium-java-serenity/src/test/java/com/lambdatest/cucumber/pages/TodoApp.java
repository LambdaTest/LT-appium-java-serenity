package com.lambdatest.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://lambdatest.github.io/sample-todo-app/")
public class TodoApp extends PageObject {

    public void clickOnColor() {
        // Interaction: Click first checkbox
        find(By.name("li1")).click();
        System.out.println("Clicked on first item. Waiting 10 seconds...");
        try {
            Thread.sleep(10000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnText() {
        // Interaction: Add a new item to the list
        find(By.id("sampletodotext")).type("New Task");
        find(By.id("addbutton")).click();
        System.out.println("Added new text task. Waiting 10 seconds...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnNotification() {
        // Interaction: Click second checkbox
        find(By.name("li2")).click();
        System.out.println("Clicked on second item (Notification simulation). Waiting 10 seconds...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnToast() {
        // Interaction: Click third checkbox
        find(By.name("li3")).click();
        System.out.println("Clicked on third item (Toast simulation). Waiting 10 seconds...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnGeolocation() {
        // Interaction: Click fourth checkbox
        find(By.name("li4")).click();
        System.out.println("Clicked on fourth item (Geolocation simulation). Waiting 10 seconds...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}