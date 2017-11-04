package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by OZGUR-FAIRBIT on 11/3/2017.
 */
public class DropdownSelectionFacebook {

    public WebDriver driver;
    public static String url = "https://www.facebook.com";

    public static DropdownSelectionFacebook visitPage(WebDriver driver) {
        DropdownSelectionFacebook page = new DropdownSelectionFacebook(driver);
        page.visitPage();
        return page;
    }

    public DropdownSelectionFacebook(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public String GetSelectDDValues() {

        WebElement month_dropdown = driver.findElement ( By.id ( "month" ) );
        Select month_dd=new Select (month_dropdown);
        //It will select march
        month_dd.selectByIndex ( 8 );

        //It will select Oct
/*        month_dd.selectByValue ( "10" );

        //It will select Aug
        month_dd.selectByVisibleText ( "Aug" );
*/
        WebElement selected_value=month_dd.getFirstSelectedOption ();

        return selected_value.getText ();
    }
}
