package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryAnnotationTransformerExample {
    private String name;
 
    @Factory
    public FactoryAnnotationTransformerExample(String name) {
        this.name = name;
        System.out.println("In constructor: " + name);
    }
    @BeforeMethod
    public void t2() {
        System.out.println("Before name is ");
    }
    @Test
    public void t1() {
        System.out.println("Method is t1, name is " + name);
    }       
}