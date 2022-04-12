package createExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class userdata {
	@Test
	public static String[][] usercredentials() throws IOException {
		FileInputStream fis= new FileInputStream("./lib/demo.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rownum = sheet.getLastRowNum();
		int colnum=sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rownum][colnum];
		for (int i = 1; i <=rownum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colnum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value=dft.formatCellValue(cell);
//				String value = cell.getStringCellValue();
				data[i-1][j]=value;
			}
		}
		workbook.close();
		return data;
	}
}
