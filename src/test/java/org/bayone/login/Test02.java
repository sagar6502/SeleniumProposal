package org.bayone.login;

import java.io.IOException;

import org.bayone.generics.SagarGenericLib;
import org.bayone.utils.BaseTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class Test02 extends BaseTest{
	SagarGenericLib reFunc = new SagarGenericLib();
//	TestData datafactory;
	
	@Test
	@Description("Testing the framework test-01")
	public void launchBrowser() throws IOException, InterruptedException {
		loginPage.loginValidation();
	}

}
