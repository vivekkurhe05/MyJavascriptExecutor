package com.javascriptConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class MyJavascriptExecutor {
	
	static JavascriptExecutor js;
	static WebElement submitBtn;

	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sai\\workspace\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new HtmlUnitDriver(true);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/register/");
//		driver.findElement(By.name("first_name")).sendKeys("vivek");
		js.executeScript("document.getElementByName('first_name').value='vivekkurhe05'");
		
		
		scrollIntoview(driver, submitBtn);
		clickOnButton(driver);
		
		
		String title = getTitle(driver);
		System.out.println("Title is ======="+title);
		
		js.executeScript("document.getElementById('submitButton').scrollIntoView();", submitBtn);
		String buttonTxt = js.executeScript("return document.getElementById('submitButton').innerHTML", submitBtn).toString();
		System.out.println("button text is========="+buttonTxt);
		
		
	}
	
	public static void scrollIntoview(WebDriver driver, WebElement submitBtn){
		js = (JavascriptExecutor)driver;
		submitBtn = driver.findElement(By.id("submitButton"));
		js.executeScript("arguments[0].scrollIntoView(true)", submitBtn);
	}
	
	
	public static void clickOnButton(WebDriver driver){
		js = (JavascriptExecutor)driver;
		submitBtn = driver.findElement(By.id("submitButton"));
		js.executeScript("document.getElementById('submitButton').click();");		
		
		
		
	}
	
	public static String getTitle(WebDriver driver){
		js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title").toString();
		return title;
		
	}

}
