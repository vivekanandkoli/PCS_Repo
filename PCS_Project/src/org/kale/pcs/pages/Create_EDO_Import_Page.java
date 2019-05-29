package org.kale.pcs.pages;

import org.kale.pcs.sdk.Variables_Declaration;
import org.kale.pcs.utils.General_Methods;
import org.kale.pcs.utils.Validate_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Create_EDO_Import_Page 
{
	WebDriver driver;	
	Variables_Declaration vd=new Variables_Declaration();
	General_Methods gm=new General_Methods();
	Validate_Elements ve=new Validate_Elements();
	
	public Create_EDO_Import_Page(WebDriver dr)
	{
		driver=dr;
	}
	
	public void Create_EDO(String Container_Line_Agent,String Container_Line_Agent_Code,String Vessel_Line_Agent,String Vessel_Line_Agent_Code,
			String Import_Manifest_No,String Import_Manifest_Date,String Bill_of_Lading_No,String Bill_of_Lading_Date,
			String Consignee,String Consignee_Address,String Total_No_of_BL_Pkgs,String BL_Weight,String Volume,
			String Vessel_Name,String Voyage_No,String Berth_Date,String Berth_hour,String Berth_Minutes,
			String Port_of_Loading,String Port_of_Discharge,String Final_Port_Delivery,String Delivery_Type,
			String Shipment_Type,String Cargo_Type,	String Total_Count_20,String Total_Count_40,
			String Total_Count_45,String Cargo_Description,String Marks_And_No,String Container_No,
			String Container_Type,String Container_Size,String ISO_Code,String Weight,String Seal_No) throws Exception
	{
		driver.findElement(By.id("ctl00_lblMode")).click();
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("ctl00_lnkForwarding"));
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.id("ctl00_liFFImport")).click();
		
		driver.findElement(By.id("ctl00_hldPage_btnCreate")).click();
		
		vd.WebEle_Container_Line_Agent=driver.findElement(By.id("ctl00_hldPage_txtShippingLine"));
		vd.WebEle_Container_Line_Agent.sendKeys(Container_Line_Agent);
		Thread.sleep(2000);
		vd.WebEle_Container_Line_Agent.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(2000);
		vd.WebEle_Container_Line_Agent.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		vd.WebEle_Container_Line_Agent.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
//		vd.WebEle_Container_Line_Agent_Code=driver.findElement(By.id("ctl00_hldPage_txtShippingLineCode"));
//		vd.WebEle_Container_Line_Agent_Code.sendKeys(Container_Line_Agent_Code);
		
		vd.WebEle_Vessel_Line_Agent=driver.findElement(By.id("ctl00_hldPage_txtShippingLineAgent"));
		vd.WebEle_Vessel_Line_Agent.sendKeys(Vessel_Line_Agent);
		Thread.sleep(2000);
		vd.WebEle_Vessel_Line_Agent.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(2000);
		vd.WebEle_Vessel_Line_Agent.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		vd.WebEle_Vessel_Line_Agent.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
