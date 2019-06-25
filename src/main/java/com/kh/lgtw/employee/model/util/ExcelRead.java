package com.kh.lgtw.employee.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelRead {
	public static List<Map<String, String>> read(ExcelReadOption excelReadOption){
		
		Workbook wb = ExcelFileType.getWorkbook(excelReadOption.getFilePath());
		
		Sheet sheet = wb.getSheetAt(0);
		
		System.out.println("sheet이름:" + wb.getSheetName(0));
		System.out.println("데이터가 있는 sheet의 수 : " + wb.getNumberOfSheets());
		
		int numOfRows = sheet.getPhysicalNumberOfRows();
		int numOfCells=0;
		
		Row row = null;
		Cell cell = null;
		
		String cellName="";
		
		Map<String, String> map = null;
		
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		
		 for (int rowIndex = excelReadOption.getStartRow() - 1; rowIndex < numOfRows; rowIndex++) {
		      /*
		       * 워크북에서 가져온 시트에서 rowIndex에 해당하는 Row를 가져온다. 하나의 Row는 여러개의 Cell을 가진다.
		       */
		      row = sheet.getRow(rowIndex);

		      if (row != null) {
		        /*
		         * 가져온 Row의 Cell의 개수를 구한다.
		         */
		        numOfCells = row.getPhysicalNumberOfCells();
		        /*
		         * 데이터를 담을 맵 객체 초기화
		         */
		        map = new HashMap<String, String>();
		        /*
		         * cell의 수 만큼 반복한다.
		         */
		        for (int cellIndex = 0; cellIndex < numOfCells; cellIndex++) {
		          /*
		           * Row에서 CellIndex에 해당하는 Cell을 가져온다.
		           */
		          cell = row.getCell(cellIndex);
		          /*
		           * 현재 Cell의 이름을 가져온다 이름의 예 : A,B,C,D,......
		           */
		          cellName = ExcelCellRef.getName(cell, cellIndex);
		          /*
		           * 추출 대상 컬럼인지 확인한다 추출 대상 컬럼이 아니라면, for로 다시 올라간다
		           */
		          if (!excelReadOption.getOutputColumns().contains(cellName)) {
		            continue;
		          }
		          /*
		           * map객체의 Cell의 이름을 키(Key)로 데이터를 담는다.
		           */
		          map.put(cellName, ExcelCellRef.getValue(cell));
		        }
				result.add(map);
			}
		}
		
		return result;
		
	}
}
