package com.qa.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelOperation {
	static HSSFSheet sheet;
	static HSSFRow row;
	static HSSFWorkbook workbook;
	static HSSFCell cell;
	static OutputStream file;
	static String excelFilePath = "C:\\Users\\Mamta\\eclipse-workspace\\JalaAcademyAssignment\\EmployeeInfo.xls";
	static int j = 0;
	static int i = 0;

	public static void main(String[] args) throws IOException {
		ExcelOperation.setTableField("First Name", "Last Name", "Mobile No.", "Email Id", "Gender", "Date Of Birth",
				"Country", "City", "Skill");
		ExcelOperation.writeDataIntoExcel("Sham", "Nanavare", "8902343242", "sham@gmail.com", "Female", "23/08/1993","India","Pune","QA-Automation");
}

	public static void createWorkBook() throws FileNotFoundException {

		workbook = new HSSFWorkbook();

	}

	public static void createSheet() throws FileNotFoundException {

		sheet = workbook.createSheet("EmployeeRecords");

	}

	public static void createRow() {
		row = sheet.createRow(i++);
	}

	public static void createCell() {

		cell = row.createCell(j++);
	}

	static public void setTableField(String fName, String lName, String mobileNo, String emailId, String gender,
			String DOB, String country, String city, String skill) throws IOException {
		createWorkBook();
		createSheet();
		createRow();
		createCell();
		cell.setCellValue(fName);
		createCell();
		cell.setCellValue(lName);
		createCell();
		cell.setCellValue(mobileNo);
		createCell();
		cell.setCellValue(emailId);
		createCell();
		cell.setCellValue(gender);
		createCell();
		cell.setCellValue(DOB);
		createCell();
		cell.setCellValue(country);
		createCell();
		cell.setCellValue(city);
		createCell();
		cell.setCellValue(skill);
		writeExcel();
	}

	public static void writeDataIntoExcel(String fName, String LName, String MobileNo, String emailId, String gender,
			String DOB,String country, String city, String skill) throws IOException {
		i = 1;
		j = 0;
		createRow();
		createCell();
		cell.setCellValue(fName);
		createCell();
		cell.setCellValue(LName);
		createCell();
		cell.setCellValue(MobileNo);
		createCell();
		cell.setCellValue(emailId);
		createCell();
		cell.setCellValue(gender);
		createCell();
		cell.setCellValue(DOB);
		createCell();
		cell.setCellValue(country);
		createCell();
		cell.setCellValue(city);
		createCell();
		cell.setCellValue(skill);
		writeExcel();
	}

	public static void writeExcel() throws IOException {
		file = new FileOutputStream(excelFilePath);
		workbook.write(file);
		file.close();
	}

}
