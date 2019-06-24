package com.kh.lgtw.employee.model.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellReference;

public class ExcelCellRef {
	public static String getName(Cell cell, int cellIndex) {
		int cellNum =0;
		if(cell != null) {
			cellNum=cell.getColumnIndex();
		
		}else {
			cellNum = cellIndex;
		}
		return CellReference.convertNumToColString(cellNum);
	}
	
	public static String getValue(Cell cell) {
		String value = "";
		
		if(cell == null) {
            value = "";
        }else if(cell.getCellType() == CellType.FORMULA ) {
        	
        }
		
		return "";
      
		
	}
}
