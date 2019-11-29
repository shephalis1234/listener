package dynamic;


import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class dynamicsml {
public static void main(String args[]) {
	XmlSuite suite=new XmlSuite(); 
	suite.setName("Listeners Implementation");
	suite.setParallel("false");
	suite.setVerbose(2);
	XmlTest test=new XmlTest(suite);
	test.setName("Test");
	test.setThreadCount(5);
	XmlClass testClass = new XmlClass ();
	
//	XmlClass class=new XmlClass(TestPublicMethod.class);
	List <XmlClass> list=new ArrayList<XmlClass>();
	list.add(testClass);
	test.setXmlClasses(list);
	TestNG testng=new TestNG();
	List <XmlSuite> suites=new ArrayList<XmlSuite>();
	suites.add(suite);
	testng.setXmlSuites(suites);
	testng.run();
}
}
