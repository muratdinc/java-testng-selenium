package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RepricerLoginPageGoogleSignIn {
    public WebDriver driver;
    public static String url = "https://app.fairbit.com/auth/login";

    public static RepricerLoginPageGoogleSignIn visitPage(WebDriver driver) {
        RepricerLoginPageGoogleSignIn page = new RepricerLoginPageGoogleSignIn(driver);
        page.visitPage();
        return page;
    }

    public RepricerLoginPageGoogleSignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div/div/div/div/div/div/div[1]/div/div")).click();
    }
    public String getLabelText() {
        return driver.findElement(By.xpath("//*[@id=\"headingSubtext\"]")).getText();
    }
}