//		vd.WebEle_Vessel_Line_Agent_Code=driver.findElement(By.id("ctl00_hldPage_txtShippingLineAgentCode"));
//		vd.WebEle_Vessel_Line_Agent_Code.sendKeys(Vessel_Line_Agent_Code);
		
		vd.WebEle_Import_Manifest_No=driver.findElement(By.id("ctl00_hldPage_txtIGMNo"));
		vd.WebEle_Import_Manifest_No.sendKeys(Import_Manifest_No);
		
		vd.WebEle_Import_Manifest_Date=driver.findElement(By.id("ctl00_hldPage_txtIGMDate"));
		vd.WebEle_Import_Manifest_Date.sendKeys(Import_Manifest_Date);
		
		vd.WebEle_Bill_of_Lading_No=driver.findElement(By.id("ctl00_hldPage_txtBLNo"));
		vd.WebEle_Bill_of_Lading_No.sendKeys(Bill_of_Lading_No);
		vd.WebEle_Bill_of_Lading_No.sendKeys(Keys.TAB);

		Thread.sleep(10000);
		vd.WebEle_Bill_of_Lading_Date=driver.findElement(By.id("ctl00_hldPage_txtBLDate"));
		Thread.sleep(1000);
		vd.WebEle_Bill_of_Lading_Date.click();
		Thread.sleep(1000);
		vd.WebEle_Bill_of_Lading_Date.sendKeys(Bill_of_Lading_Date);
	
		
		vd.WebEle_Consignee=driver.findElement(By.id("ctl00_hldPage_txtconsignee"));
		vd.WebEle_Consignee.sendKeys(Consignee); 
		
		System.out.println(Consignee);
		
		vd.WebEle_Consignee_Address=driver.findElement(By.id("ctl00_hldPage_txtConsigneeAdress"));
		vd.WebEle_Consignee_Address.sendKeys(Consignee_Address);
		
		vd.WebEle_Total_No_of_BL_Pkgs=driver.findElement(By.id("ctl00_hldPage_txtTotalNoofBLPkgs"));
		vd.WebEle_Total_No_of_BL_Pkgs.sendKeys(Total_No_of_BL_Pkgs);
		
		vd.WebEle_BL_Weight=driver.findElement(By.id("ctl00_hldPage_txtBLGrossWt"));
		vd.WebEle_BL_Weight.sendKeys(BL_Weight);
		
		vd.WebEle_BL_Weight=driver.findElement(By.id("ctl00_hldPage_txtGrossVol"));
		vd.WebEle_BL_Weight.sendKeys(BL_Weight);
		
		vd.WebEle_Volume=driver.findElement(By.id("ctl00_hldPage_txtGrossVol"));
		vd.WebEle_Volume.sendKeys(Volume);
		
		vd.WebEle_Vessel_Name=driver.findElement(By.id("ctl00_hldPage_txtVSLName"));
		vd.WebEle_Vessel_Name.sendKeys(Vessel_Name);
		
		vd.WebEle_Voyage_No=driver.findElement(By.id("ctl00_hldPage_txtVoyageNo"));
		vd.WebEle_Voyage_No.sendKeys(Voyage_No);
		
		vd.WebEle_Berth_Date=driver.findElement(By.id("ctl00_hldPage_txtBirthDate"));
		vd.WebEle_Berth_Date.sendKeys(Berth_Date);
		
		vd.WebEle_Berth_hour=driver.findElement(By.id("ctl00_hldPage_drpdosHH"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Berth_hour=new org.openqa.selenium.support.ui.Select(vd.WebEle_Berth_hour);
		Cbo_Berth_hour.selectByVisibleText(Berth_hour);
		
		vd.WebEle_Berth_hour=driver.findElement(By.id("ctl00_hldPage_drpdosMM"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Berth_Minutes=new org.openqa.selenium.support.ui.Select(vd.WebEle_Berth_Minutes);
		Cbo_Berth_Minutes.selectByVisibleText(Berth_Minutes);
		
		vd.WebEle_Port_of_Loading=driver.findElement(By.id("ctl00_hldPage_GenericAutoPOL_txtCode"));
		vd.WebEle_Port_of_Loading.sendKeys(Port_of_Loading);
		
		vd.WebEle_Port_of_Discharge=driver.findElement(By.id("ctl00_hldPage_GenericAutoPOD_txtCode"));
		vd.WebEle_Port_of_Discharge.sendKeys(Port_of_Discharge);
		
		vd.WebEle_Final_Port_Delivery=driver.findElement(By.id("ctl00_hldPage_txtFinalPortDelievery"));
		vd.WebEle_Final_Port_Delivery.sendKeys(Final_Port_Delivery);
		
		vd.WebEle_Shipment_Type=driver.findElement(By.id("ctl00_hldPage_drpShipmentType"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Shipment_Type=new org.openqa.selenium.support.ui.Select(vd.WebEle_Shipment_Type);
		Cbo_Shipment_Type.selectByVisibleText(Shipment_Type);
		
		vd.WebEle_Cargo_Type=driver.findElement(By.id("ctl00_hldPage_ddlCargo"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Cargo_Type=new org.openqa.selenium.support.ui.Select(vd.WebEle_Cargo_Type);
		Cbo_Cargo_Type.selectByVisibleText(Cargo_Type);
		
		vd.WebEle_Total_Count_20=driver.findElement(By.id("ctl00_hldPage_txtTotalCount1"));
		vd.WebEle_Total_Count_20.sendKeys(Total_Count_20);
		
		vd.WebEle_Total_Count_40=driver.findElement(By.id("ctl00_hldPage_txtTotalCount2"));
		vd.WebEle_Total_Count_40.sendKeys(Total_Count_40);
		
		vd.WebEle_Total_Count_45=driver.findElement(By.id("ctl00_hldPage_txtTotalCount3"));
		vd.WebEle_Total_Count_45.sendKeys(Total_No_of_BL_Pkgs);
		
		vd.WebEle_Cargo_Description=driver.findElement(By.id("ctl00_hldPage_txtCargoDescription"));
		vd.WebEle_Cargo_Description.sendKeys(Cargo_Description);
		
		vd.WebEle_Marks_And_No=driver.findElement(By.id("ctl00_hldPage_txtMarksNo"));
		vd.WebEle_Marks_And_No.sendKeys(Marks_And_No);
		
		vd.WebEle_Container_No=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtContainerNO"));
		vd.WebEle_Container_No.sendKeys(Container_No);
		
		vd.WebEle_Container_Size=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_drpSize"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Container_Size=new org.openqa.selenium.support.ui.Select(vd.WebEle_Container_Size);
		Cbo_Container_Size.selectByVisibleText(Container_Size);
		
		vd.WebEle_Container_Type=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_drpType"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Container_Type=new org.openqa.selenium.support.ui.Select(vd.WebEle_Container_Type);
		Cbo_Container_Type.selectByVisibleText(Container_Size);
		
		vd.WebEle_ISO_Code=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtISOCode"));
		vd.WebEle_ISO_Code.sendKeys(ISO_Code);
		
		vd.WebEle_Weight=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtWeight"));
		vd.WebEle_Weight.sendKeys(Weight);
		
		vd.WebEle_Seal_No=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtSealNo"));
		vd.WebEle_Seal_No.sendKeys(Seal_No);
		
		
		
		
		
		
		
		
		
		
		
	

		
	}
}