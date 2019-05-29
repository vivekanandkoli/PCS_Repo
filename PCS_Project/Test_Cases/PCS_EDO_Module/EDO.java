   package PCS_EDO_Module;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.kale.pcs.TestDataReaders.ExcelFileReader;
import org.kale.pcs.TestDataReaders.PropertiesFileReader;
import org.kale.pcs.TestDataReaders.TestDataCollection;
import org.kale.pcs.TestDataReaders.TestDataReader;
import org.kale.pcs.TestDataReaders.TestDataReaderFactory;
import org.kale.pcs.pages.Create_EDO_Import_Page;
import org.kale.pcs.pages.LoginPage;
import org.kale.pcs.sdk.BaseClass;
import org.kale.pcs.sdk.Variables_Declaration;
import org.kale.pcs.utils.WriteExcel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EDO extends BaseClass
{
	Variables_Declaration vd=new Variables_Declaration();
	WriteExcel rw = new WriteExcel();
	LoginPage lp=new LoginPage(driver);
	
	@BeforeClass
	public void ReadData_UserDetails() throws Exception
	{
		TestDataReader tdr=TestDataReaderFactory.getInstance().open("test_data\\user-accounts.yml");
		TestDataCollection tdc=tdr.getCollection("login_FrieghtForwarder");		
		vd.drpEntity_FrieghtForwarder=tdc.getString("entity_FrieghtForwarder");
		vd.username_FrieghtForwarder=tdc.getString("username_FrieghtForwarder");
		vd.password_FrieghtForwarder=tdc.getString("password_FrieghtForwarder");
		
//		PropertiesFileReader pfr=new PropertiesFileReader();
//		pfr.loadPropertiesFile();
//		vd.s = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
//		vd.folderpath = pfr.getPropertyValue("Report_folder_path")+vd.s;
//      vd.ExcelSavePath = rw.foldercreate(vd.folderpath);        
	}	

	@BeforeMethod
	public void ReadData_LineNoDetails() throws Exception
	{
		PropertiesFileReader pfr=new PropertiesFileReader();
		pfr.loadPropertiesFile();
		String TestDataExcel=pfr.getPropertyValue("testdata_path");
		vd.Notice1_UploadFilePath=pfr.getPropertyValue("Notice1_UploadFilePath");
		ExcelFileReader efr=new ExcelFileReader(TestDataExcel);
		String SheetName="EDO";
		vd.i++;
		vd.Container_Line_Agent=efr.getCellData(SheetName, "Container_Line_Agent",vd.i);
		vd.Container_Line_Agent_Code=efr.getCellData(SheetName, "Container_Line_Agent_Code",vd.i);
		vd.Vessel_Line_Agent=efr.getCellData(SheetName, "Vessel_Line_Agent",vd.i);
		vd.Vessel_Line_Agent_Code=efr.getCellData(SheetName, "Vessel_Line_Agent_Code",vd.i);
		vd.Import_Manifest_No=efr.getCellData(SheetName, "Import_Manifest_No",vd.i);
		vd.Import_Manifest_Date=efr.getCellData(SheetName, "Import_Manifest_Date",vd.i);
		vd.Bill_of_Lading_No=efr.getCellData(SheetName, "Bill_of_Lading_No",vd.i);
		vd.Bill_of_Lading_Date=efr.getCellData(SheetName, "Bill_of_Lading_Date",vd.i);
		vd.Consignee=efr.getCellData(SheetName, "Consignee",vd.i);		
		vd.Consignee_Address=efr.getCellData(SheetName, "Consignee_Address",vd.i);
		vd.Total_No_of_BL_Pkgs=efr.getCellData(SheetName, "Total_No_of_BL_Pkgs",vd.i);
		vd.BL_Weight=efr.getCellData(SheetName, "BL_Weight",vd.i);
		vd.Volume=efr.getCellData(SheetName, "Volume",vd.i);
		vd.Vessel_Name=efr.getCellData(SheetName, "Vessel_Name",vd.i);
		vd.Voyage_No=efr.getCellData(SheetName, "Voyage_No",vd.i);		
		vd.Berth_Date=efr.getCellData(SheetName, "Berth_Date",vd.i);
		vd.Berth_hour=efr.getCellData(SheetName, "Berth_hour",vd.i);
		vd.Berth_Minutes=efr.getCellData(SheetName, "Berth_Minutes",vd.i);
		vd.Port_of_Loading=efr.getCellData(SheetName, "Port_of_Loading",vd.i);
		vd.Port_of_Discharge=efr.getCellData(SheetName, "Port_of_Discharge",vd.i);		
		vd.Final_Port_Delivery=efr.getCellData(SheetName, "Final_Port_Delivery",vd.i);
		vd.Delivery_Type=efr.getCellData(SheetName, "Delivery_Type",vd.i);
		vd.Shipment_Type=efr.getCellData(SheetName, "Shipment_Type",vd.i);
		vd.Cargo_Type=efr.getCellData(SheetName, "Cargo_Type",vd.i);
		vd.Total_Count_20=efr.getCellData(SheetName, "Total_Count_20",vd.i);
		vd.Total_Count_40=efr.getCellData(SheetName, "Total_Count_40",vd.i);
		vd.Total_Count_45=efr.getCellData(SheetName, "Total_Count_45",vd.i);
		vd.Cargo_Description=efr.getCellData(SheetName, "Cargo_Description",vd.i);
		vd.Marks_And_No=efr.getCellData(SheetName, "Marks_And_No",vd.i);
		vd.Container_No=efr.getCellData(SheetName, "Container_No",vd.i);
		vd.Container_Type=efr.getCellData(SheetName, "Container_Type",vd.i);
		vd.ISO_Code=efr.getCellData(SheetName, "ISO_Code",vd.i);
		vd.Weight=efr.getCellData(SheetName, "Weight",vd.i);
		vd.Seal_No=efr.getCellData(SheetName, "Seal_No",vd.i);		
	}

	@Test
	public void Login_FF() throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.login(vd.drpEntity_FrieghtForwarder,vd.username_FrieghtForwarder, vd.password_FrieghtForwarder);	
		
		Create_EDO_Import_Page Create_EDO=new Create_EDO_Import_Page(driver);
		Create_EDO.Create_EDO(vd.Container_Line_Agent, vd.Container_Line_Agent_Code, vd.Vessel_Line_Agent,vd.Vessel_Line_Agent_Code, vd.Import_Manifest_No,
				vd.Import_Manifest_Date, vd.Bill_of_Lading_No, vd.Bill_of_Lading_Date, vd.Consignee,vd.Consignee_Address,
				vd.Total_No_of_BL_Pkgs, vd.BL_Weight,vd.Volume, vd.Vessel_Name, vd.Voyage_No, vd.Berth_Date, vd.Berth_hour,
				vd.Berth_Minutes, vd.Port_of_Loading, vd.Port_of_Discharge, vd.Final_Port_Delivery, vd.Delivery_Type,
				vd.Shipment_Type, vd.Cargo_Type, vd.Total_Count_20,vd.Total_Count_40, vd.Total_Count_45, vd.Cargo_Description,
				vd.Marks_And_No, vd.Container_No,vd.Container_Size, vd.Container_Type, vd.ISO_Code, vd.Weight, vd.Seal_No);
		
		
	}
}

