package com.runner;

import java.time.Duration;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.base.BaseParent;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\java\\com\\feature", glue = "com\\stepdefinition", dryRun = false, monochrome = true)
public class Runner {
	
	public static WebDriver driver;
	
	
	@BeforeClass
	public static void driverLaunch() {
		driver=BaseParent.getBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	

}
