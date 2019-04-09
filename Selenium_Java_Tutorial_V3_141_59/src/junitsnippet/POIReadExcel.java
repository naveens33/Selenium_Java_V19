package junitsnippet;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-4.0.1-20181203.zip
 */
public class POIReadExcel { 
public String[][] getData() 
    { 
        try { 
        	
        	String currentdirectory=System.getProperty("user.dir");
            FileInputStream file = new FileInputStream(new File(currentdirectory+"\\src\\junitsnippet\\PayeeDetails.xlsx")); 
  
            XSSFWorkbook workbook = new XSSFWorkbook(file); 
  
            XSSFSheet sheet = workbook.getSheetAt(0); 
            String[][] data=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for(int i=1;i<=sheet.getLastRowNum();i++)
            {
            	XSSFRow row=sheet.getRow(i);
            	for(int j=0;j<row.getLastCellNum();j++)
            	{
            		XSSFCell cell=row.getCell(j);
            		switch(cell.getCellType()) 
            		{
            			case STRING:
            				data[i-1][j]=cell.getStringCellValue();
            				break;
            			case NUMERIC:
            				data[i-1][j]=""+cell.getNumericCellValue();
            				break;
            		}
            	}
            }
            file.close(); 
            return data;
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        }
		return null; 
        

    } 
} 
