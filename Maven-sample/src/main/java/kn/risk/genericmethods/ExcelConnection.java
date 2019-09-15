package kn.risk.genericmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelConnection {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		String fileName="KNAutomationSheet.xls";
		
		String PAGE_ID="SEND_QUESTIONNAIRE";
		String OBJECT_NAME="AudienceName";
		
		
		File file =    new File("C:\\Bheer\\KN_WS\\Maven-sample\\"+fileName+"");

		FileInputStream fs = new FileInputStream(file);
		Workbook  wb = new HSSFWorkbook(fs);
		
		Sheet sheet=wb.getSheet("PageElements");
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=0; i<rowCount+1;i++){
			
			Row row = sheet.getRow(i);
			
			
			/* for (int j = 1; j < row.getLastCellNum(); j++) {

		            String PageID1=row.getCell(j).getStringCellValue();
		            String ObjectName=row.getCell(j+1).getStringCellValue();
		           // String ObjectName=row.getCell(j+1).getStringCellValue();
		            System.out.println(PageID1);
		            
		            

		        }*/

			
		}


	    




	}

	
	


}
