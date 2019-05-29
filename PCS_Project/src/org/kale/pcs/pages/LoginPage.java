package org.kale.pcs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver dr)
	{
		driver=dr;
	}
	
	/**
	 * This method is used to login to rediff
	 *
	 * @param username username of rediff user
	 * @param password password of rediff user
	 */
	
	public void login (String entity,String username, String password)
	{
		Select yts=new Select(driver.findElement(By.id("drpEntity")));
		yts.selectByVisibleText(entity);
		driver.findElement(By.id("txtUsrName")).sendKeys(username);
		driver.findElement(By.id("txtPswd")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
	}	
}
