package com.Module01Login.TestCase;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


public class T01_CreateLoginDataExcel  {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index=0;
	
	
  @Test(dataProvider = "getLoginData")
  public void writeDataToFile(String un, String ps) {
	  
	  sheet.createRow(index).createCell(0).setCellValue(un);
	  sheet.getRow(index).createCell(1).setCellValue(ps);
	  index++;
  }

  @DataProvider
  public Object[][] getLoginData() {
    	return new Object[][] {
			 new Object[] {"UserName","Password"},
			 new Object[] {"Admin","admin123"},
			 new Object[] {"Kiran","kiran123"},
			 new Object[] {"Admin","admin123"},
			 new Object[] {"Kamla","kamla123"},
			 new Object[] {"Admin","admin123"},
	  };
  }
  @BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  //initialization
	  file= new File("LoginData_OHRM.xlsx");
	  fos = new FileOutputStream(file);
	  wb = new XSSFWorkbook ();
	  sheet = wb.createSheet("OHRM_Data");  //sheet name
  }

  @AfterTest
  public void afterTest() throws IOException {
	  wb.write(fos);
	  wb.close();
	  fos.close();
	  
  }

}
