package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RepricerLoginPageInvalidEmail {
    public WebDriver driver;
    public static String url = "https://app.fairbit.com/auth/login";

    public static RepricerLoginPageInvalidEmail visitPage(WebDriver driver) {
        RepricerLoginPageInvalidEmail page = new RepricerLoginPageInvalidEmail(driver);
        page.visitPage();
        return page;
    }

    public RepricerLoginPageInvalidEmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void login() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("test1@google.com");
        driver.findElement(By.id("password")).sendKeys("test1234");

        driver.findElement(By.xpath("//*[@id='index']/div[2]/div/div/div/div/div/div/div[3]/div[3]/div[2]/div/button/span[1]")).click();
    }

    public String getLabelText() {
        return driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/div/div/div/div/div[3]/div[3]/p")).getText();
    }
}


