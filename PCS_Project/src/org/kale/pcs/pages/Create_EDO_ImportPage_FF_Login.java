package org.kale.pcs.pages;

import org.kale.pcs.sdk.Variables_Declaration;

import org.kale.pcs.utils.General_Methods;
import org.kale.pcs.utils.Validate_Elements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_EDO_ImportPage_FF_Login 
{
	WebDriver driver;	
	Variables_Declaration vd=new Variables_Declaration();
	General_Methods gm=new General_Methods();
	Validate_Elements ve=new Validate_Elements();
	
	public Create_EDO_ImportPage_FF_Login(WebDriver dr)
	{
		driver=dr;
	}
	
	public void Create_EDO(String SC_ID,String Description,String ExcelSavePath,String Container_Line_Agent,String Container_Line_Agent_Code,String Vessel_Line_Agent,String Vessel_Line_Agent_Code,
			String Import_Manifest_No,String Import_Manifest_Date,String Bill_of_Lading_No,String Bill_of_Lading_Date,
			String Consignee,String Consignee_Address,String Total_No_of_BL_Pkgs,String BL_Weight,String Volume,
			String Vessel_Name,String Voyage_No,String Berth_Date,String Berth_hour,String Berth_Minutes,
			String Port_of_Loading,String Port_of_Discharge,String Final_Port_Delivery,String Delivery_Type,
			String Shipment_Type,String Cargo_Type,	String Total_Count_20,String Total_Count_40,
			String Total_Count_45,String Cargo_Description,String Marks_And_No,String Container_No,
			String Container_Size,String Container_Type ,String ISO_Code,String Weight,String Seal_No,String TEST_File_Upload) throws Exception
	{
		driver.findElement(By.id("ctl00_lblMode")).click();
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("ctl00_lnkForwarding"));
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.id("ctl00_liFFImport")).click();
		
		driver.findElement(By.id("ctl00_hldPage_btnCreate")).click();
		
		vd.StartTime=gm.GetStartTime();
		
		vd.WebEle_Container_Line_Agent=driver.findElement(By.id("ctl00_hldPage_txtShippingLine"));
		vd.WebEle_Container_Line_Agent.sendKeys(Container_Line_Agent);
		Thread.sleep(2000);
		vd.WebEle_Container_Line_Agent.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(5000);
		vd.WebEle_Container_Line_Agent.sendKeys(Keys.ARROW_DOWN);
		vd.WebEle_Container_Line_Agent.sendKeys(Keys.TAB);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Container Line Agent", "ctl00_hldPage_txtShippingLine", driver, ExcelSavePath, vd.StartTime);
		
		
//		vd.WebEle_Container_Line_Agent_Code=driver.findElement(By.id("ctl00_hldPage_txtShippingLineCode"));
//		vd.WebEle_Container_Line_Agent_Code.sendKeys(Container_Line_Agent_Code);
		
		vd.WebEle_Vessel_Line_Agent=driver.findElement(By.id("ctl00_hldPage_txtShippingLineAgent"));
		vd.WebEle_Vessel_Line_Agent.sendKeys(Vessel_Line_Agent);
		Thread.sleep(2000);
		vd.WebEle_Vessel_Line_Agent.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(5000);
		vd.WebEle_Vessel_Line_Agent.sendKeys(Keys.ARROW_DOWN);
		vd.WebEle_Vessel_Line_Agent.sendKeys(Keys.TAB);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Vessel Line Agent", "ctl00_hldPage_txtShippingLineAgent", driver, ExcelSavePath, vd.StartTime);
		
