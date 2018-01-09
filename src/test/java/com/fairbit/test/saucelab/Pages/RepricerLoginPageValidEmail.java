package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RepricerLoginPageValidEmail {

        public WebDriver driver;
        public static String url = "https://app.fairbit.com/auth/login";

        public static RepricerLoginPageValidEmail visitPage(WebDriver driver) {
            RepricerLoginPageValidEmail page = new RepricerLoginPageValidEmail(driver);
            page.visitPage();
            return page;
        }

        public RepricerLoginPageValidEmail(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void visitPage() {
            this.driver.get(url);
        }

        public void login() throws InterruptedException {
            driver.findElement(By.id("email")).sendKeys("test@fairbit.com");
            driver.findElement(By.id("password")).sendKeys("test1234");

            driver.findElement(By.xpath("//*[@id='index']/div[2]/div/div/div/div/div/div/div[3]/div[3]/div[2]/div/button/span[1]")).click();
        }

    public String getLabelText() {
        return driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/div/div/div/div[1]/div/h1")).getText();
    }
    }


