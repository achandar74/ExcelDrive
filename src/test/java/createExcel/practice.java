package createExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practice {
	public static void main(String[] args) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("lib/dfaf.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.rowIterator(); // sheet is collection of rows
				Row firstrow = row.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int column = 0;
				int d[] = { 1, 2, 3 };
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("userdetails")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (row.hasNext()) {
					for (int j = 0; j < d.length; j++) {
						Row r = row.next();
						if (r.getCell(column).getStringCellValue().equalsIgnoreCase("data" + d[j] + "")) {
							Iterator<Cell> cv = r.cellIterator();
							while (cv.hasNext()) {
								Cell c = cv.next();
								if (c.getCellType() == CellType.STRING) {
									a.add(c.getStringCellValue());
								} else {
									a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							}
							System.out.println(a.get(0));
							System.out.println(a.get(1));
							System.out.println(a.get(2));
						}
					}
				}
			}
		}

	}
}
