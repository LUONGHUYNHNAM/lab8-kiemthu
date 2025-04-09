package com.poly.test_subject.lab5Test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai1 {
    
    @Test
    void test1 () {
        WebDriver webDriver = new ChromeDriver();

        try{
            String url = "https://www.google.com";
            String title_web = "Google";
            webDriver.get(url);
            String title = webDriver.getTitle();

            if(title.contentEquals(title_web)) {
                System.out.println("Pass");
            }else {
                System.out.println("Test fail");
            }
        }finally {
            if (webDriver != null) {
                webDriver.quit();
            }
        }
    }
}
