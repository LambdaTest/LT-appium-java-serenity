package com.lambdatest.cucumber.steps;

import com.lambdatest.cucumber.pages.TodoApp;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

public class TodoAppSteps {
    TodoApp todo;

    @Given("^user is on the App home page$")
	public void user_already_on_home_page() {
	System.out.println("On Home page");
	}

	@When("^click on color element$")
	public void click_color()throws InterruptedException {
		todo.clickOnColor();
		System.out.println("Clicked Color button");	
		Thread.sleep(3000);	
	}

	@Then("^click on text element$")
	public void click_text()throws InterruptedException {
		todo.clickOnText();
		System.out.println("Clicked text button");
		Thread.sleep(3000);		
	}

	@Then("^click on notification element$")
	public void click_notification()throws InterruptedException {
		todo.clickOnNotification();
		System.out.println("Clicked Notification button");
		Thread.sleep(3000);	
	}

	@Then("^click on toast element$")
	public void click_toast()throws InterruptedException {
		todo.clickOnToast();
		System.out.println("Clicked Toast button");
		Thread.sleep(3000);	
	}

	@Then("^click on geolocation element$")
	public void click_geolocation()throws InterruptedException {
		todo.clickOnGeolocation();
		System.out.println("Clicked geolocation button");
		Thread.sleep(3000);		
	}
}