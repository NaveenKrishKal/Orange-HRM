package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseParent;
import com.runner.Runner;

import io.cucumber.java.en.*;
import io.cucumber.messages.types.Hook;

public class OHLoginDef extends BaseParent{
	
	public static WebDriver driver = Runner.driver;
	
	
	@Given("User need to launch the OrangeHRM url")
	public void user_need_to_launch_the_orange_hrm_url() {
		getUrl("https://opensource-demo.orangehrmlive.com");
	}

	@When("User need to send the username")
	public void user_need_to_send_the_username() {
		sendKey(driver.findElement(By.xpath("//input[@placeholder='Username']")), "Admin");
	}

	@When("User need to send the password")
	public void user_need_to_send_the_password() {
		sendKey(driver.findElement(By.xpath("//input[@placeholder='Password']")), "admin123");
	}

	@When("User need to click the login button")
	public void user_need_to_click_the_login_button() {
		Click(driver.findElement(By.xpath("//button[@type='submit']")));
	}

	@Then("User need to get the homepage")
	public void user_need_to_get_the_homepage() {
		String empinfo = driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")).getText();
		String s = "Employee Information";
		if (empinfo.equals(s)) {
			System.out.println("Login successfully");
		} else {
			System.out.println("Invalid");
		}
		
	}



}
