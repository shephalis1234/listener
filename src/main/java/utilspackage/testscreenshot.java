package utilspackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testscreenshot {
	public static WebDriver driver;
	
     public void launch() {
    	 WebDriverManager.chromedriver().setup();
    	 driver=new ChromeDriver();
    	 driver.get("https://www.google.com/");
    	driver.close();
    	
     }
	
	 public void takeScreenShot() {
		 
		 TakesScreenshot Take=(TakesScreenshot)driver;
    	 File scrFile = (Take.getScreenshotAs(OutputType.FILE));
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File("C://HaudAPI//Testng_Listener//screenshot//1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
}
}

