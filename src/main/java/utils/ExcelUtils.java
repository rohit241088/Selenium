package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

//import org.apache.poi.hpsf.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private FileInputStream in=null;
	private Workbook wbook=null;
	private Sheet sheet=null;
	
	
	public ExcelUtils(String filePath) {
		
		try {
			in=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileExtension=filePath.split(".")[1];
		switch(fileExtension) {
		case "xlsx":
			try {
				wbook=new XSSFWorkbook(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "xls":
			try {
				wbook=new HSSFWorkbook(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public FileInputStream getIn() {
		return in;
	}

	

	public Workbook getWbook() {
		return wbook;
	}

	public void setSheet(String sheetName) {
		wbook.getSheet(sheetName);
		
	}
	
	public Sheet getSheet() {
		return sheet;
	}
	
	
	
	public Object getCellData(int rowNum,int columnNumber) {
		Row row =sheet.getRow(rowNum);
		if(row==null) {
			System.out.println("Row number does not exist in the sheet "+in.getChannel()+" "+sheet.getSheetName());
			return null;
		}
		
		Cell cell=row.getCell(columnNumber,MissingCellPolicy.CREATE_NULL_AS_BLANK);
		Object cellValue=null;
		if(DateUtil.isCellDateFormatted(cell)) {
			cellValue=cell.getDateCellValue();

					}
		CellType cellType=cell.getCellType();
		switch(cellType) {
		case NUMERIC:
			
			cellValue=cell.getNumericCellValue();
		
			break;
		case STRING:
			cellValue=cell.getStringCellValue();
			break;
		case BOOLEAN:
			cellValue=cell.getBooleanCellValue();
			break;
		case BLANK:
			cell.setCellValue("");
			cellValue=cell.getStringCellValue();
			break;
		default:
			break;
		}
		
		return cellValue;
		
	}

	public void setCellData(Sheet sheet, int rowNum,int columnNumber,Object cellValue) {
		Row row =sheet.getRow(rowNum);
		if(row==null) {
			sheet.createRow(rowNum);
		}
		Cell cell=row.getCell(columnNumber,MissingCellPolicy.CREATE_NULL_AS_BLANK);
		if(cellValue instanceof String) {
			cell.setCellValue((String)cellValue);
		}
		if(cellValue instanceof Integer) {
			cell.setCellValue((Integer)cellValue);
		}
		if(cellValue instanceof Double) {
			cell.setCellValue((Double)cellValue);
		}
		if(cellValue instanceof Date) {
			cell.setCellValue((Date)cellValue);
		}
		
	}

	
}
