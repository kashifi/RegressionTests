package com.kashifi.testng;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestRptFactory implements ITest {
	private String param;
	
	public TestRptFactory(String param) {
		this.param = param;
	}
	
	public String getTestName() {
		return getClass().getSimpleName() + "-" + param;
	}
	
	@Factory
	public static Object[] create() {
		return new Object[]{new TestRptFactory("TestNG"),
				new TestRptFactory("Reports")};
	}
	
	@Test
	public void f() {
		if (param.equals("Reports")) {
			Assert.assertTrue(false);
		}
	}
}