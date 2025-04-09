package com.poly.test_subject.lab6Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();

        try {
            // Mở trang login
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // Tìm các thành phần và thực hiện thao tác login
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("submit"));

            username.sendKeys("student"); 
            password.sendKeys("Password123");
            loginButton.click(); // Nhấn login

            // Kiểm tra kết quả
            WebElement successMessage = driver.findElement(By.className("post-title"));
            if (successMessage.isDisplayed()) {
                System.out.println("Login thành công!");
            } else {
                System.out.println("Login thất bại!");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}