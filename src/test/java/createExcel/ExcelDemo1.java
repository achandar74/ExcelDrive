package createExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDemo1 {
	@Test
	public void excel() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("UserCrendentials");

		Object[][] bookData = {{"userdetails","username","password"},{"data1","chandar","chandar"},{"data2","cherry","cherry"},{"data3","admin","admin"}};

		int rowCount = 0;

		for (Object[] aBook : bookData) {
			Row row = sheet.createRow(++rowCount);

			int columnCount = 0;

			for (Object field : aBook) {
				Cell cell = row.createCell(++columnCount);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}

		FileOutputStream outputStream = new FileOutputStream("C:\\Users\\JANARDHAN\\OneDrive\\Desktop\\usernameAndpassword.xlsx");
		workbook.write(outputStream);
		outputStream.flush();
		outputStream.close();
		workbook.close();
	}

}