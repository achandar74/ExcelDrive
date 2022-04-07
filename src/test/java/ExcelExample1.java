import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExample1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("lib/Book.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("demo")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.rowIterator();
				Row firstrow = row.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int coulumn = 0;
				while (ce.hasNext()) {
					Cell r = ce.next();
					if (r.getStringCellValue().equalsIgnoreCase("testscenario")) {
						coulumn = k;
					}
					k++;
				}
				System.out.println(coulumn);
				while(row.hasNext()) {
					Row data = row.next();
					System.out.println(data.getCell(coulumn).getStringCellValue());
				}
			}
		}
	}
}
