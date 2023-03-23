package org.apivalidation.test;

import org.apivalidation.utility.ApiUtilities;
import org.apivalidation.utility.PropertiesRead;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static String baseURL;
	public static long timeResponse;
	public static ApiUtilities apiUtilities;
	public static PropertiesRead propertiesRead;

	@BeforeClass
	public void setupApplication()
	{
		Reporter.log("=====Base Class Setup Started=====", true);
		propertiesRead = new PropertiesRead();
		apiUtilities = new ApiUtilities(propertiesRead);
		propertiesRead.getPropertiesFile("config.properties");

		baseURL = propertiesRead.returnProperties("URL");
		timeResponse = Long.parseLong(propertiesRead.returnProperties("TIME_RESPONSE"));
		Reporter.log("=====Base Class Setup Complete=====", true);
	}
	
	@AfterClass
	public void closeApplication()
	{
		Reporter.log("=====Session End=====", true);
	}
}
