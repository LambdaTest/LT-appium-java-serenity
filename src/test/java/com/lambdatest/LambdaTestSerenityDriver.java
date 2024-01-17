package com.lambdatest;

import java.net.URL;
import java.util.Iterator;

import net.thucydides.core.environment.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

public class LambdaTestSerenityDriver implements DriverSource {

	public WebDriver newDriver() {
		EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

		//		String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");         //Add your LT username here
		//		String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");    //Add your LT accessKey here
		//		String appId = System.getenv("LT_APP_ID") == null ? "lt://proverbial-android" : System.getenv("LT_APP_ID");    //Add your LT appId here
		//		String gridUrl = System.getenv("LT_GRID_URL") == null ? "mobile-hub.lambdatest.com" : System.getenv("LT_GRID_URL");    //Add LT gridUrl here



		String environment = "single";

		String username = System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");         //Add your LT username here
		String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");    //Add your LT accessKey here
		String appId = System.getenv("LT_APP_ID") == null ? "lt://proverbial-android" : System.getenv("LT_APP_ID");    //Add your LT appId here
		String gridUrl = System.getenv("LT_GRID_URL") == null ? "mobile-hub.lambdatest.com" : System.getenv("LT_GRID_URL");    //Add LT gridUrl here


		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("plugin", "Serenity LambdaTest Plugin");
		capabilities.setCapability("isRealMobile", true);
		capabilities.setCapability("app", appId);     //Enter app url here

		Iterator it = environmentVariables.getKeys().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();

			if (key.equals("lt.user") || key.equals("lt.key") || key.equals("lt.grid")) {
				continue;
			} else if (key.startsWith("lt_")) {
				capabilities.setCapability(key.replace("lt_", ""), environmentVariables.getProperty(key));

			} else if (environment != null && key.startsWith("environment." + environment)) {

				capabilities.setCapability(key.replace("environment." + environment + ".", ""),
					environmentVariables.getProperty(key));
			}
		}

		try {
			String url = "https://" + username + ":" + accessKey + "@" + gridUrl + "/wd/hub";
			return new RemoteWebDriver(new URL(url), capabilities);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean takesScreenshots() {
		return false;
	}
}
