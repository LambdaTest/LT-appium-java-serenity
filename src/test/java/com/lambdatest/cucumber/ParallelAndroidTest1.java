package com.lambdatest.cucumber;

import com.lambdatest.LambdaTestSerenityTest;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class) @CucumberOptions(features = "src/test/resources/features", tags = "@single_feature") public class ParallelAndroidTest1
  extends LambdaTestSerenityTest {
}
