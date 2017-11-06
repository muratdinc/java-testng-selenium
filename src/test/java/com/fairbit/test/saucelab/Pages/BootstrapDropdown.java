package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Created by OZGUR-FAIRBIT on 11/3/2017.
 */
public class BootstrapDropdown {

    public WebDriver driver;
    public static String url = "http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html";

    public static BootstrapDropdown visitPage(WebDriver driver) {
        BootstrapDropdown page = new BootstrapDropdown(driver);
        page.visitPage();
        return page;
    }

    public BootstrapDropdown(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public String SelectBootstrapDDValues() {

        driver.findElement ( By.xpath ( "//*[@id=\"menu1\"]" ) ).click ();

        List<WebElement> dd_menu=driver.findElements ( By.xpath ( "//ul[@class='dropdown-menu']//li/a" ) );
        String listhtml = "";
        for (int i=0;i<dd_menu.size ();i++){
            WebElement element=dd_menu.get ( i );
            String innerhtml=element.getAttribute ( "innerHTML" );
            listhtml += innerhtml;
        }
        return listhtml;
    }
}
