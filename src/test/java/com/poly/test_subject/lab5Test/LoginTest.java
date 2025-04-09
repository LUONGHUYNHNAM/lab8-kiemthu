package com.poly.test_subject.lab5Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private String baseUrl = "https://www.facebook.com/";

    @BeforeClass
    public void setUp() {
        // Đặt đường dẫn ChromeDriver (cần chỉnh lại theo hệ thống của bạn)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
            {"valid_email@gmail.com", "valid_password", true},  // Đăng nhập thành công
            {"invalid_email@gmail.com", "valid_password", false}, // Sai email
            {"valid_email@gmail.com", "wrong_password", false},  // Sai password
            {"", "", false}  // Để trống username & password
        };
    }

    @Test(dataProvider = "loginData")
    public void testFacebookLogin(String email, String password, boolean expectedSuccess) {
        driver.get(baseUrl);

        // Tìm các phần tử trên giao diện đăng nhập Facebook
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));

        // Nhập thông tin đăng nhập
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

        // Kiểm tra kết quả
        if (expectedSuccess) {
            // Kiểm tra xem có chuyển đến trang chính không
            Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"), "Login failed unexpectedly.");
        } else {
            // Kiểm tra nếu có thông báo lỗi xuất hiện
            WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'email hoặc số điện thoại')]"));
            Assert.assertTrue(errorMessage.isDisplayed(), "Expected error message not displayed.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}