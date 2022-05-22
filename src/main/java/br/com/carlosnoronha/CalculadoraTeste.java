package br.com.carlosnoronha;



import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTeste {
    @Test
    public void soma () throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
        desiredCapabilities.setCapability (MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability (MobileCapabilityType.DEVICE_NAME, "330069f29b7545fd");
//        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        desiredCapabilities.setCapability ("automationName", "uiautomator2");
        desiredCapabilities.setCapability ("appPackage", "com.sec.android.app.popupcalculator");
        desiredCapabilities.setCapability ("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        URL url = new URL ("http://127.0.0.1:4723/wd/hub");

        WebDriver driver;

        driver = new RemoteWebDriver (url,desiredCapabilities);
//        WebDriverWait wait = new WebDriverWait(driver, 5);


        WebElement el1 = driver.findElement (By.id ("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
        el1.click ();

        WebElement el2 = driver.findElement (By.id ("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        el2.click ();
        WebElement el3 = driver.findElement (By.id ("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
        el3.click ();
        WebElement el4 = driver.findElement (By.id ("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
        el4.click ();

        WebElement el5 = driver.findElement (By.id ("com.sec.android.app.popupcalculator:id/calc_edt_formula"));



        System.out.println (el5.getText ());
        Assert.assertEquals ("4",el5.getText ());


        driver.quit ();
    }
}
