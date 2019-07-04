package com.kh.lgtw.employee.model.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmpExcelSample {
	public static void empExcelSamle(){
		
		Workbook wb = new XSSFWorkbook();
		
		Sheet sheet1 = wb.createSheet();
		
		sheet1.setColumnWidth(0, 1000);
		sheet1.setColumnWidth(9, 1000);
		
		Row row = null;
		Cell cell = null;
		
		row = sheet1.createRow(0);
		
		cell = row.createCell(0);
		cell.setCellValue("아이디");
		cell = row.createCell(1);
		cell.setCellValue("비밀번호");
		cell = row.createCell(2);
		cell.setCellValue("이름");
		cell = row.createCell(3);
		cell.setCellValue("전화번호");
		cell = row.createCell(4);
		cell.setCellValue("상태");
		cell = row.createCell(5);
		cell.setCellValue("입사일");
		
		row = sheet1.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("kh0101");
		cell = row.createCell(1);
		cell.setCellValue("1234");
		cell = row.createCell(2);
		cell.setCellValue("홍길동");
		cell = row.createCell(3);
		cell.setCellValue("010-1234-1234");
		cell = row.createCell(4);
		cell.setCellValue("Y");
		cell = row.createCell(5);
		cell.setCellValue("2019-01-01");
		
		row = sheet1.createRow(2);
		cell = row.createCell(0);
		cell.setCellValue("kh1223");
		cell = row.createCell(1);
		cell.setCellValue("5678");
		cell = row.createCell(2);
		cell.setCellValue("세종대왕");
		cell = row.createCell(3);
		cell.setCellValue("010-5959-7979");
		cell = row.createCell(4);
		cell.setCellValue("Y");
		cell = row.createCell(5);
		cell.setCellValue("2019-01-02");
		
		try {
			File xlsFile = new File("C:/sample.xls");
			FileOutputStream fileOut = new FileOutputStream(xlsFile);
			wb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
			
		}
	}
}
