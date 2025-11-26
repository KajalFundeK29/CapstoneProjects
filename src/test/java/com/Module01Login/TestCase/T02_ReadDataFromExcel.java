
package com.Module01Login.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class T02_ReadDataFromExcel {

    private XSSFWorkbook wb;
    private static XSSFSheet sheet;
    private FileInputStream fis;

    // Constructor → open Excel file and sheet
    public void ExcelUtils(String fPath, String sheetName) throws IOException {
        File file = new File(fPath);
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
    }

    // Get data as 2D Object array
    public static Object[][] getExcelData(String fpath) {
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols]; // Exclude header row

        for (int i = 1; i < rows; i++) { // start from 1 to skip header
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                XSSFCell cell = row.getCell(j);
                if (cell != null) {
                    data[i - 1][j] = cell.getStringCellValue();
                } else {
                    data[i - 1][j] = ""; // handle empty cells
                }
            }
        }
        return data;
    }

    // Optional: print all data (for testing)
    public void printAllData() {
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                XSSFCell cell = row.getCell(j);
                String value = (cell != null) ? cell.getStringCellValue() : "";
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    // Close workbook and stream
    public void closeWorkbook() throws IOException {
        wb.close();
        fis.close();
    }
}
