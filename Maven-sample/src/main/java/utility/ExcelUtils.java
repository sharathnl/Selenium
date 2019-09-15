package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;


public class ExcelUtils {


    public static final String Path_TestData = "C:\\Bheer\\KN_WS\\Maven-sample\\";

    public static final String File_TestData = "KNAutomationSheet.xls";

	private static HSSFSheet ExcelWSheet;

	private static HSSFWorkbook ExcelWBook;

	private static HSSFCell Cell;

	private static HSSFRow Row;

	
	
	
	/*public static void main(String[] args) throws Exception {
		
		setExcelFile(Path_TestData+File_TestData,"PageElements");
		String PAGE_ID="SEND_QUESTIONNAIRE";
		String OBJECT_NAME="AudienceName";
		
		int rowCount=ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
		for(int i=1;i<=rowCount+1;i++){
			
		String pageID=ExcelUtils.getCellData(i, 0);
		String objName=ExcelUtils.getCellData(i, 1);
		
		if(pageID.equals(PAGE_ID)&&objName.equals(OBJECT_NAME)){
			
			String by=ExcelUtils.getCellData(i, 2);
			String prop=ExcelUtils.getCellData(i, 3);
			
			break;
			
		}
			
			
		}
		
	}*/
	
	
	public String getIdentifyBy(String PAGE_ID,String OBJECT_NAME) throws Exception{
		
		setExcelFile(Path_TestData+File_TestData,"PageElements");
		int rowCount=ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
		String by = null;
		String prop = null;
		for(int i=1;i<=rowCount+1;i++){
			
			String pageID=ExcelUtils.getCellData(i, 0);
			String objName=ExcelUtils.getCellData(i, 1);
			
			if(pageID.equals(PAGE_ID)&&objName.equals(OBJECT_NAME)){
				
				by=ExcelUtils.getCellData(i, 2);
				prop=ExcelUtils.getCellData(i, 3);
				
				break;
				
			}
				
				
			}
		return by;
		
	}
	
public String getPageProperty(String PAGE_ID,String OBJECT_NAME) throws Exception{
		
		setExcelFile(Path_TestData+File_TestData,"PageElements");
		int rowCount=ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
		String by = null;
		String prop = null;
		for(int i=1;i<=rowCount+1;i++){
			
			String pageID=ExcelUtils.getCellData(i, 0);
			String objName=ExcelUtils.getCellData(i, 1);
			
			if(pageID.equals(PAGE_ID)&&objName.equals(OBJECT_NAME)){
				
				by=ExcelUtils.getCellData(i, 2);
				prop=ExcelUtils.getCellData(i, 3);
				
				break;
				
			}
				
				
			}
		return prop;
		
	}
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet

		ExcelWBook = new HSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}



	public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		}catch (Exception e){

			return"";

		}

	}
	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

		try{

			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		}catch(Exception e){

			throw (e);

		}

	}




}
