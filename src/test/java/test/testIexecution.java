package test;

import org.apache.log4j.BasicConfigurator;
import org.jsoup.Connection.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.DataProviderFactory;
import Listener.DifferentListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utilspackage.Log;
 
public class testIexecution  {
	public String testName;
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
		
		
    }
    @Test(dataProvider="getDp",priority=1)
    public void t(String p) {
    	BasicConfigurator.configure();
//		PropertyConfigurator.configure("\\log4j.properties");
//		Logger log=Logger.getLogger(log4j.class);
//		System.out.println("start");
    	Log.info("test method t called with parameter " + p);
    }
    @Test(priority=1)
    public void t1(String param) {
    	Log.info("Method is t1, parameter is " + param);
    }
     
    @Test(priority=1)
    public void t2(String param) {
    	Log.info("Method is t2, parameter is " + param);
    }
    
    @Test(priority=1)
    public void t3() {
    	Log.info("Method is t3");
    } 
    @Test(priority=2)
    public void t4() {
    	Log.info("Method is t4");
    }
    @DataProvider
    public Object[][] getDp() {
        return new Object[][]{{"client1"}, {"client2"}, {"dummy"}};
    } 
    @Test
    public void Test1()
    {
    	    Assert.assertEquals(false, true);//check for iannotationtransformer at run level
    }
   
    @AfterSuite
    public void afterSuite() {
    	Log.info("afterSuite");
    }
//	public String getTestName() {
//		Log.info("GetTestname Method Thread id = " + Thread.currentThread().getId() + " TestName = " + testName);
//	    return testName;
//	}
}
