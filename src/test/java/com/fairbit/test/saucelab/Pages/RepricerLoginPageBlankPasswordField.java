package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RepricerLoginPageBlankPasswordField {
    public WebDriver driver;
    public static String url = "https://app.fairbit.com/auth/login";

    public static RepricerLoginPageBlankPasswordField visitPage(WebDriver driver) {
        RepricerLoginPageBlankPasswordField page = new RepricerLoginPageBlankPasswordField(driver);
        page.visitPage();
        return page;
    }

    public RepricerLoginPageBlankPasswordField(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void login() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("test@fairbit.com");

        driver.findElement(By.xpath("//*[@id='index']/div[2]/div/div/div/div/div/div/div[3]/div[3]/div[2]/div/button/span[1]")).click();
    }

    public String getLabelText() {
        return driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/div/div/div/div/div[3]/div[2]/div/p")).getText();
    }
}




