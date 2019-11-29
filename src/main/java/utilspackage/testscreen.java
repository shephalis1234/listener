package utilspackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class testscreen extends testscreenshot {

@BeforeMethod
	public void setup() {
		launch();}
@Test
public void test() {
Assert.assertTrue(false);

	}
@AfterMethod
public void teardown() {
	driver.quit();
}
}
