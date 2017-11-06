package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by OZGUR-FAIRBIT on 11/3/2017.
 */
public class HandleCheckBoxes {

    public WebDriver driver;
    public static String url = "http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html";

    public static HandleCheckBoxes visitPage(WebDriver driver) {
        HandleCheckBoxes page = new HandleCheckBoxes (driver);
        page.visitPage();
        return page;
    }

    public HandleCheckBoxes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public String GetCheckBoxValues() {

        List<WebElement> check=driver.findElements ( By.xpath ( "//input[@type='checkbox']" ) );

        String listid = "";
        for (int i=0;i<check.size ();i++){
            WebElement local_check=check.get(i);
            String id = local_check.getAttribute ( "id" );
            listid += id;
        }
        return listid;
    }
}
