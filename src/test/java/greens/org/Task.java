package greens.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\hi\\java eclipse-workspace\\class\\Excel\\Book1.xlsx");
		FileInputStream s = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(s);
		Sheet sheet = w.getSheet("Sheet1");
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row r = sheet.getRow(i);
			for (int j = 1; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				CellType cellType = c.getCellType();
				System.out.println(cellType);

				switch (cellType) {
				case STRING:
					String Value = c.getStringCellValue();
					System.out.println(Value);

					break;

				case NUMERIC:
					if (DateUtil.isCellDateFormatted(c)) {

						java.util.Date dateCellValue = c.getDateCellValue();
						SimpleDateFormat dateformat = new SimpleDateFormat("dd/MMM/yy");
						String format = dateformat.format(dateCellValue);
						System.out.println(format);

					} else {
						double numericCellValue = c.getNumericCellValue();
						long round = Math.round(numericCellValue);
						if (numericCellValue == round) {
							String ValueOf = String.valueOf(round);
							System.out.println(ValueOf);

						} else {
							String ValueOf = String.valueOf(numericCellValue);
							System.out.println(ValueOf);
						}
					}
					break;
				default:
					break;
				}

			}

		}

	}

}
