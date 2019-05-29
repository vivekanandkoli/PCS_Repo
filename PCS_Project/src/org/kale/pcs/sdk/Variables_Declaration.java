package org.kale.pcs.sdk;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Variables_Declaration 
{
	 public int i=0;
	
	 public String folderpath,s,ExcelSavePath;
	 public long second = 1000l;
	 public long minute = 60l * second;
	 public long hour = 60l * minute;
	 public long diff;
	 public SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	 public  String currentdate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	 public Boolean result;
	 /**
	  * @category Variables of Validate_Elements Class
	  */
	 
	public String StartTime, EndTime, ScreenShotName, ScreenShotPath, ExptResult, ActResult_FALSE, ChkType, Element, ActResult_TRUE,
	Status, ActResult, Duration, Statement_end_word, ActualResult, SC_ID,Description,Id, ExpectedResult, ActualResultTrue,
	ActualResultFalse, filename;
	public int Srno=1,r=1;
	
	/**
	 * @category   Variables of  Login Page
	 */
	
	public String 
	drpEntity_FrieghtForwarder,username_FrieghtForwarder,password_FrieghtForwarder;
	
	/**
	 * @category   Variables of Create EDO Page
	 */
	
	public String 
	Container_Line_Agent, 
	Container_Line_Agent_Code,
	Vessel_Line_Agent,
	Vessel_Line_Agent_Code,
	Import_Manifest_No,
	Import_Manifest_Date,
	Bill_of_Lading_No,
	Bill_of_Lading_Date,
	Consignee,
	Consignee_Address,
	Total_No_of_BL_Pkgs,
	BL_Weight,
	Volume,
	Vessel_Name,
	Voyage_No,
	Berth_Date,
	Berth_hour,
	Berth_Minutes,
	Port_of_Loading,
	Port_of_Discharge,
	Final_Port_Delivery,
	Delivery_Type,
	Shipment_Type,
	Cargo_Type,
	Total_Count_20,
	Total_Count_40,
	Total_Count_45,
	Cargo_Description,
	Marks_And_No,
	Container_No,
	Container_Size,
	Container_Type,
	ISO_Code,
	Weight,
	Seal_No;

	public boolean Enable_ContainerNo,Detain,QuickSearch;
	
	/**
	 * @category   WebElements of Create EDO Page
	 */
	
	public WebElement
	WebEle_Container_Line_Agent, 
	WebEle_Container_Line_Agent_Code,
	WebEle_Vessel_Line_Agent,
	WebEle_Vessel_Line_Agent_Code,
	WebEle_Import_Manifest_No,
	WebEle_Import_Manifest_Date,
	WebEle_Bill_of_Lading_No,
	WebEle_Bill_of_Lading_Date,
	WebEle_Consignee,
	WebEle_Consignee_Address,
	WebEle_Total_No_of_BL_Pkgs,
	WebEle_BL_Weight,
	WebEle_Volume,
	WebEle_Vessel_Name,
	WebEle_Voyage_No,
	WebEle_Berth_Date,
	WebEle_Berth_hour,
	WebEle_Berth_Minutes,
	WebEle_Port_of_Loading,
	WebEle_Port_of_Discharge,
	WebEle_Final_Port_Delivery,
	WebEle_Delivery_Type,
	WebEle_Shipment_Type,
	WebEle_Cargo_Type,
	WebEle_Total_Count_20,
	WebEle_Total_Count_40,
	WebEle_Total_Count_45,
	WebEle_Cargo_Description,
	WebEle_Marks_And_No,
	WebEle_Container_No,
	WebEle_Container_Size,
	WebEle_Container_Type,
	WebEle_ISO_Code,
	WebEle_Weight,
	WebEle_Seal_No;
	
	
	
	/**
	 * @category Variables for Custom Login
	 */	
	public boolean Detain_dropdown,IGM_NO_TextBox;
	
	/**
	 * @category Variables for Group Login
	 */
	public String username_group,password_group;
	
	/**
	 * @category Variables for CFS Login & NOC1 page
	 */
	public WebElement Choose_file,WESent_Date,WEFile_Name,WERemarks,WEImporter_Reply_Date,WEImporter_remark;
	public String Notice1_UploadFilePath,Sent_Date,File_Name,Remarks,Importer_Reply_Date,Importer_remark,trial_Sent_Date,NOC1_Alert_Message;
	public boolean FileName;
	
	/**
	 * @category Variables for CFS Login & NOC2 page
	 */
	public WebElement N2_Choose_file,N2_WESent_Date,N2_WEFile_Name,N2_WERemarks,N2_WEImporter_Reply_Date,N2_WEImporter_remark;
	public String N2_UploadFilePath,N2_Sent_Date,N2_File_Name,N2_Remarks,N2_Importer_Reply_Date,N2_Importer_remark,N2_trial_Sent_Date;
	public boolean N2_FileName;
	
	/**
	 * @category Variables for NOC page
	 */
	public boolean WebElement_PreAbs;
	
	/**
	 * @category Variables for Final Notice page
	 */
	public WebElement FN_Choose_file,FN_WESent_Date,FN_WEFile_Name,FN_WERemarks,FN_WEImporter_Reply_Date,FN_WEImporter_remark;
	public String FN_UploadFilePath,FN_Sent_Date,FN_File_Name,FN_Remarks,FN_Importer_Reply_Date,FN_Importer_remark,FN_trial_Sent_Date;
	public boolean FN_FileName;
	
	
	
	
	
	
	
	
	
	
	
	
}
