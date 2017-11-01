package com.fairbit.test.saucelab.Pages;
import javax.xml.bind.annotation.*;


/**
 * Created by OZGUR-FAIRBIT on 10/31/2017.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"browsername","browserversion","os"})
public class Platform {
    private int id;
    private String browsername;
    private String browserversion;
    private String os;

    public Platform() {
    }
    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setId(Number id) {
        this.id = id.intValue();
    }
    public String getBrowsername() {
        return browsername;
    }
    public void setBrowsername(String browsername) {
        this.browsername = browsername;
    }
    public String getBrowserversion() {
        return browserversion;
    }
    public void setBrowserversion(String browserversion) {
        this.browserversion = browserversion;
    }
    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }

}
