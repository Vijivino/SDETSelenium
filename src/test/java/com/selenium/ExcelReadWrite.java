package com.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReadWrite {
	
	@Test
	public void WriteData() throws InvalidFormatException, IOException {
		FileOutputStream file=new FileOutputStream(".\\TestData\\DataWritten.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("Names");
		row.createCell(1).setCellValue("Ids");
		row.createCell(2).setCellValue("City");
		
		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("viji");
		row1.createCell(1).setCellValue("100");
		row1.createCell(2).setCellValue("Salem");
		
		XSSFRow row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue("Vino");
		row2.createCell(1).setCellValue("200");
		row2.createCell(2).setCellValue("Chennai");
		
		System.out.println("data written successfully");
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file created successfully");
}
	
	@Test
	public void writeConsoledata() throws IOException {
		FileOutputStream file=new FileOutputStream(".\\TestData\\ConsoleData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter No of rows");
		int rownum = sc.nextInt();
		
		System.out.println("Enter No of cell");
		int colnum = sc.nextInt();
			
		for (int i =0;i<=rownum;i++) {
			
			XSSFRow row = sheet.createRow(i);
			
			for(int j=0;j<colnum;j++) {
				System.out.println("Enter row "+i+" of cell "+j+" of data");
				row.createCell(j).setCellValue(sc.next());
			}
		}
	
		System.out.println("data written successfully");
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file created successfully");
	
	}
	
	@Test
	public void readdata() throws IOException
	{
		FileInputStream file=new FileInputStream(".\\TestData\\DataWritten.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(lastCellNum +"and"+lastRowNum);
		
		for(int i=0;i<=lastRowNum;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				String value = row.getCell(j).getStringCellValue();	
				//String value=row.getCell(j).toString();
				System.out.print(value+"\t");
		
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
	}

}
