package greens.org;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task3 {

	public static void main(String[] args) throws IOException {
		  File fi = new File ("C:\\Users\\hi\\java eclipse-workspace\\class\\Excel\\text.xlsx");
          Workbook w = new XSSFWorkbook();
         Sheet sh = w.createSheet("Hello");
         Row row = sh.createRow(0);
         Cell cell =row.createCell(0);
         cell.setCellValue("java");
         FileOutputStream out = new FileOutputStream(fi);
         w .write(out);
         
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
