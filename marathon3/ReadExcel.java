package marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
    
	public static String[][] readdata(int sheetindex) throws IOException {
		// Setup the path for workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/Questions.xlsx");
		//wb.getSheetAt(sheetindex);
		
		// Get into the respective sheet
		XSSFSheet ws = wb.getSheetAt(sheetindex);
		
		// to get the number of rows with data
		int rowCount = ws.getLastRowNum();
//		int allRowsCount = ws.getPhysicalNumberOfRows();
		
		// to get the number of columns with data
		int cellCount = ws.getRow(0).getLastCellNum();
		
		String[][] data=new String[rowCount][cellCount];
		
		// Get into the specific row
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				XSSFRow row = ws.getRow(i);
				XSSFCell cell = row.getCell(j);
				String data1 = cell.getStringCellValue();
				System.out.println(data1);
				data[i-1][j]=data1;
			}
		}
		
	
		wb.close();
		return data;
		
	}

}

