package junittestexamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	

	public String[][] getData() throws IOException
	{
		String currentdirectory=System.getProperty("user.dir");
		
		FileInputStream file = new FileInputStream(new File(currentdirectory+"\\src\\junittestexamples\\PayeeDetails.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
	
		XSSFSheet sheet=workbook.getSheet("PayeeDetails");
		
		String data[][]=new String[sheet.getLastRowNum()-1][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(1).getLastCellNum();j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
}
