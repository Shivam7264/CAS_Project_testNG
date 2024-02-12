package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	public  void writeData(List<String> list) throws IOException {
		File file = new File(System.getProperty("user.dir") + "//reports//Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Determine the sheet index based on the existing sheets
	    int index = wb.getNumberOfSheets();

	    // Create a new sheet with the next available index
	    XSSFSheet sheet = wb.createSheet("Sheet" + (index + 1));

	    int rowIndex = sheet.getLastRowNum() + 1; // Start from the next available row

	    for (String item : list) {
	        XSSFRow row = sheet.createRow(rowIndex++);
	        row.createCell(0).setCellValue(item);
	    }

	    FileOutputStream fos = new FileOutputStream(file);
	    wb.write(fos);
	    wb.close();
	}
}
