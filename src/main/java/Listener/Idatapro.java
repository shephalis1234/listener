package Listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class Idatapro implements IDataProviderListener {

	private static Method savedDataProviderMethod = null;

    @Override
    public void afterDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod testNGMethod, ITestContext context) {
        System.out.println(">> afterDataProviderExecution start");
        savedDataProviderMethod = dataProviderMethod.getMethod();
        System.out.println("<< afterDataProviderExecution end");
    }

    @Override public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod testNGMethod, ITestContext context) {
    System.out.println(">> afterDataProviderExecution start");
    }
//   
}