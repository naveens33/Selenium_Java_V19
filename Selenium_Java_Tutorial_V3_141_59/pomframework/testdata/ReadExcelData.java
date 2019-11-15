package testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public String[][] getdata() throws IOException {

		
		FileInputStream file =new FileInputStream(new File("C:\\Users\\naveen.s\\git\\Selenium_Java_V19\\Selenium_Java_Tutorial_V3_141_59\\src\\testngsnippet\\PayeeDetails.xlsx"));
		
		XSSFWorkbook wb =new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("PayeeDetails");
		
		String data[][]=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
}
