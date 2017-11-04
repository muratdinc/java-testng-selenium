package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by OZGUR-FAIRBIT on 11/3/2017.
 */
public class GitHubRegistration {

    public WebDriver driver;
    public static String url = "https://github.com/login";

    public static GitHubRegistration visitPage(WebDriver driver) {
        GitHubRegistration page = new GitHubRegistration(driver);
        page.visitPage();
        return page;
    }

    public GitHubRegistration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void login() {
        driver.findElement(By.xpath(".//*[@id='login_field']")).sendKeys("esrefozguraltuntas@gmail.com");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("49812345Eoa;");
        driver.findElement(By.xpath(".//*[@id='login']/form/div[4]/input[3]")).click();
    }

    public String getLabelText() {
        return driver.findElement(By.xpath(".//*[@id='js-pjax-container']/div[1]/div/div/h2")).getText();
    }
}
