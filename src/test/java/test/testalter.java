package test;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilspackage.Log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class testalter {
	@BeforeClass
	public void cl() {
		BasicConfigurator.configure();
//		PropertyConfigurator.configure("\\log4j.properties");
//		Logger log=Logger.getLogger(log4j.class);
		Log.info("****************************** Starting test cases execution  *****************************************");
//		System.out.println("start");
	}
@Test
public void m1() {
	
}
@Test
public void m2() {
	
}
@Test
public void m3() {
	
}
@Test
public void m4() {
	
}
@Test
public void m5() {
	
}
@AfterClass
public void cl1() {
	System.out.println("teardown");
}
}
