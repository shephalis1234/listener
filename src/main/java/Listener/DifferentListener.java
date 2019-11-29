package Listener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IAlterSuiteListener;
import org.testng.IAnnotationTransformer;
import org.testng.IClassListener;
import org.testng.IConfigurable;
import org.testng.IConfigurationListener;
import org.testng.IConfigureCallBack;
import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.IExecutionListener;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IInvokedMethodListener2;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.IReporter;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITest;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import org.testng.internal.IResultListener;
import org.testng.xml.XmlSuite;

import DataProvider.DataProviderFactory;
import utilspackage.Log;
import utilspackage.retryanalyzer;


public class DifferentListener implements  IAnnotationTransformer,IExecutionListener,IReporter,IHookable,ITestListener,IInvokedMethodListener, IConfigurationListener,IConfigurable,ITestNGListener, IClassListener, IInvokedMethodListener2 {
	 
	  private long startTime;
    //Iannotationtransformer	
  
	   public void transform(ITestAnnotation annotation, Class testClass,
	            Constructor testConstructor, Method testMethod) { 
	 annotation.setRetryAnalyzer(retryanalyzer.class);
	        if (testMethod.getName().equals("t1")) {
Log.info("set data provider for " + testMethod.getName());
	            annotation.setDataProviderClass(DataProviderFactory.class);
	            annotation.setDataProvider("getDp1");
	        } else if (testMethod.getName().equals("t2")) {
	        	Log.info("set data provider for " + testMethod.getName()); 
	            annotation.setDataProviderClass(DataProviderFactory.class);
	            annotation.setDataProvider("getDp2");
	        } else if (testMethod.getName().equals("t3")) {
	        	Log.info("Disable " + testMethod.getName()); 
	            annotation.setEnabled(false);
	        }
}
     //Iexecution
     public void onExecutionStart() {
         startTime = System.currentTimeMillis();
         Log.info("TestNG is going to start" +System.currentTimeMillis());     
     }
  
   
     public void onExecutionFinish() {
         Log.info("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");
     }

//ItestListener
     
     public void onTestStart(ITestResult result) {
         Log.info("on test method " +  getTestMethodName(result) + " start");
//         testWatcher.set(extent.createTest(iTestResult.getTestContext().getAttribute("testName").toString()));

     }
  
     public void onTestSuccess(ITestResult result) {
         Log.info("on test method " + getTestMethodName(result) + " success");
     }
  
     public void onTestFailure(ITestResult result) {
         Log.info("***** Error "+result.getName()+" test has failed *****");
     	
     }
  
   
     public void onTestSkipped(ITestResult result) {
         Log.info("test method " + getTestMethodName(result) + " skipped");
     }


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

public void onStart(ITestContext context) {
	        Log.info("on start of test " + context.getName());
	    }
	 
	    public void onFinish(ITestContext context) {
	        Log.info("on finish of test " + context.getName());
	    }
	 private static String getTestMethodName(ITestResult result) {
	        return result.getMethod().getConstructorOrMethod().getName();
	    }

//Ireporter
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		for (ISuite suite : suites) {
            
	         //Following code gets the suite name
	         String suiteName = suite.getName();
	            
	         //Getting the results for the said suite
	         Map<String, ISuiteResult> suiteResults = suite.getResults();
	         for (ISuiteResult sr : suiteResults.values()) {
	            ITestContext tc = sr.getTestContext();
	            Log.info("Passed tests for suite '" + suiteName +
	               "' is:" + tc.getPassedTests().getAllResults().size());
	            Log.info("Failed tests for suite '" + suiteName +
	               "' is:" + tc.getFailedTests().getAllResults().size());
	            Log.info("Skipped tests for suite '" + suiteName +
	               "' is:" + tc.getSkippedTests().getAllResults().size());
	         }
	      }
	   }
	//Ihookable
    public void run(IHookCallBack callBack, ITestResult testResult) {
        Object[] parms = callBack.getParameters();
        if (parms[0].equals("dummy")) {
            Log.info("Skip for parameter dummy");         
        } else {
            callBack.runTestMethod(testResult);
        }
    }
      //IInvokedMethodListener   
 
  
       public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
			// TODO Auto-generated method stub
    	   Log.info("before invocation of " + method.getTestMethod().getMethodName());
		}


		public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
			// TODO Auto-generated method stub
			Log.info("after invocation " + method.getTestMethod().getMethodName());
		}
//    IMethodInterceptor
		
		public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
			List<IMethodInstance> result = new ArrayList<IMethodInstance>();
			for (IMethodInstance method : methods) {
				Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
				if (testMethod.priority() == 1) {
					result.add(method);
				}
			}
			return result;
		}
//IconfigurableListener
		public void onConfigurationSuccess(ITestResult itr) {
			// TODO Auto-generated method stub
//			Log.info("suite >>>>>>>>>>>>>>>"+itr.getMethod().getMethodName());
		}

		public void onConfigurationFailure(ITestResult itr) {
			// TODO Auto-generated method stub
			Log.info("suite failed"+itr.getMethod().getMethodName());

		}

		public void onConfigurationSkip(ITestResult itr) {
			// TODO Auto-generated method stub
			Log.info("suite skipped"+itr.getMethod().getMethodName());
		}

		public void run(IConfigureCallBack callBack, ITestResult testResult) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onBeforeClass(ITestClass testClass) {
			// TODO Auto-generated method stub
			Log.info("test is before class");
		}

		@Override
		public void onAfterClass(ITestClass testClass) {
			// TODO Auto-generated method stub
			Log.info("test is after class");

		}
//iinvokedmethodlistener2
		@Override
		public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
			// TODO Auto-generated method stub
			
		}
		//data providerlistener
		


		
		
		
		
   
	}