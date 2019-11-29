package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test2 {
	 @Test(retryAnalyzer = utilspackage.retryanalyzer.class)
     public void test1() {
    	assertTrue(false);
     }
	
}
