package createExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Example3 {
	@Test
	public void create() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("book1");

		Object[][] data = new Object[4][4];
		data[0][0] = "1";
		data[0][1] = "Java";
		data[0][2] = "djfa";
		data[0][3] = "xyz";
		data[1][0] = "2";
		data[1][1] = "cp";
		data[1][2] = "cjsdj";
		data[1][3] = "abc";
		data[2][0] = "3";
		data[2][1] = "c";
		data[2][2] = "dfjs";
		data[2][3] = "pqr";
		data[3][0] = "4";
		data[3][1] = "cs";
		data[3][2] = "jdfkd";
		data[3][3] = "stu";
		int rownum = 0;
		for (Object[] Book : data) {
			Row row = sheet.createRow(++rownum);

			int columnCount = 0;

			for (Object field : Book) {
				Cell cell = row.createCell(++columnCount);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}

		}
		FileOutputStream outputStream = new FileOutputStream("C:\\Users\\JANARDHAN\\OneDrive\\Desktop\\example2.xlsx");
		workbook.write(outputStream);
		outputStream.flush();
		workbook.close();
	}
}
