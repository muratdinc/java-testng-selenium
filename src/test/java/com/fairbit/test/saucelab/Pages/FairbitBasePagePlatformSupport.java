package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by OZGUR-FAIRBIT on 10/26/2017.
 */
public class FairbitBasePagePlatformSupport {
    //@FindBy(linkText = "i am a link")
    //private WebElement theActiveLink;

    //@FindBy(id = "your_comments")
    //private WebElement yourCommentsSpan;

    //@FindBy(id = "comments")
    //private WebElement commentsTextAreaInput;

    //@FindBy(id = "submit")
    //private WebElement submitButton;

    public WebDriver driver;
    public static String url = "https://sauce-lab-test.firebaseapp.com/#/cp/hello";

    public static FairbitBasePagePlatformSupport visitPage(WebDriver driver) {
        FairbitBasePagePlatformSupport page = new FairbitBasePagePlatformSupport(driver);
        page.visitPage();
        return page;
    }

    public FairbitBasePagePlatformSupport(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }


    public void ClickButton() {
        driver.findElement(By.xpath(".//*[@id='app']/div/div/div/header/div/label/div/span/span[1]/input")).click();
    }

    public String getLabelText() {
        return driver.findElement(By.xpath(".//*[@id='app']/div/div/div/div/lu/li[2]")).getText();
    }
    /*
    public void LoginAndChangeMode() {
        driver.findElement(By.xpath(".//*[@id='app']/div/div/div/div/button")).click();
        // Race condition for time to populate yourCommentsSpan
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='app']/div/div/div/header/div/label/p")));
    }

    public String getLabelText() {
        return driver.findElement(By.xpath(".//*[@id='app']/div/div/div/header/div/label/p")).getText();
    }
*/
}
