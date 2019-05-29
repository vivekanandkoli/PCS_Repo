package org.kale.pcs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

public class WriteExcel 
{
	static String ExcelSavePath;
	static HSSFWorkbook hswb;
	
//	Mail m2 = new Mail();

		public String foldercreate(String folderpath) throws IOException {
		Boolean f = DirectoryStream.class.equals(folderpath);
		String foldercheck = folderpath;

		if (f != true) {
			System.out.println("Exists");
			File f2 = new File(folderpath);
			f2.mkdir();
		} else if (f == true) {
			System.out.println("NOT Exists");

		}
		String ExcelSavePath = autoexcel(foldercheck);
		File f1 = new File(foldercheck);
		f1.listFiles();
		return ExcelSavePath;

	}

	@SuppressWarnings("resource")
	public String autoexcel(String foldercheck) throws IOException {
		Path ExcelSavePath = null;
		int fCount = 0;

		File f2 = new File(foldercheck);
		fCount = f2.listFiles().length;
		if (fCount != 0) {

			ExcelSavePath = java.nio.file.Paths.get(foldercheck, "RUN_" + (fCount + 1) + ".xls");
			(ExcelSavePath).toString();

			
			HSSFWorkbook hswb;

			

			hswb = new HSSFWorkbook();
			

			ExcelSavePath = java.nio.file.Paths.get(foldercheck, "RUN_" + (fCount + 1) + ".xls");
			String b = (ExcelSavePath).toString();
			

			HSSFSheet sheet1 = hswb.createSheet("Run 1");

			// Main code //

			HSSFRow row1 = sheet1.createRow(0);

			// XSSFCell cell = row1.getCell(0);
			HSSFCell cell = row1.createCell(0);
			CellStyle style9 = hswb.createCellStyle();
			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(0);
			cell.setCellValue("SrNo");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(1);
			cell.setCellValue("Scenario");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(2);
			cell.setCellValue("Test Description");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(3);
			cell.setCellValue("Expected Result");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(4);
			cell.setCellValue("Actual Result");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(5);
			cell.setCellValue("Remark");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(6);
			cell.setCellValue("Status");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(7);
			cell.setCellValue("StartTime");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(8);
			cell.setCellValue("EndTime");
			cell.setCellStyle(style9);
			//
			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(9);
			cell.setCellValue("Duration");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(10);
			cell.setCellValue("Screenshots");
			cell.setCellStyle(style9);

			// sheet2.createRow(0).createCell(0).setCellValue("StartTime");
			// sheet2.getRow(0).createCell(1).setCellValue("Endtime");
			// sheet2.getRow(0).createCell(2).setCellValue("Duration");
			// sheet2.GetRow(0).CreateCell(3).SetCellValue("Total Scenario Executed");
			// sheet2.GetRow(0).CreateCell(4).SetCellValue("Passresult");
			// sheet2.GetRow(0).CreateCell(5).SetCellValue("Failresult");

			FileOutputStream fileOut14 = new FileOutputStream(b);
			hswb.write(fileOut14);
			fileOut14.close();

			// }
			// }
		} else {

			// XSSFWorkbook hswb;
			HSSFWorkbook hswb;

			// FileInputStream fileOut13 = new FileInputStream(Reportfilepath);
			// hswb = new HSSFWorkbook(fileOut13);
			// fileOut13.close();

			hswb = new HSSFWorkbook();

			ExcelSavePath = java.nio.file.Paths.get(foldercheck, "RUN_1" + ".xls");
			String a = (ExcelSavePath).toString();
			// hswb.setSheetName(0, "Run 1");
			HSSFSheet sheet1 = hswb.createSheet("Run 1");
			// HSSFSheet sheet1 = hswb.getSheetAt(0);

			// ExcelSavePath =java.nio.file.Paths.get(foldercheck, "RUN_1" + ".xls");

			// String a=ExcelSavePath.toString();
			// hswb.setSheetName(0, "Run 1");
			// HSSFSheet sheet1 = hswb.createSheet("Run 1");

			// XSSFSheet sheet1=hswb.getSheetAt(0);

			// XSSFRow row1 = sheet1.getRow(0);

			// XSSFCell cell = row1.getCell(0);
			// HSSFSheet sheet1 = hswb.getSheetAt(0);

			HSSFRow row1 = sheet1.createRow(0);

			HSSFCell cell = row1.createCell(0);
			CellStyle style9 = hswb.createCellStyle();
			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(0);
			cell.setCellValue("SrNo");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(1);
			cell.setCellValue("Scenario");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(2);
			cell.setCellValue("Test Description");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(3);
			cell.setCellValue("Expected Result");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(4);
			cell.setCellValue("Actual Result");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(5);
			cell.setCellValue("Remark");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(6);
			cell.setCellValue("Status");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(7);
			cell.setCellValue("StartTime");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(8);
			cell.setCellValue("EndTime");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(9);
			cell.setCellValue("Duration");
			cell.setCellStyle(style9);

			// style9.setBorderBottom(BorderStyle.THIN);
			// style9.setBorderLeft(BorderStyle.THIN);
			// style9.setBorderRight(BorderStyle.THIN);
			// style9.setBorderTop(BorderStyle.THIN);
			cell = row1.createCell(10);
			cell.setCellValue("Screenshots");
			cell.setCellStyle(style9);

			// HSSFCell cell3 = row1.createCell(1);
			//
			//
			// sheet2.createRow(0).createCell(0).setCellValue("StartTime");
			// sheet2.getRow(0).createCell(1).setCellValue("Endtime");
			// sheet2.getRow(0).createCell(2).setCellValue("Duration");

			FileOutputStream fileOut12 = new FileOutputStream(a);
			hswb.write(fileOut12);
			fileOut12.close();

		}
		String d = (ExcelSavePath).toString();
		return d;

	}

	
	public void WriteToExcel(String SC_ID, String Description, int Srno, String ExpectedResult,
			String Actualresult, String insertdata, String Status, String StartTime, String EndTime, String Duration,
			String ScreenShotPath, int r, String filename) throws FileNotFoundException, IOException {
		HSSFWorkbook hswb;
		int col = 0;

		FileInputStream fileOut13 = new FileInputStream(filename);
		hswb = new HSSFWorkbook(fileOut13);
		fileOut13.close();

		HSSFSheet sheet1 = hswb.getSheetAt(0);
		int lastno=sheet1.getLastRowNum();
		r=lastno+1;
		Srno=lastno+1;
		// HSSFSheet sheet2 = hswb.getSheetAt(1);
		HSSFRow row22 = sheet1.createRow(r);
		row22.createCell(col);
		HSSFCell cell1;

		CellStyle style3 = hswb.createCellStyle();

		HSSFFont font = hswb.createFont();
		((org.apache.poi.ss.usermodel.Font) font).setFontHeightInPoints((short) 9);
		((org.apache.poi.ss.usermodel.Font) font).setBold(true);
		// style3.setBorderBottom(BorderStyle.THIN);
		// style3.setBorderLeft(BorderStyle.THIN);
		// style3.setBorderRight(BorderStyle.THIN);
		// style3.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col);
		cell1.setCellValue(Srno);
		cell1.setCellStyle(style3);
		style3.setFont(font);

		cell1 = sheet1.getRow(r).createCell(col + 1);
		cell1.setCellValue(SC_ID);
		// cell1.setCellStyle(style5);

		// style5.setBorderBottom(BorderStyle.THIN);
		// style5.setBorderLeft(BorderStyle.THIN);
		// style5.setBorderRight(BorderStyle.THIN);
		// style5.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col + 2);
		cell1.setCellValue(Description);
		// cell1.setCellStyle(style5);

		// style5.setBorderBottom(BorderStyle.THIN);
		// style5.setBorderLeft(BorderStyle.THIN);
		// style5.setBorderRight(BorderStyle.THIN);
		// style5.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col + 3);
		cell1.setCellValue(ExpectedResult);
		// cell1.setCellStyle(style5);

		// style5.setBorderBottom(BorderStyle.THIN);
		// style5.setBorderLeft(BorderStyle.THIN);
		// style5.setBorderRight(BorderStyle.THIN);
		// style5.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col + 4);
		cell1.setCellValue(Actualresult);
		// cell1.setCellStyle(style5);

		// style5.setBorderBottom(BorderStyle.THIN);
		// style5.setBorderLeft(BorderStyle.THIN);
		// style5.setBorderRight(BorderStyle.THIN);
		// style5.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col + 5);
		cell1.setCellValue(insertdata);
		// cell1.setCellStyle(style5);

		Cell c;
		CellStyle style2 = hswb.createCellStyle();
		HSSFFont font1 = hswb.createFont();
		if (Status.equals("Pass")) 
		{

			// style2.setBorderBottom(BorderStyle.THIN);
			// style2.setBorderLeft(BorderStyle.THIN);
			// style2.setBorderRight(BorderStyle.THIN);
			// style2.setBorderTop(BorderStyle.THIN);
			style2.setFillForegroundColor(IndexedColors.LIME.index);
			style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			c = sheet1.getRow(r).createCell(col + 6);
			c.setCellValue(Status);
			c.setCellStyle(style2);
			font1.setFontName(HSSFFont.FONT_ARIAL);
			font1.setFontHeightInPoints((short) 10);
			font1.setColor(IndexedColors.BLACK.getIndex());
			style2.setFont(font1);

		} 
		else

		{
			// style2.setBorderBottom(BorderStyle.THIN);
			// style2.setBorderLeft(BorderStyle.THIN);
			// style2.setBorderRight(BorderStyle.THIN);
			// style2.setBorderTop(BorderStyle.THIN);
			style2.setFillForegroundColor(IndexedColors.RED.index);
			style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			c = sheet1.getRow(r).createCell(col + 6);
			c.setCellValue(Status);
			c.setCellStyle(style2);
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setFontHeightInPoints((short) 10);
			font.setColor(IndexedColors.BLACK.getIndex());
			style2.setFont(font);
		}

		// style5.setBorderBottom(BorderStyle.THIN);
		// style5.setBorderLeft(BorderStyle.THIN);
		// style5.setBorderRight(BorderStyle.THIN);
		// style5.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col + 7);
		cell1.setCellValue(StartTime);
		// cell1.setCellStyle(style5);

		// style5.setBorderBottom(BorderStyle.THIN);
		// style5.setBorderLeft(BorderStyle.THIN);
		// style5.setBorderRight(BorderStyle.THIN);
		// style5.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col + 8);
		cell1.setCellValue(EndTime);
		// cell1.setCellStyle(style5);

		// style5.setBorderBottom(BorderStyle.THIN);
		// style5.setBorderLeft(BorderStyle.THIN);
		// style5.setBorderRight(BorderStyle.THIN);
		// style5.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col + 9);
		cell1.setCellValue(Duration);
		// cell1.setCellStyle(style5);
		//

		// Cell c6;
		// CellStyle style16 = hswb.createCellStyle();

		// HSSFHyperlink link=new HSSFHyperlink(HSSFHyperlink);
		// CellStyle hlink_style = hswb.createCellStyle();
		// HSSFFont hlink_font = hswb.createFont();
		// hlink_font.setUnderline(HSSFFont.U_SINGLE);
		//// hlink_font.setColor(HSSFFont.COLOR_RED);
		//// hlink_style.setFont(hlink_font);
		//// link = new HSSFHyperlink(HyperlinkType.);
		//// Cell cell;
		// // org.apache.poi.ss.usermodel.Hyperlink link ;
		// style5.setBorderBottom(BorderStyle.THIN);
		// style5.setBorderLeft(BorderStyle.THIN);
		// style5.setBorderRight(BorderStyle.THIN);
		// style5.setBorderTop(BorderStyle.THIN);
		cell1 = sheet1.getRow(r).createCell(col + 10);
		cell1.setCellValue(ScreenShotPath);
		// cell1.setCellStyle(style5);
		// link.setAddress(ScreenShotPath);

		// c6.CellStyle = style16;
		// cell.setHyperlink(link);
		// cell.setCellStyle(hlink_style);
		//

		FileOutputStream fileOut12 = new FileOutputStream(filename);
		hswb.write(fileOut12);
		fileOut12.close();

		// report(StartTime, EndTime,filename,row);

	}



}
