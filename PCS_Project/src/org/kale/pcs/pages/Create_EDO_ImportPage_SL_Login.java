package org.kale.pcs.pages;

import org.kale.pcs.sdk.Variables_Declaration;
import org.kale.pcs.utils.General_Methods;
import org.kale.pcs.utils.Validate_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Create_EDO_ImportPage_SL_Login 
{
	WebDriver driver;	
	Variables_Declaration vd=new Variables_Declaration();
	General_Methods gm=new General_Methods();
	Validate_Elements ve=new Validate_Elements();
	
	public Create_EDO_ImportPage_SL_Login(WebDriver dr)
	{
		driver=dr;
	}
	
	public void Create_EDO(String SC_ID,String Description,String ExcelSavePath,String Invoice_No,
			String Invoice_Date,String Charge_Head,String Exchange_Currency_Amt,String Currency,
			String Exchange_Rate) throws Exception
	{
		driver.findElement(By.id("ctl00_lblMode")).click();
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("ctl00_lnkForwarding"));
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.id("ctl00_liFFImport")).click();
		
		driver.findElement(By.xpath("//a[contains(.,'DO DashBoard')]")).click();
		
		driver.findElement(By.id("ctl00_hldPage_grdDORequest_ctl02_lnkDoRequestNo")).click();
		
		driver.findElement(By.id("ctl00_hldPage_btnDOFee")).click();
		
		driver.findElement(By.id("ctl00_hldPage_grdInvocieDetails_ctl02_txtInvoiceNo")).sendKeys(Invoice_No);
		
		driver.findElement(By.id("ctl00_hldPage_grdInvocieDetails_ctl02_txtInvoiceDate")).sendKeys(Invoice_Date);
		
		driver.findElement(By.id("ctl00_hldPage_grdInvocieDetails_ctl02_ImgAddCharge")).click();
		
		org.openqa.selenium.support.ui.Select 
		Cbo_Charge_Head=new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("ctl00_hldPage_rptInvDetails_ctl01_drpChargeHead")));
		Cbo_Charge_Head.selectByVisibleText(Charge_Head);
		
		driver.findElement(By.id("ctl00_hldPage_rptInvDetails_ctl01_txtAmtUSD")).sendKeys(Exchange_Currency_Amt);
		
		org.openqa.selenium.support.ui.Select 
		Cbo_Currency=new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("ctl00_hldPage_rptInvDetails_ctl01_drpCurrency")));
		Cbo_Currency.selectByVisibleText(Currency);
		
		driver.findElement(By.id("ctl00_hldPage_rptInvDetails_ctl01_txtExchangeRate")).sendKeys(Exchange_Rate);
		
		driver.findElement(By.id("ctl00_hldPage_btnPopupChrgSaveClose")).click();
		
		
		
		
		
		
		
		
	}
}
