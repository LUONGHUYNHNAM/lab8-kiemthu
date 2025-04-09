package com.poly.test_subject.lab6Test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class LoginTest2Excel {
    public static void main(String[] args) {
        // Đặt đường dẫn cho ChromeDriver
        // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Đường dẫn file Excel
        String excelPath = "test-results.xlsx";

        // Dữ liệu test (có thể mở rộng để đọc từ file)
        String[][] testCases = {
                {"student", "Password123", "Valid"},
                {"student", "wrongpass", "Invalid"},
                {"wronguser", "Password123", "Invalid"},
                {"", "Password123", "Invalid"},
                {"student", "", "Invalid"}
        };

        try {
            try ( // Tạo workbook & sheet
                    Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Login Test Results");
                
                // Tạo tiêu đề cột
                Row headerRow = sheet.createRow(0);
                String[] headers = {"Username", "Password", "Expected", "Result"};
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                }
                
                // Chạy test cases
                for (int i = 0; i < testCases.length; i++) {
                    String username = testCases[i][0];
                    String password = testCases[i][1];
                    String expected = testCases[i][2];
                    
                    // Mở trang đăng nhập
                    driver.get("https://practicetestautomation.com/practice-test-login/");
                    
                    // Điền thông tin đăng nhập
                    driver.findElement(By.id("username")).sendKeys(username);
                    driver.findElement(By.id("password")).sendKeys(password);
                    driver.findElement(By.id("submit")).click();
                    
                    // Kiểm tra kết quả
                    boolean loginSuccess = false;
                    try {
                        WebElement successMsg = driver.findElement(By.className("post-title"));
                        if (successMsg.isDisplayed()) {
                            loginSuccess = true;
                        }
                    } catch (NoSuchElementException e) {
                        loginSuccess = false;
                    }
                    
                    // Ghi kết quả vào Excel
                    Row row = sheet.createRow(i + 1);
                    row.createCell(0).setCellValue(username);
                    row.createCell(1).setCellValue(password);
                    row.createCell(2).setCellValue(expected);
                    row.createCell(3).setCellValue(loginSuccess ? "Pass" : "Fail");
                }
                
                // Xuất file Excel
                FileOutputStream fileOut = new FileOutputStream(new File(excelPath));
                workbook.write(fileOut);
                fileOut.close();
            }

            System.out.println("✅ Kết quả đã được ghi vào " + excelPath);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
