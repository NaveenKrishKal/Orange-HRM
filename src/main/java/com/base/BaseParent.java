package com.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseParent {
public static WebDriver driver;
public static WebDriver getBrowser(String browsername) { //Get Browser
	
	try {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\driver\\chromedriver.exe"));
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+("\\driver\\msedgedriver.exe"));
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return driver;
}

public static void getUrl(String url) { //Get Url
try {
	driver.get(url);
} catch (Exception e) {
	e.printStackTrace();
}
}

public static void sendKey(WebElement user, String name ) {//Send key
	user.sendKeys(name);
}

public  static void Click(WebElement login) { //Click
try {
	login.click();
} catch (Exception e) {
	e.printStackTrace();
}
}

public static void navigateTo( String value) {//Navigate to

	try {
		driver.navigate().to(value);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void back() { //Back
	try {
		driver.navigate().back();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void forward() {//Forward
try {
	driver.navigate().forward();
} catch (Exception e) {
	e.printStackTrace();
}
}

public static void refresh() {//Refresh
try {
	driver.navigate().refresh();
} catch (Exception e) {
	e.printStackTrace();
}
}

public static void quit() {//Quit
try {
	driver.quit();
} catch (Exception e) {
	e.printStackTrace();
}
}

public static void close() {//Close
try {
	driver.close();
} catch (Exception e) {
	e.printStackTrace();
}
}

public static void acceptAlert(WebElement path) {//Accept Alert
path.click();
driver.switchTo().alert().accept();
}

public static void denyAlert(WebElement path) {//Deny Alert
driver.switchTo().alert().dismiss();
}

public static void alertWithValue(WebElement path, String value) {//Alert with Value
path.click();
driver.switchTo().alert().sendKeys(value);
driver.switchTo().alert().accept();
}

public static void contextClick(WebElement path) {//Context Click 
Actions ac = new Actions(driver);
ac.contextClick().perform();
}

public static void singleFrame(WebElement path2, String value) {//Single Frame
driver.switchTo().frame(0);
path2.sendKeys(value);
}

public static void robotClass(WebElement element) throws Throwable {//Robot Class
	Actions ac = new Actions(driver);
	ac.contextClick(element).perform();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyPress(KeyEvent.VK_ENTER);
}

public static void currentUrl(WebElement element) { //Current URL
driver.getCurrentUrl();
System.out.println(element);
}

public static void getTitile(WebElement element) {//Title
driver.getTitle();
System.out.println(element);
}

public static void windowhandle(WebElement element) throws Throwable {//Window Handle
	Actions ac = new Actions(driver);
	ac.contextClick(element).perform();
	Robot ro = new Robot();
	ro.keyPress(KeyEvent.VK_DOWN);
	ro.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
}

public static void screenShot() throws Throwable {//Screen Shot
	TakesScreenshot s = (TakesScreenshot) driver;
	File get = s.getScreenshotAs(OutputType.FILE);
	File img = new File("C:\\Users\\Naveen Krish Kalyan\\eclipse-workspace\\BaseClass\\screenshot\\img.png");
	FileUtils.copyFile(get, img);
}

public static void getText(WebElement element) {//Get Text
	element.getText();
	System.out.println(element);
}

public static void scrollupdown() throws Throwable {//Scroll
	JavascriptExecutor d = (JavascriptExecutor) driver;
	d.executeScript("window.scrollBy(0,2000)");
	Thread.sleep(2000);
}

public static void dropDown(WebElement element, String value) {//Drop Down
	Select s1 = new Select(element);
	s1.selectByVisibleText(value);
}

public static void mouseHover(WebElement hover) {//Mousehover
	Actions ac = new Actions(driver);
	ac.moveToElement(hover).perform();
	
}
}


	
	

