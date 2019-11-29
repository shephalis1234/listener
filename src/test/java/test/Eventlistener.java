package test;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import Listener.webdrivereventlistener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Eventlistener {
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static webdrivereventlistener eventListener;
@Test
public void launch() {
	WebDriverManager.chromedriver().setup();

  WebDriver driver = new ChromeDriver();
  e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new webdrivereventlistener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
}
@Test
public void method() {
	assertTrue(false);
	
	
}
@Test
public void method1() {
	assertTrue(false);
	
	
}
@Test
public void method2() {
	assertTrue(false);
	
	
}

}