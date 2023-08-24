package com.qa.utility;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	//new FileInputStream(new File("D:\\javaLogincredential.xls"));
static FileInputStream file;
	static XSSFWorkbook workbook;

	public static void main(String[] args) throws InvalidFormatException, IOException {
		createWorkBook();
		createSheet();
	}

	public static void createWorkBook() throws InvalidFormatException, IOException {
		file = new FileInputStream(new File("C:\\Users\\Mamta\\eclipse-workspace\\JalaAcademyAssignment.xls"));
		workbook = new XSSFWorkbook(file);
	}

	public static void createSheet()
	{
		XSSFSheet sheet=workbook.getSheet("LoginCredential");
		System.out.println(sheet);
	}
	
}
