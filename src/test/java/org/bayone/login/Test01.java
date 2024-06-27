package org.bayone.login;

import java.io.IOException;

import org.bayone.factory.TestData;
import org.bayone.generics.SagarGenericLib;
import org.testng.annotations.Test;

public class Test01 {
	SagarGenericLib reFunc = new SagarGenericLib();
	String browserLink = "https://www.makemytrip.com/";
	TestData datafactory;
	
	@Test
	public void launchBrowser() throws IOException {
		reFunc.launchURL();
	}

}
