package Listener;

import java.lang.reflect.Method;

import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ListenerItst implements ITest {
	private ThreadLocal<String> testName = new ThreadLocal<>();
	@DataProvider(name = "role")
	   public static Object[][] roles() {
	       return new Object[][] {{"Developer"},{"Team Lead"},{"QA"},{"Business Analyst"},{"DevOps Eng"},{"PMO"} };
	   }
	@Test(dataProvider = "role")
	   public void createUser(String role) {
	 
	   }
	@BeforeMethod
	public void BeforeMethod(Method method, Object[] testData, ITestContext ctx) {
	   if (testData.length > 0) {
	      testName.set(method.getName() + "_" + testData[0]);
	      ctx.setAttribute("testName", testName.get());
	   } else
	      ctx.setAttribute("testName", method.getName());
	}
	   @BeforeMethod
	   public void BeforeMethod(Method method, Object[] testData){
	       testName.set(method.getName() + "_" + testData[0]);
	   }
	 
	   @Override
	   public String getTestName() {
	       return testName.get();
	   }
}