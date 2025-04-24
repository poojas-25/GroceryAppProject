package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	
	static FileInputStream f; //for opening file
	static XSSFWorkbook w;  //accessing workbook
	static XSSFSheet s;  //for accessing sheet	
	
	//method for returning string values
	public static String getStringData(int row, int column, String sheet) throws IOException
	{
		f = new FileInputStream(Constants.TESTDATAFILE); 
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);  //declaring row and reading row from sheet
	    XSSFCell c = r.getCell(column); //declaring cell and reading cell from sheet
	    
	    return c.getStringCellValue(); //will return cell string value
	}
	
	//method for returning string values
	public static String getIntegerData(int row, int column,String sheet) throws IOException
	{
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);  //declaring row and reading row from sheet
	    XSSFCell c = r.getCell(column); //declaring cell and reading cell from row
	    
	    int x = (int) c.getNumericCellValue(); //will get numeric value from cell and stores it
	    return String.valueOf(x); //will convert integer to string as the return type is string
	    
	}

}
