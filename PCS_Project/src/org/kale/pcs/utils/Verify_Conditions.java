package org.kale.pcs.utils;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class Verify_Conditions
{
	public static void checkPoint(boolean result, String message)
	{
		SoftAssert softAssert = new SoftAssert();
		if(result) 
		{
			message = message + " : Pass";
		} else 
		{
			message = message + " : Fail";
		}
		Reporter.log(message);
		softAssert.assertTrue(result, message);
	}
}
