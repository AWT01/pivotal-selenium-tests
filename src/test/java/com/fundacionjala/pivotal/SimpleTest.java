package com.fundacionjala.pivotal;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = {"fast"})
    public void aFastTest() {
        System.out.println("Fast test");
        SeleniumTest seleniumTest = new SeleniumTest();
        Assert.assertEquals(seleniumTest.returnStringTest(), "Test");
    }

    @Test(groups = {"slow"})
    public void aSlowTest() {
        System.out.println("Slow test");
    }
}


