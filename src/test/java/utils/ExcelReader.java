package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

public static Object[][] readData(String filePath, String sheetName) throws Exception {
       FileInputStream fis = new FileInputStream(filePath);
       Workbook workbook = new XSSFWorkbook(fis);
       Sheet sheet = workbook.getSheet(sheetName);

       int rowCount = sheet.getPhysicalNumberOfRows();
       int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
       // rowCount - 1 because we skip the header row
       Object[][] data = new Object[rowCount - 1][colCount];

       for (int i = 1; i < rowCount; i++) {
           Row row = sheet.getRow(i);
           for (int j = 0; j < colCount; j++) {
               Cell cell = row.getCell(j);
               data[i - 1][j] = (cell == null) ? "" : cell.toString();
}
}
        workbook.close();
        fis.close();
        return data;


}

}


