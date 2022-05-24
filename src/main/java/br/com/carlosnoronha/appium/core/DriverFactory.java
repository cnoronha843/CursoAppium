package br.com.carlosnoronha.appium.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException, InterruptedException {
        if (driver == null){
            createDriver ();
        }
        return driver;
    }

    public static void killDriver(){
        if (driver!= null){
            driver.quit ();
            driver= null;
        }
    }


    private static void createDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability("deviceName", "Galaxy Nexus API 24");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability ("automationName", "uiautomator2");
        desiredCapabilities.setCapability ("appPackage", "com.ctappium");
        desiredCapabilities.setCapability ("appActivity", "com.ctappium.MainActivity");

        try {
            driver = new AndroidDriver<AndroidElement> (new URL ("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        }catch (MalformedURLException e){
            e.printStackTrace ();
        }
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);

    }
}
