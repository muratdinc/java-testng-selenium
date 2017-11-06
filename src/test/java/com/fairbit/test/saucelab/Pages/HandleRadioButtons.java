package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by OZGUR-FAIRBIT on 11/3/2017.
 */
public class HandleRadioButtons {

    public WebDriver driver;
    public static String url = "http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html";

    public static HandleRadioButtons visitPage(WebDriver driver) {
        HandleRadioButtons page = new HandleRadioButtons(driver);
        page.visitPage();
        return page;
    }

    public HandleRadioButtons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public String GetRadioButtonValues() {

        List<WebElement> radio=driver.findElements ( By.xpath ( "//input[@name='lang' and @type='radio']" ) );

        String listvalue = "";
        for (int i=0;i<radio.size ();i++){
            WebElement local_radio=radio.get(i);
            String value = local_radio.getAttribute ( "value" );
            listvalue += value;
        }
        return listvalue;
    }
}
