package com.Module01Login.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;


public class T03_LoginLogout {

    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void openURL() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(dataProvider = "getLoginData")
    public void loginToOHRM(String un, String ps) {

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    
    @AfterMethod
    public void logout() {

        try {
            //  Take screenshot for EVERY login attempt
        	com.OrangeHRM.Util.Screenshot.captureScreenshot(driver);

            //  If login successful → dashboard visible → logout
            if (driver.getCurrentUrl().contains("dashboard")) {

                WebElement profile = wait.until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//p[@class='oxd-userdropdown-name']")));
                profile.click();

                WebElement logoutBtn = wait.until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//a[text()='Logout']")));
                logoutBtn.click();

                System.out.println("✔ Test case passed (Valid Login & Logout Successful)");
            } 
            else {
                //  If invalid login → capture error safely
                List<WebElement> errorMsg = driver.findElements(
                        By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));

                if (!errorMsg.isEmpty()) {
                    System.out.println("✖ Invalid credentials → Test failed");
                } else {
                    System.out.println("⚠ Neither dashboard nor error message appeared");
                }
            }

        } catch (Exception e) {
            System.out.println("⚠ Screenshot/Logout skipped due to: " + e.getMessage());
        }
    }



    @DataProvider
    public Object[][] getLoginData() throws IOException {

        file = new File("LoginTestData_OHRM.xlsx");
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("OHRM_Data");

        int rows = sheet.getPhysicalNumberOfRows();
        Object[][] loginData = new Object[rows - 1][2];

        for (int i = 1; i < rows; i++) {
            loginData[i - 1][0] = sheet.getRow(i).getCell(0).getStringCellValue();
            loginData[i - 1][1] = sheet.getRow(i).getCell(1).getStringCellValue();
        }

        wb.close();
        fis.close();

        return loginData;
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
