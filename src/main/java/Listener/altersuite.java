package Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.IAlterSuiteListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class altersuite implements IAlterSuiteListener {
	public String className;
	public String methodName;
	public void alter(List<XmlSuite> suites) {



}
}