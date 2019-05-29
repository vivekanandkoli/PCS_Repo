package org.kale.pcs.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.kale.pcs.TestDataReaders.ExcelFileReader;
import org.kale.pcs.sdk.Variables_Declaration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Validate_Elements 
{
	long second = 1000l;
	long minute = 60l * second;
	long hour = 60l * minute;
	long diff;
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	General_Methods gm = new General_Methods();
	WriteExcel rw = new WriteExcel();
	Verify_Conditions veri=new Verify_Conditions();
	
	Variables_Declaration vd=new Variables_Declaration();
	
	public void ElementCheck(String SC_ID, String Description, int Srno, String Element, String Id,
			String ExpectedResult, String ActualResultTrue, String ActualResultFalse, int r, String filename,
			WebDriver driver,String StartTime) throws Exception 
	{

   	   	int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(filename);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		
		
		ExcelFileReader efr=new ExcelFileReader(filename);
		String EndTime,Duration,Status,ScreenShotPath;
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		if (Element == "Textbox")
		{
			String StartTime_fromExcel=efr.getCellData("Run 1", "EndTime",Lastrono);
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			 
			WebElement webElement = driver.findElement(By.xpath(".//*[@id='" + Id + "']"));
			String insertdata = webElement.getAttribute("value");
			String exp_res = ExpectedResult;
			if (insertdata != null) 
			{
				vd.ActualResult = ActualResultTrue;
				Status = "Pass";      vd.result=true; 
				vd.result=true;
				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
               
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);

				vd.ScreenShotPath = gm.screenShot(driver);
			} else 
			{
				String ActualResult = ActualResultFalse;
				Status = "Fail";       vd.result=false;
				vd.result=false;
				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);
			}
			veri.checkPoint(vd.result, ExpectedResult);
			rw.WriteToExcel(SC_ID, Description, Srno, ExpectedResult, vd.ActualResult, insertdata, Status, StartTime,
					EndTime, Duration, vd.ScreenShotPath, r++, filename);

		}

		if (Element == "Dropdown") 
		{
			Thread.sleep(300);

			Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='" + Id + "']")));

			String insertdata = new Select(driver.findElement(By.xpath(".//*[@id='" + Id + "']")))
					.getFirstSelectedOption().getText();
			if (insertdata != "Select" || insertdata != "No Record") {
				vd.ActualResult = ActualResultTrue;
				Status = "Pass";      vd.result=true; 

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);

			} else {
				vd.ActualResult = ActualResultFalse;
				Status = "Fail";       vd.result=false;
				
				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);
			}
			veri.checkPoint(vd.result, ExpectedResult);
			rw.WriteToExcel(SC_ID, Description, Srno, ExpectedResult, vd.ActualResult, insertdata, Status, StartTime,
					EndTime, Duration, ScreenShotPath, r++, filename);
		}
		
		
			if (Element == "Checkbox") 
			{
			boolean Selecteddata = driver.findElement(By.xpath(".//*[@id='" + Id + "']")).isSelected();
			String exp_res = ExpectedResult;
			String insertdata = "";
			if (Selecteddata == true) 
			{
				insertdata = "checked";
				vd.ActualResult = ActualResultTrue;
				Status = "Pass";      vd.result=true; 

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
               
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);

				ScreenShotPath = gm.screenShot(driver);
			} 
			else 
			{
				insertdata = "unchecked";
				vd.ActualResult = ActualResultFalse;
				Status = "Fail";       vd.result=false;

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);
			}
			veri.checkPoint(vd.result, ExpectedResult);
			rw.WriteToExcel(SC_ID, Description, Srno, ExpectedResult, vd.ActualResult, insertdata, Status, StartTime,
					EndTime, Duration, ScreenShotPath, r++, filename);

		}
	}

	public void Numeric(String SC_ID, String Description, int Srno, String Element, String Id, int length,
			String ExpectedResult, String ActualResultTrue, String ActualResultFalse, int r, String ExcelSavePath,
			WebDriver driver,String StartTime)
			throws Exception {
		
		String EndTime;
		String Duration;
		String Status;
		String ActualResult;
		String insertdata;
		String ScreenShotPath;
		if (driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value") == String.valueOf(0))
		{
			ElementCheck(SC_ID, Description, Srno++, Element, Id, ExpectedResult, ActualResultTrue,
					ActualResultFalse, r++, ExcelSavePath, driver,StartTime);
		}
		else
		{

			

			boolean Numeric = true;
			String exp_res = ExpectedResult;
			String regex = "[0-9]+";
			Numeric = regex.matches(driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value"));
			String input = driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value");
			
			
			if (input.length() <= length && Numeric == false)
			{
				ActualResult = ActualResultTrue;
				Status = "Pass";      vd.result=true; 
				insertdata = input;

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
				Date date2 = format.parse(EndTime);
				diff = date2.getTime() - date1.getTime();
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);
			} 
			else 
			{
				ActualResult = "Invalid Data Entered!!!";
				Status = "Fail";       vd.result=false;
				insertdata = input;

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);
			}
			veri.checkPoint(vd.result, ExpectedResult);
			rw.WriteToExcel(SC_ID, Description, Srno, ExpectedResult, ActualResult, insertdata, Status, StartTime,
					EndTime, Duration, ScreenShotPath, r++, ExcelSavePath);
		}
	}

	public void Alphanumeric(String SC_ID, String Description, int Srno, String Element, String Id, int length,
			String ExpectedResult, String ActualResultTrue, String ActualResultFalse, int r, String ExcelSavePath,
			WebDriver driver,String StartTime) throws Exception {
		
		String EndTime;
		String Duration;
		String Status;
		String ActualResult;
		String insertdata;
		String ScreenShotPath;

		if (driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value") == String.valueOf(0)) {
			ElementCheck(SC_ID, Description, Srno++, Element, Id, ExpectedResult, ActualResultTrue,
					ActualResultFalse, r++, ExcelSavePath, driver,StartTime);
		} 
		else 
		{

			

			boolean Aplhanumeric = true;
			String exp_res = ExpectedResult;

			String Rgx = "[a-zA-Z0-9]*";
			Aplhanumeric = Rgx.matches(driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value"));
			String input = driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value");
			
			
			if (input.length() <= length && Aplhanumeric == false) 
			{
				ActualResult = ActualResultTrue;
				Status = "Pass";      vd.result=true; 
				insertdata = input;

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);
			} 
			else 
			{
				ActualResult = "Invalid Data Entered!!!";
				Status = "Fail";       vd.result=false;
				insertdata = input;

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);
			}
			veri.checkPoint(vd.result, ExpectedResult);
			rw.WriteToExcel(SC_ID, Description, Srno, ExpectedResult, ActualResult, insertdata, Status, StartTime,
					EndTime, Duration, ScreenShotPath, r++, ExcelSavePath);
		}

	}

	public void IsAlphabets(String SC_ID, String Description, int Srno, String Element, String Id, int length,
			String ExpectedResult, String ActualResultTrue, String ActualResultFalse, int r, String ExcelSavePath,
			WebDriver driver,String StartTime) throws Exception
        {
		if (driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value") == String.valueOf(0)) {
			ElementCheck(SC_ID, Description, Srno++, Element, Id, ExpectedResult, ActualResultTrue,
					ActualResultFalse, r++, ExcelSavePath, driver,StartTime);
		} 

            else
            {
            	String EndTime;
        		String Duration;
        		String Status;
        		String ActualResult;
        		String insertdata;
        		String ScreenShotPath;
                
                ScreenShotPath = gm.screenShot(driver); 

                
                //bool isalpha = false;

                boolean isAlpha = false;
                String Rgx = "[0-9~!@#$%^&*=|_]";
                isAlpha = Rgx.matches(driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value"));
                String input = driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value");

                if (input.length() <= length && isAlpha == false)
                {
                	ActualResult = ActualResultTrue;
    				Status = "Pass";      vd.result=true;    
    				insertdata = input;

    				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    				Date date1 = format.parse(StartTime);
                    Date date2 = format.parse(EndTime);
                    diff = date2.getTime() - date1.getTime();
                    
    				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
    						+ ":" + String.format("%02d", (diff % minute) / second);
    				
                }

                else
                {
                	ActualResult = "Invalid Data Entered!!!";
    				Status = "Fail";       vd.result=false;
    				insertdata = input;

    				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    				Date date1 = format.parse(StartTime);
                    Date date2 = format.parse(EndTime);
                    diff = date2.getTime() - date1.getTime();
                    
    				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
    						+ ":" + String.format("%02d", (diff % minute) / second);
    				
                   
                }
                veri.checkPoint(vd.result, ExpectedResult);
                rw.WriteToExcel(SC_ID, Description, Srno, ExpectedResult, ActualResult, insertdata, vd.Status, StartTime,
    					EndTime, Duration, ScreenShotPath, r++, ExcelSavePath);
            }
        }

	public void validateEmail(String SC_ID, String Description, int Srno, String Element, String Id,
			int length, String ExpectedResult, String ActualResultTrue, String ActualResultFalse, int r,
			String ExcelSavePath, WebDriver driver,String StartTime)
			throws Exception {
		
		String EndTime;
		String Duration;
		String Status;
		String ActualResult;
		String insertdata;
		String ScreenShotPath;

		if (driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value") == String.valueOf(0))
		{

			ElementCheck(SC_ID, Description, Srno++, Element, Id, ExpectedResult, ActualResultTrue,
					ActualResultFalse, r++, ExcelSavePath, driver,StartTime);
		} 
		else 
		{

			
			boolean validateEmail = true;
			String exp_res = ExpectedResult;
			String Rgx = ("^[A-Za-z0-9#$%^&*_-]{1,40}@[A-Za-z0-9]{1,40}.[A-Za-z0-9]{1,10}$");
			validateEmail = Rgx
					.matches(driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value"));
			String input = driver.findElement(By.xpath(".//*[@id='" + Id + "']")).getAttribute("value");
			if (input.length() <= length && validateEmail == false)
			{
				ActualResult = ActualResultTrue;
				Status = "Pass";      vd.result=true;   
				insertdata = input;

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);
				ScreenShotPath = gm.screenShot(driver);
			} 
			else 
			{
				ActualResult = "Invalid Data Entered!!!";
				Status = "Fail";       vd.result=false;
				insertdata = input;

				EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
				Date date1 = format.parse(StartTime);
                Date date2 = format.parse(EndTime);
                diff = date2.getTime() - date1.getTime();
                
				Duration = String.format("%02d", diff / hour) + ":" + String.format("%02d", (diff % hour) / minute)
						+ ":" + String.format("%02d", (diff % minute) / second);

				ScreenShotPath = gm.screenShot(driver);
			}
			veri.checkPoint(vd.result, ExpectedResult);
			rw.WriteToExcel(SC_ID, Description, Srno, ExpectedResult, ActualResult, insertdata, vd.Status, StartTime,
					EndTime, Duration, ScreenShotPath, r++, ExcelSavePath);
		}
	}

	public void Data_TextBox(String SC_ID, String Description,int Srno,int r, String Statement_complete,String Element_Name,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		
		vd.ExptResult = "User should be able to view the entered "+Statement_complete;
		vd.ActResult_TRUE = "User successfully viewed the entered "+Statement_complete;
		vd.ActResult_FALSE = "User failed to view the entered "+Statement_complete;
		vd.ChkType = "Textbox";
		
		ElementCheck(SC_ID, Description, Srno++, vd.ChkType,Element_Name, vd.ExptResult, vd.ActResult_TRUE,
				vd.ActResult_FALSE,r++, ExcelSavePath, driver, StartTime);
	}
	
	public void Data_Dropdown(String SC_ID, String Description,int Srno,int r, String Statement_complete,String Element_Name,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		vd.ExptResult = "User should be able to view the select "+Statement_complete;
		vd.ActResult_TRUE = "User successfully viewed the selected "+Statement_complete;
		vd.ActResult_FALSE = "User failed to view the selected "+Statement_complete;
		vd.ChkType = "Textbox";
		
		ElementCheck(SC_ID, Description, Srno++, vd.ChkType,Element_Name, vd.ExptResult, vd.ActResult_TRUE,
				vd.ActResult_FALSE,r++, ExcelSavePath, driver, StartTime);
	}
	
	public void Text_equality_verification(String SC_ID, String Description,int Srno,int r,String FirstText,String SecondText,String Statement_complete,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		
		int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(ExcelSavePath);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		ExcelFileReader eat3=new ExcelFileReader(ExcelSavePath);
		
		vd.ExptResult = Statement_complete+" should be equal as previous entered";
		vd.ActResult_TRUE = Statement_complete+" is equal as previous entered";
		vd.ActResult_FALSE = Statement_complete+" is not equal as previous entered";
		if(FirstText.equals(SecondText))
		{
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.Status = "Pass";      vd.result=true; 
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);
		vd.ExpectedResult=vd.ExptResult;
		vd.ActualResult=vd.ActResult_TRUE;
		}
		else
		{
			vd.Status = "Fail";       vd.result=false;
			vd.ActResult=vd.ActResult_FALSE;
			
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
			vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);

			vd.ScreenShotPath = gm.screenShot(driver);
			vd.ExpectedResult=vd.ExptResult;
			vd.ActualResult=vd.ActResult_FALSE;
		}
		veri.checkPoint(vd.result, vd.ExptResult);
		rw.WriteToExcel(SC_ID, Description, Srno, vd.ExpectedResult, vd.ActualResult,FirstText, vd.Status, StartTime,
				vd.EndTime, vd.Duration, vd.ScreenShotPath, r++, ExcelSavePath);
	}

	public void Alert_handling(String SC_ID, String Description,int Srno,int r,String Alert_Status,String Statement_complete,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(ExcelSavePath);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		ExcelFileReader eat3=new ExcelFileReader(ExcelSavePath);
		//System.out.println(" "+"welcome"+" ");
		
		vd.ExptResult = "\""+Statement_complete+"\",Alert message should be dislay ";
		vd.ActResult_TRUE = "\""+Statement_complete+"\" ,Alert message is dislay";
		vd.ActResult_FALSE ="\""+Statement_complete+"\" ,Alert message is not dislay";
		if(Alert_Status.equals("PASS"))
		{
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.Status = "Pass";      vd.result=true; 
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);
		vd.ExpectedResult=vd.ExptResult;
		vd.ActualResult=vd.ActResult_TRUE;
		}
		else
		{
			vd.Status = "Fail";       vd.result=false;
			vd.ActResult=vd.ActResult_FALSE;
			
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
			vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);

			vd.ScreenShotPath = gm.screenShot(driver);
			vd.ExpectedResult=vd.ExptResult;
			vd.ActualResult=vd.ActResult_FALSE;
		}
		veri.checkPoint(vd.result, vd.ExptResult);
		rw.WriteToExcel(SC_ID, Description, Srno, vd.ExpectedResult, vd.ActualResult,Statement_complete, vd.Status, StartTime,
				vd.EndTime, vd.Duration, vd.ScreenShotPath, r++, ExcelSavePath);
	}

	public void Message(String SC_ID, String Description,int Srno,int r,String Alert_Status,String Statement_complete,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(ExcelSavePath);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		ExcelFileReader eat3=new ExcelFileReader(ExcelSavePath);
		
		vd.ExptResult = "\""+Statement_complete+"\", message should be dislay ";
		vd.ActResult_TRUE = "\""+Statement_complete+"\" , message is dislay";
		vd.ActResult_FALSE ="\""+Statement_complete+"\" , message is not dislay";
		if(Alert_Status.equals("PASS"))
		{
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.Status = "Pass";      vd.result=true; 
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);
		vd.ExpectedResult=vd.ExptResult;
		vd.ActualResult=vd.ActResult_TRUE;
		}
		else
		{
			vd.Status = "Fail";       vd.result=false;
			vd.ActResult=vd.ActResult_FALSE;
			
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
			vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);

			vd.ScreenShotPath = gm.screenShot(driver);
			vd.ExpectedResult=vd.ExptResult;
			vd.ActualResult=vd.ActResult_FALSE;
		}
		veri.checkPoint(vd.result, vd.ExptResult);
		rw.WriteToExcel(SC_ID, Description, Srno, vd.ExpectedResult, vd.ActualResult,Statement_complete, vd.Status, StartTime,
				vd.EndTime, vd.Duration, vd.ScreenShotPath, r++, ExcelSavePath);
	}

	public void TextBoxEnable(String SC_ID, String Description,int Srno,int r,String Status,String Statement_complete,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(ExcelSavePath);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		ExcelFileReader eat3=new ExcelFileReader(ExcelSavePath);
		
		vd.ExptResult = Statement_complete+" Textbox should be enable ";
		vd.ActResult_TRUE = Statement_complete+" Textbox is enable";
		vd.ActResult_FALSE =Statement_complete+"Textbox is disable";
		if(Status.equals("PASS"))
		{
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.Status = "Pass";      vd.result=true; 
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);
		vd.ExpectedResult=vd.ExptResult;
		vd.ActualResult=vd.ActResult_TRUE;
		}
		else
		{
			vd.Status = "Fail";       vd.result=false;
			vd.ActResult=vd.ActResult_FALSE;
			
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
			vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);

			vd.ScreenShotPath = gm.screenShot(driver);
			vd.ExpectedResult=vd.ExptResult;
			vd.ActualResult=vd.ActResult_FALSE;
		}
		veri.checkPoint(vd.result, vd.ExptResult);
		rw.WriteToExcel(SC_ID, Description, Srno, vd.ExpectedResult, vd.ActualResult,Statement_complete, vd.Status, StartTime,
				vd.EndTime, vd.Duration, vd.ScreenShotPath, r++, ExcelSavePath);
	}
	
	public void TextBoxExpectedText(String SC_ID, String Description,int Srno,int r,String Status,String TextBoxname,String Statement_complete,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(ExcelSavePath);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		ExcelFileReader eat3=new ExcelFileReader(ExcelSavePath);
		
		vd.ExptResult = TextBoxname+" should be "+Statement_complete;
		vd.ActResult_TRUE =TextBoxname+" is equal to "+Statement_complete;
		vd.ActResult_FALSE =TextBoxname+" is not equal to "+Statement_complete;
		if(Status.equals("PASS"))
		{
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.Status = "Pass";      vd.result=true; 
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);
		vd.ExpectedResult=vd.ExptResult;
		vd.ActualResult=vd.ActResult_TRUE;
		}
		else
		{
			vd.Status = "Fail";       vd.result=false;
			vd.ActResult=vd.ActResult_FALSE;
			
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
			vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);

			vd.ScreenShotPath = gm.screenShot(driver);
			vd.ExpectedResult=vd.ExptResult;
			vd.ActualResult=vd.ActResult_FALSE;
		}
		veri.checkPoint(vd.result, vd.ExptResult);
		rw.WriteToExcel(SC_ID, Description, Srno, vd.ExpectedResult, vd.ActualResult,Statement_complete, vd.Status, StartTime,
				vd.EndTime, vd.Duration, vd.ScreenShotPath, r++, ExcelSavePath);
	}

	public void webElement_absent(String SC_ID, String Description,int Srno,int r,String Status,String Statement_complete,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(ExcelSavePath);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		ExcelFileReader eat3=new ExcelFileReader(ExcelSavePath);
		
		vd.ExptResult = Statement_complete+" Textbox should be absent ";
		vd.ActResult_TRUE = Statement_complete+" Textbox is absent";
		vd.ActResult_FALSE =Statement_complete+"Textbox is present";
		if(Status.equals("PASS"))
		{
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.Status = "Pass";      vd.result=true; 
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);
		vd.ExpectedResult=vd.ExptResult;
		vd.ActualResult=vd.ActResult_TRUE;
		}
		else
		{
			vd.Status = "Fail";       vd.result=false;
			vd.ActResult=vd.ActResult_FALSE;
			
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
            vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
            		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
			vd.ScreenShotPath = gm.screenShot(driver);
			vd.ExpectedResult=vd.ExptResult;
			vd.ActualResult=vd.ActResult_FALSE;
		}
		veri.checkPoint(vd.result, vd.ExptResult);
		rw.WriteToExcel(SC_ID, Description, Srno, vd.ExpectedResult, vd.ActualResult,Statement_complete, vd.Status, StartTime,
				vd.EndTime, vd.Duration, vd.ScreenShotPath, r++, ExcelSavePath);
	}

	public void webElement_Present(String SC_ID, String Description,int Srno,int r,String Status,String Statement_complete,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(ExcelSavePath);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		ExcelFileReader eat3=new ExcelFileReader(ExcelSavePath);
		
		vd.ExptResult = Statement_complete+" Textbox should be present ";
		vd.ActResult_TRUE = Statement_complete+" Textbox is present";
		vd.ActResult_FALSE =Statement_complete+"Textbox is present";
		if(Status.equals("PASS"))
		{
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.Status = "Pass";      vd.result=true; 
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);
		vd.ExpectedResult=vd.ExptResult;
		vd.ActualResult=vd.ActResult_TRUE;
		}
		else
		{
			vd.Status = "Fail";       vd.result=false;
			vd.ActResult=vd.ActResult_FALSE;
			
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);			vd.ExpectedResult=vd.ExptResult;
		
		}
		veri.checkPoint(vd.result, vd.ExptResult);
		rw.WriteToExcel(SC_ID, Description, Srno, vd.ExpectedResult, vd.ActualResult,Statement_complete, vd.Status, StartTime,
				vd.EndTime, vd.Duration, vd.ScreenShotPath, r++, ExcelSavePath);
	}
	
	public void TextBoxDisable(String SC_ID, String Description,int Srno,int r,String Status,String Statement_complete,WebDriver driver,String ExcelSavePath,String StartTime) throws Exception
	{
		int Lastrono;			HSSFWorkbook hswb;
   	   	HSSFCell cell1;   	   	HSSFWorkbook workbook=null;
   	   	HSSFSheet sheet=null;	HSSFRow row=null;
   	   	HSSFCell cell=null;		FileInputStream fis=null;
   	   	  	     	 
        fis=new FileInputStream(ExcelSavePath);
		workbook=new HSSFWorkbook(fis);
		sheet=workbook.getSheet("Run 1");
		Lastrono=sheet.getLastRowNum();
		ExcelFileReader eat3=new ExcelFileReader(ExcelSavePath);
		
		vd.ExptResult = Statement_complete+" Textbox should be Disable ";
		vd.ActResult_TRUE = Statement_complete+" Textbox is Disable";
		vd.ActResult_FALSE =Statement_complete+"Textbox is Enable";
		if(Status.equals("PASS"))
		{
			String StartTime_fromExcel=eat3.getCellData("Run 1", "EndTime",Lastrono);
			
			if(StartTime_fromExcel.equals("EndTime"))
			{
				StartTime=StartTime;
			}
			else
			{
				StartTime=StartTime_fromExcel;
			}
			vd.Status = "Pass";      vd.result=true; 
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
		vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + 
		String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);
		vd.ScreenShotPath = gm.screenShot(driver);
		vd.ExpectedResult=vd.ExptResult;
		vd.ActualResult=vd.ActResult_TRUE;
		}
		else
		{
			vd.Status = "Fail";       vd.result=false;
			vd.ActResult=vd.ActResult_FALSE;
			
			vd.EndTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			Date date1 = vd.format.parse(StartTime);
            Date date2 = vd.format.parse(vd.EndTime);
            vd.diff = date2.getTime() - date1.getTime();
           
			vd.Duration = String.format("%02d", vd.diff / vd.hour) + ":" + String.format("%02d", (vd.diff % vd.hour) / vd.minute)
					+ ":" + String.format("%02d", (vd.diff % vd.minute) / vd.second);

			vd.ScreenShotPath = gm.screenShot(driver);
			vd.ExpectedResult=vd.ExptResult;
			vd.ActualResult=vd.ActResult_FALSE;
		}
		veri.checkPoint(vd.result, vd.ExptResult);
		rw.WriteToExcel(SC_ID, Description, Srno, vd.ExpectedResult, vd.ActualResult,Statement_complete, vd.Status, StartTime,
				vd.EndTime, vd.Duration, vd.ScreenShotPath, r++, ExcelSavePath);
	}


}
