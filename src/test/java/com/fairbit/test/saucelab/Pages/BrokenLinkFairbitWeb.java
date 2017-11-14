package com.fairbit.test.saucelab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.net.URL;
import java.net.HttpURLConnection;
import java.util.List;

/**
 * Created by OZGUR-FAIRBIT on 11/3/2017.
 */
public class BrokenLinkFairbitWeb {

    public WebDriver driver;
    public static String url = "https://www.fairbit.com";

    public static BrokenLinkFairbitWeb visitPage(WebDriver driver) {
        BrokenLinkFairbitWeb page = new BrokenLinkFairbitWeb(driver);
        page.visitPage();
        return page;
    }

    public BrokenLinkFairbitWeb(WebDriver driver) {
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


    public String VerifyLink() {
        List<WebElement> links=driver.findElements(By.tagName("a"));
        //System.out.println("Total links are "+links.size());
        String msg = "";
        for(int i=0;i<links.size();i++)
        {
            WebElement ele= links.get(i);
            String url=ele.getAttribute("href");
            verifyLinkActive(url);

            if (!url.contains(" - OK"))
            {
                //bad link here
                return url;
            }
        }
        msg = "OK";
        return msg;
    }

    public static void verifyLinkActive(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {

        }
    }
}
