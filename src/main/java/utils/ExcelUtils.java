package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
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
	private static Logger logger=LoggerClass.getLogger();
	private String filePath=null;
	public ExcelUtils(String filePath) {
		this.filePath=filePath;
		logger.debug("Instantiating Excel File with File path "+filePath);

		try {
			in=new FileInputStream(filePath);
			try {
				logger.debug("Input file stream object created "+in.getFD().valid());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			logger.debug("Exception during creation of input stream object creation "+e.getMessage());

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileExtension=filePath.split(".")[1];
		logger.debug("File Type for excel file is "+fileExtension);

		switch(fileExtension) {
		case "xlsx":
			try {
				wbook=new XSSFWorkbook(in);
				logger.debug("Excel workbook object instantiated for .xlsx file for file "+filePath);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.debug("Excel workbook object counld not be "
						+ "instantiated for .xlsx file for file "+filePath+" because of "+e.getMessage());

			}
		case "xls":
			try {
				wbook=new HSSFWorkbook(in);
				logger.debug("Excel workbook object instantiated for .xls file for file "+filePath);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.debug("Excel workbook object counld not be "
						+ "instantiated for .xls file for file "+filePath+" because of "+e.getMessage());

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
		logger.debug(" Setting sheet name " +sheetName+" for workbook of filename "+filePath);

		sheet=wbook.getSheet(sheetName);
		if(sheet.getSheetName()!=null) {
		logger.debug(" Set sheet name " +sheet.getSheetName()+" for workbook of filename "+filePath+" is successfull");
		}

	}
	
	public Sheet getSheet() {
		return sheet;
	}
	
	
	
	public Object getCellData(int rowNum,int columnNumber) {
		Row row =sheet.getRow(rowNum);
		if(row==null) {
			logger.debug(" Row does not exist in sheet " +sheet.getSheetName()+" for workbook of filename "+filePath+" returning null");
			return null;
		}
		
		Cell cell=row.getCell(columnNumber,MissingCellPolicy.CREATE_NULL_AS_BLANK);
		Object cellValue=null;
		if(cell.getCellType()==CellType.BLANK){
			logger.debug(" Cell is blank for row number" +rowNum+" and column number"
					+ " "+columnNumber+" so returning blank ");

			return "";
		}
		if(DateUtil.isCellDateFormatted(cell)) {
			logger.debug(" Cell is date formatted for row number" +rowNum+" and column number"
					+ " "+columnNumber+" so returning date value of cell ");
			cellValue=cell.getDateCellValue();
			logger.debug("cell value is "+cellValue);

					}
		CellType cellType=cell.getCellType();
		switch(cellType) {
		case NUMERIC:
			logger.debug("cell type is numeric");
			cellValue=cell.getNumericCellValue();

			break;
		case STRING:
			logger.debug("cell type is String");
			cellValue=cell.getStringCellValue();

			break;
		case BOOLEAN:
			logger.debug("cell type is String");
			cellValue=cell.getBooleanCellValue();
			break;
		
		default:
			logger.debug("no matching cell type from switch statement "+cell.getCellType().name());

			break;
		}
		logger.debug("cell value is "+cellValue);
		return cellValue;
		
	}

	public void setCellData(Sheet sheet, int rowNum,int columnNumber,Object cellValue) {
		logger.debug("Setting cell data for row number"+rowNum+" and column number "+columnNumber);

		Row row =sheet.getRow(rowNum);
		if(row!=null) {
			logger.debug("Row found successfully for "+rowNum);

		}
		else {
			logger.debug("Row was not found for "+rowNum+" creating new row for "+rowNum);

			sheet.createRow(rowNum);
			logger.debug("Created new row for "+rowNum);
			 row=sheet.getRow(rowNum);

		}
		
	
		
		Cell cell=row.getCell(columnNumber,MissingCellPolicy.RETURN_BLANK_AS_NULL);
		logger.debug("fetched cell for row "+rowNum+" column number "+columnNumber+" and cell is "+cell);

		if(cell==null) {
			logger.debug("Cell is null ");

			row.createCell(columnNumber);
			logger.debug("Created new cell ");

			cell=row.getCell(columnNumber);
		

			cell.setCellValue("");
			logger.debug("Setted cell as blank string");
		}
		
		if(cellValue instanceof String) {
			logger.debug("Value type is string so setting string value "+cellValue+" for cell");

			cell.setCellValue((String)cellValue);

		}
		if(cellValue instanceof Integer) {
			logger.debug("Value type is integer so setting integer value "+cellValue+" for cell");

			cell.setCellValue((Integer)cellValue);
		}
		if(cellValue instanceof Double) {
			logger.debug("Value type is double so setting double value "+cellValue+" for cell");

			cell.setCellValue((Double)cellValue);
		}
		if(cellValue instanceof Date) {
			logger.debug("Value type is date type so setting date value "+cellValue+" for cell");
			cell.setCellValue((Date)cellValue);
		}
		logger.debug("Value for cell is "+cellValue);

	}

	
}
