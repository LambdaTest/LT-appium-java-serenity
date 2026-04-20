\<p align="center"\>
\<a href="[https://www.lambdatest.com/blog/?utm\_source=github\&utm\_medium=repo\&utm\_campaign=LT-appium-java-serenity](https://www.lambdatest.com/blog/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java-serenity)" target="\_bank"\>Blog\</a\>
\&nbsp; &\#8901; \&nbsp;
\<a href="[suspicious link removed]" target="\_bank"\>Docs\</a\>
\&nbsp; &\#8901; \&nbsp;
\<a href="[https://www.lambdatest.com/learning-hub/?utm\_source=github\&utm\_medium=repo\&utm\_campaign=LT-appium-java-serenity](https://www.lambdatest.com/learning-hub/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java-serenity)" target="\_bank"\>Learning Hub\</a\>
\&nbsp; &\#8901; \&nbsp;
\<a href="[https://www.lambdatest.com/newsletter/?utm\_source=github\&utm\_medium=repo\&utm\_campaign=LT-appium-java-serenity](https://www.lambdatest.com/newsletter/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java-serenity)" target="\_bank"\>Newsletter\</a\>
\&nbsp; &\#8901; \&nbsp;
\<a href="[https://www.lambdatest.com/certifications/?utm\_source=github\&utm\_medium=repo\&utm\_campaign=LT-appium-java-serenity](https://www.lambdatest.com/certifications/?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java-serenity)" target="\_bank"\>Certifications\</a\>
\&nbsp; &\#8901; \&nbsp;
\<a href="[https://www.youtube.com/c/LambdaTest](https://www.youtube.com/c/LambdaTest)" target="\_bank"\>YouTube\</a\>
\</p\>

*Appium is a tool for automating native, mobile web, and hybrid applications... Perform Appium automation tests on [LambdaTest's online cloud](https://www.lambdatest.com/appium-mobile-testing?utm_source=github&utm_medium=repo&utm_campaign=LT-appium-java-serenity).*

## Modernization Updates

  * **Serenity 4.2.63:** Upgraded for modern Java compatibility and performance.
  * **Java 17 (LTS):** Configured via `maven.compiler.release` with `--add-opens` for modularity support.
  * **W3C Compliance:** `LambdaTestSerenityDriver.java` updated to use the `lt:options` capability block.
  * **Stability:** Set `serenity.native.events = false` to improve reliability on mobile real devices.

## Pre-requisites

  - Install **Java JDK 17** (Recommended for this version).
  - Install **Maven** for dependency management.

### Clone The Sample Project

```bash
git clone https://github.com/LambdaTest/LT-appium-java-serenity
cd LT-appium-java-serenity
```

### Setting Up Your Authentication

Set LambdaTest `Username` and `Access Key` in environment variables.

**For Linux/macOS:**

```bash
export LT_USERNAME=YOUR_LAMBDATEST_USERNAME
export LT_ACCESS_KEY=YOUR_LAMBDATEST_ACCESS_KEY
```

## Run Your First Test

**Test Scenario:** Check out `TodoApp.java` to view the sample test script. Each method is designed to perform an action and wait 10 seconds for visual confirmation on the dashboard.

### Configuring Your Test Capabilities

You can update your custom capabilities in `LambdaTestSerenityDriver.java`. We now use the modern W3C format:

```java
    Map<String, Object> ltOptions = new HashMap<>();
    ltOptions.put("plugin", "Serenity LambdaTest Plugin");
    ltOptions.put("isRealMobile", true);
    ltOptions.put("app", "lt://proverbial-android");
    capabilities.setCapability("lt:options", ltOptions);
```

## Executing The Tests

The tests can be executed in the terminal using the following command:

```bash
mvn verify -P single      //For single test
mvn verify -P parallel    //For parallel test
```

## Documentation & Resources :books:

   [suspicious link removed]
   [LambdaTest Blog](https://www.lambdatest.com/blog/)
   [LambdaTest Learning Hub](https://www.lambdatest.com/learning-hub/)