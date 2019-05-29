package org.kale.pcs.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.kale.pcs.TestDataReaders.PropertiesFileReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class General_Methods
{
	byte[] longToByteArray ( final long i ) throws IOException
	{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeLong(i);
        dos.flush();
        return bos.toByteArray();
	}
	
	public String random_number() // For AWB
    {
		Random number = new Random();
		String AWBno1 = "";
		int i, j, k;
		for (i = 0; i < 9; i++)
		{
			i = number.nextInt(100000) + (999999);
			j = 7;
			k = i % j;
			AWBno1 += String.valueOf(String.valueOf(i) + String.valueOf(k));
		}
        return AWBno1;
    }
	
	public String random_Num() // For random numbers
    {
		
		
		Random r = new Random();
		
		int i;
		String RandomNum = "";
		for (i = 0; i < 9; i++)
		{
			
			RandomNum += r.nextInt();
		}
        return RandomNum;
    }
	
	
	public String random_Alphabets() 
    {
		
		final String alphabet = "0123456789ABCDE";
	    final int N = alphabet.length();
	    
		Random r = new Random();
		
		int i;
		String RandomNum = "";
		for (i = 0; i < 10; i++)
		{
			
			RandomNum += alphabet.charAt(r.nextInt(N));
		}
        return RandomNum;
    }
	
	public String screenShot(WebDriver driver)
  	 {
  	  String Timestamp;
  	  String  ScreenShotPath = null;
 
  	  try
        {       
  		
  		PropertiesFileReader pfr=new PropertiesFileReader();
		pfr.loadPropertiesFile();
		String ScreenShotPath1 = pfr.getPropertyValue("Screenshotpath");
		
  	       Timestamp=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(Calendar.getInstance().getTime());
  	       ScreenShotPath=ScreenShotPath1+Timestamp+".jpg";
  	       File screenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);       		 
	          FileUtils.copyFile(screenshots, new File(ScreenShotPath));       		    
  		 }
  	  catch(Exception Ex)
  	  {
  		  System.out.println(Ex.getMessage());
  	
  	  }
  	  return ScreenShotPath;
  	 }
	
	public Boolean isAlertPresent(WebDriver driver)
    {
        
        try
        {
            Alert alert = driver.switchTo().alert();
           // System.out.println("Alert present");
            
            return true;
        }

        catch (Exception ex)
        {
       //	 System.out.println("Alert not  present");
           
            return false;
           
        }
       
    }
	
	// For link text
	public  Boolean TryFindElement_linktext(WebDriver driver, String  element1)
    {
        
        try
        {
            WebElement element = driver.findElement(By.linkText("" + element1 + ""));

            if (true)
            {
                Boolean visible = IsElementVisible(element);

                if (visible == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            //return true;
        }
        catch (Exception ex)
        {
            return false;
            //throw ex;
        }
        return false;
    }
	 
	public  Boolean TryFindElement_id(WebDriver driver, String  element1)
    {
        
        try
        {
            WebElement element = driver.findElement(By.id("" + element1 + ""));

            if (true)
            {
                Boolean visible = IsElementVisible(element);

                if (visible == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            //return true;
        }
        catch (Exception ex)
        {
            return false;
            //throw ex;
        }
        return false;
    }
	
	// For Xpath
	public  Boolean TryFindElement_xpath(WebDriver driver, String  element1)
    {
        
        try
        {
            WebElement element = driver.findElement(By.xpath("" + element1 + ""));

            if (true)
            {
                Boolean visible = IsElementVisible(element);

                if (visible == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            //return true;
        }
        catch (Exception ex)
        {
            return false;
            //throw ex;
        }
        return false;
    }
		 
    public Boolean IsElementVisible(WebElement element)
    {
        return element.isDisplayed() && element.isEnabled();
    }
    
    public  Boolean TryFindElement_2(WebDriver driver, String  element1)
    {
        
        try
        {
            WebElement element = driver.findElement(By.id("" + element1 + ""));

            if (true)
            {
                Boolean visible = IsElementVisible1(element);

                if (visible == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            //return true;
        }
        catch (Exception ex)
        {
            return false;
            //throw ex;
        }
        return false;
    }
    
    public Boolean IsElementVisible1(WebElement element)
    {
        return element.isDisplayed();
    }
	public void visibilityofElement(WebDriver driver,By by)
	
	{
		WebElement elementToBeLoaded = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 1550);
		//WebElement element1 = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));

	}


	public String GetStartTime()
	{
		String StartTime=new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		return StartTime;
	}



}
