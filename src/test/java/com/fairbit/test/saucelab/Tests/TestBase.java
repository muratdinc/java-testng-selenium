package com.fairbit.test.saucelab.Tests;

import com.fairbit.test.saucelab.Pages.Platform;
import com.fairbit.test.saucelab.Pages.Platforms;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import com.fairbit.test.saucelab.Pages.ReadPlatformXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.fairbit.test.saucelab.Pages.ReadPlatformXML.getObjects;
import static org.apache.commons.lang3.ArrayUtils.toArray;

/**
 * Simple TestNG test which demonstrates being instantiated via a DataProvider in order to supply multiple browser combinations.
 *
 * @author Neil Manvar
 */
public class TestBase {

    public String buildTag = System.getenv("BUILD_TAG");

//    public String username = "mohamedturco";
//    public String accesskey = "5d9945c0-bb9c-4762-a5c4-dee9ddf021e3";

//    public String username = "vhill93";
//    public String accesskey = "d7e6b68a-78bf-4e7d-b9a2-b54834afbadd";

//    public String username = "shaikhsalman";
//    public String accesskey = "5b1948b8-4ec4-40ca-a53d-6a0cfb6f9788";

    public String username = "muratdinch";
    public String accesskey = "c906fb44-42d7-4754-a4f3-b6d1ef918f3e";
    /**
     * ThreadLocal variable which contains the  {@link WebDriver} instance which is used to perform browser interactions with.
     */
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    /**
     * ThreadLocal variable which contains the Sauce Job Id.
     */
    private ThreadLocal<String> sessionId = new ThreadLocal<String>();

    /**
     * DataProvider that explicitly sets the browser combinations to be used.
     *
     * @param testMethod
     * @return Two dimensional array of objects with browser, version, and platform information
     */
    @DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Iterator<Object[]> sauceBrowserDataProvider(Method testMethod) throws JAXBException {
        File f = new File("./data/platforms.xml");
        JAXBContext context = JAXBContext.newInstance(Platforms.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Platforms platforms = (Platforms) unmarshaller.unmarshal(f);
        List<Platform> data = platforms.getPlatforms();
        List<Object[]> objectdata = new ArrayList<Object[]>();


        for (Platform platform : data){
            objectdata.add(new Object[]{
                platform.getBrowsername(), platform.getBrowserversion(), platform.getOs()
            });

//            System.out.println(platform);
        }
//        return new Object[][]{
//                new Object[]{"MicrosoftEdge", "14.14393", "Windows 10"},
//                new Object[]{"firefox", "49.0", "Windows 10"},
//              new Object[]{"internet explorer", "11.0", "Windows 7"},
//                new Object[]{"safari", "10.0", "OS X 10.11"},
//                new Object[]{"chrome", "54.0", "OS X 10.10"},
//                new Object[]{"chrome", "60.0", "OS X 10.10"},
//                new Object[]{"firefox", "latest-1", "Windows 7"},
//        };
/*        for(Object[] datas: objectdata){
            for(Object somedata: datas)
            System.out.println(somedata.toString());
        }
*/
            return objectdata.iterator();
    }

    /**
     * @return the {@link WebDriver} for the current thread
     */
    public WebDriver getWebDriver() {
        return webDriver.get();
    }

    /**
     * @return the Sauce Job id for the current thread
     */
    public String getSessionId() {
        return sessionId.get();
    }

    /**
     * Constructs a new {@link RemoteWebDriver} instance which is configured to use the capabilities defined by the browser,
     * version and os parameters, and which is configured to run against ondemand.saucelabs.com, using
     * the username and access key populated by the {@link #authentication} instance.
     *
     * @param browser    Represents the browser to be used as part of the test run.
     * @param version    Represents the version of the browser to be used as part of the test run.
     * @param os         Represents the operating system to be used as part of the test run.
     * @param methodName Represents the name of the test case that will be used to identify the test on Sauce.
     * @return
     * @throws MalformedURLException if an error occurs parsing the url
     */
    protected void createDriver(String browser, String version, String os, String methodName)
            throws MalformedURLException, UnexpectedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // set desired capabilities to launch appropriate browser on Sauce
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability(CapabilityType.PLATFORM, os);
        capabilities.setCapability("name", methodName);

        if (buildTag != null) {
            capabilities.setCapability("build", buildTag);
        }

        // Launch remote browser and set it as the current thread
        webDriver.set(new RemoteWebDriver(
                new URL("https://" + username + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub"),
                capabilities));

        // set current sessionId
        String id = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
        sessionId.set(id);
    }

    /**
     * Method that gets invoked after test.
     * Dumps browser log and
     * Closes the browser
     */
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        ((JavascriptExecutor) webDriver.get()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
        webDriver.get().quit();
    }

    protected void annotate(String text) {
        ((JavascriptExecutor) webDriver.get()).executeScript("sauce:context=" + text);
    }
}