//		vd.WebEle_Vessel_Line_Agent_Code=driver.findElement(By.id("ctl00_hldPage_txtShippingLineAgentCode"));
//		vd.WebEle_Vessel_Line_Agent_Code.sendKeys(Vessel_Line_Agent_Code);
		
		vd.WebEle_Import_Manifest_No=driver.findElement(By.id("ctl00_hldPage_txtIGMNo"));
		vd.WebEle_Import_Manifest_No.sendKeys(Import_Manifest_No);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Import Manifest No", "ctl00_hldPage_txtIGMNo", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Import_Manifest_Date=driver.findElement(By.id("ctl00_hldPage_txtIGMDate"));
		vd.WebEle_Import_Manifest_Date.sendKeys(Import_Manifest_Date);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Import Manifest Date", "ctl00_hldPage_txtIGMDate", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Bill_of_Lading_No=driver.findElement(By.id("ctl00_hldPage_txtBLNo"));
		vd.WebEle_Bill_of_Lading_No.sendKeys(Bill_of_Lading_No);
		vd.WebEle_Bill_of_Lading_No.sendKeys(Keys.TAB);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Bill of Lading No", "ctl00_hldPage_txtBLNo", driver, ExcelSavePath, vd.StartTime);
		
		Thread.sleep(5000);
		vd.WebEle_Bill_of_Lading_Date=driver.findElement(By.id("ctl00_hldPage_txtBLDate"));
		Thread.sleep(1000);
		vd.WebEle_Bill_of_Lading_Date.click();
		Thread.sleep(1000);
		vd.WebEle_Bill_of_Lading_Date.sendKeys(Bill_of_Lading_Date);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Bill of Lading Date", "ctl00_hldPage_txtBLDate", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Consignee=driver.findElement(By.id("ctl00_hldPage_txtconsignee"));
		vd.WebEle_Consignee.sendKeys(Consignee); 		
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Consignee", "ctl00_hldPage_txtconsignee", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Consignee_Address=driver.findElement(By.id("ctl00_hldPage_txtConsigneeAdress"));
		vd.WebEle_Consignee_Address.sendKeys(Consignee_Address);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Consignee Address", "ctl00_hldPage_txtConsigneeAdress", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Total_No_of_BL_Pkgs=driver.findElement(By.id("ctl00_hldPage_txtTotalNoofBLPkgs"));
		vd.WebEle_Total_No_of_BL_Pkgs.sendKeys(Total_No_of_BL_Pkgs);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Total No of BL Pkgs", "ctl00_hldPage_txtTotalNoofBLPkgs", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_BL_Weight=driver.findElement(By.id("ctl00_hldPage_txtBLGrossWt"));
		vd.WebEle_BL_Weight.sendKeys(BL_Weight);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"BL Weight", "ctl00_hldPage_txtBLGrossWt", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Volume=driver.findElement(By.id("ctl00_hldPage_txtGrossVol"));
		vd.WebEle_Volume.sendKeys(Volume);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Volume", "ctl00_hldPage_txtGrossVol", driver, ExcelSavePath, vd.StartTime);
		
		System.out.println(Volume);
		
		vd.WebEle_Vessel_Name=driver.findElement(By.id("ctl00_hldPage_txtVSLName"));
		vd.WebEle_Vessel_Name.sendKeys(Vessel_Name);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Vessel Name", "ctl00_hldPage_txtVSLName", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Voyage_No=driver.findElement(By.id("ctl00_hldPage_txtVoyageNo"));
		vd.WebEle_Voyage_No.sendKeys(Voyage_No);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Voyage No", "ctl00_hldPage_txtVoyageNo", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Berth_Date=driver.findElement(By.id("ctl00_hldPage_txtBirthDate"));
		vd.WebEle_Berth_Date.sendKeys(Berth_Date);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Berth Date", "ctl00_hldPage_txtBirthDate", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Berth_hour=driver.findElement(By.id("ctl00_hldPage_drpdosHH"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Berth_hour=new org.openqa.selenium.support.ui.Select(vd.WebEle_Berth_hour);
		Cbo_Berth_hour.selectByVisibleText(Berth_hour);
		
		vd.WebEle_Berth_Minutes=driver.findElement(By.id("ctl00_hldPage_drpdosMM"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Berth_Minutes=new org.openqa.selenium.support.ui.Select(vd.WebEle_Berth_Minutes);
		Cbo_Berth_Minutes.selectByVisibleText(Berth_Minutes);
		
		vd.WebEle_Port_of_Loading=driver.findElement(By.id("ctl00_hldPage_GenericAutoPOL_txtCode"));
		vd.WebEle_Port_of_Loading.sendKeys(Port_of_Loading);
		Thread.sleep(2000);
		vd.WebEle_Port_of_Loading.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(2000);
		vd.WebEle_Port_of_Loading.sendKeys(Keys.ARROW_DOWN);		
		vd.WebEle_Port_of_Loading.sendKeys(Keys.TAB);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Port of Loading", "ctl00_hldPage_GenericAutoPOL_txtCode", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Port_of_Discharge=driver.findElement(By.id("ctl00_hldPage_GenericAutoPOD_txtCode"));
		vd.WebEle_Port_of_Discharge.sendKeys(Port_of_Discharge);
		Thread.sleep(2000);
		vd.WebEle_Port_of_Discharge.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(2000);
		vd.WebEle_Port_of_Discharge.sendKeys(Keys.ARROW_DOWN);		
		vd.WebEle_Port_of_Discharge.sendKeys(Keys.TAB);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Port of Discharge", "ctl00_hldPage_GenericAutoPOD_txtCode", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Final_Port_Delivery=driver.findElement(By.id("ctl00_hldPage_txtFinalPortDelievery"));
		vd.WebEle_Final_Port_Delivery.sendKeys(Final_Port_Delivery);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Final Port Delivery", "ctl00_hldPage_GenericAutoPOD_txtCode", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Shipment_Type=driver.findElement(By.id("ctl00_hldPage_drpShipmentType"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Shipment_Type=new org.openqa.selenium.support.ui.Select(vd.WebEle_Shipment_Type);
		Cbo_Shipment_Type.selectByVisibleText(Shipment_Type);
		
		vd.WebEle_Cargo_Type=driver.findElement(By.id("ctl00_hldPage_ddlCargo"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Cargo_Type=new org.openqa.selenium.support.ui.Select(vd.WebEle_Cargo_Type);
		Cbo_Cargo_Type.selectByVisibleText(Cargo_Type);
		
		Thread.sleep(1000);
		vd.WebEle_Total_Count_20=driver.findElement(By.id("ctl00_hldPage_txtTotalCount1"));
		vd.WebEle_Total_Count_20.clear();	
		vd.WebEle_Total_Count_20.sendKeys(Total_Count_20);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Total Count 20", "ctl00_hldPage_txtTotalCount1", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Total_Count_40=driver.findElement(By.id("ctl00_hldPage_txtTotalCount2"));
		vd.WebEle_Total_Count_40.clear();
		vd.WebEle_Total_Count_40.sendKeys(Total_Count_40);
		Thread.sleep(1000);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Total Count 40", "ctl00_hldPage_txtTotalCount2", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Total_Count_45=driver.findElement(By.id("ctl00_hldPage_txtTotalCount3"));
		vd.WebEle_Total_Count_45.clear();
		vd.WebEle_Total_Count_45.sendKeys(Total_Count_45);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Total Count 45", "ctl00_hldPage_txtTotalCount3", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Cargo_Description=driver.findElement(By.id("ctl00_hldPage_txtCargoDescription"));
		vd.WebEle_Cargo_Description.sendKeys(Cargo_Description);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Cargo Description", "ctl00_hldPage_txtCargoDescription", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Marks_And_No=driver.findElement(By.id("ctl00_hldPage_txtMarksNo"));
		vd.WebEle_Marks_And_No.sendKeys(Marks_And_No);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Marks And No", "ctl00_hldPage_txtMarksNo", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Container_No=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtContainerNO"));
		vd.WebEle_Container_No.sendKeys(Container_No);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Container No", "ctl00_hldPage_rptContDetails_ctl01_txtContainerNO", driver, ExcelSavePath, vd.StartTime);
		
		vd.WebEle_Container_Size=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_drpSize"));
		org.openqa.selenium.support.ui.Select 
		Cbo_Container_Size=new org.openqa.selenium.support.ui.Select(vd.WebEle_Container_Size);
		Cbo_Container_Size.selectByVisibleText(Container_Size);
		
//		vd.WebEle_Container_Type=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_drpType"));
//		org.openqa.selenium.support.ui.Select 
//		Cbo_Container_Type=new org.openqa.selenium.support.ui.Select(vd.WebEle_Container_Type);
//		Cbo_Container_Type.selectByVisibleText(Container_Type);
//		
//		vd.WebEle_ISO_Code=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtISOCode"));
//		vd.WebEle_ISO_Code.sendKeys(ISO_Code);
		
//		vd.WebEle_Weight=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtWeight"));
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtWeight")).sendKeys(Weight);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Weight", "ctl00_hldPage_rptContDetails_ctl01_txtWeight", driver, ExcelSavePath, vd.StartTime);
		
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_hldPage_rptContDetails_ctl01_txtWeight")));
		
		Thread.sleep(2000);
//		vd.WebEle_Weight.sendKeys(Weight);
//		Thread.sleep(1000);
		
		vd.WebEle_Seal_No=driver.findElement(By.id("ctl00_hldPage_rptContDetails_ctl01_txtSealNo"));
		vd.WebEle_Seal_No.sendKeys(Seal_No);
		ve.Data_TextBox(SC_ID, Description, vd.Srno, vd.r,"Seal No", "ctl00_hldPage_rptContDetails_ctl01_txtSealNo", driver, ExcelSavePath, vd.StartTime);
		
		driver.findElement(By.id("ctl00_hldPage_fu_BLManifest")).sendKeys(TEST_File_Upload);
		
		driver.findElement(By.id("ctl00_hldPage_fu_BOE")).sendKeys(TEST_File_Upload);
		
		driver.findElement(By.id("ctl00_hldPage_fu_CustomsDoc")).sendKeys(TEST_File_Upload);
		
		driver.findElement(By.id("ctl00_hldPage_fu_Others")).sendKeys(TEST_File_Upload);
		
		driver.findElement(By.id("ctl00_hldPage_OtherFileUpload")).sendKeys(TEST_File_Upload);

		driver.findElement(By.id("ctl00_hldPage_btnSubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_hldPage_btnSubmit")).click();
	
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(1);
		
	}
	
	public void Logout() throws Exception
	{
		Thread.sleep(1000);
		WebElement logout_mouseover=driver.findElement(By.id("ctl00_Label4"));
		Actions action=new Actions(driver);
		
		action.moveToElement(logout_mouseover).perform();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_lnkSignout")).click();
		Thread.sleep(1000);
	}
	
	
}
