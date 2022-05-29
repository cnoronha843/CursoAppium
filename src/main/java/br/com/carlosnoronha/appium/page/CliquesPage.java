package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import br.com.carlosnoronha.appium.core.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;

import static br.com.carlosnoronha.appium.core.DriverFactory.*;

public class CliquesPage extends BasePage {
    public void cliqueLongo() throws MalformedURLException, InterruptedException {
        AndroidElement  element = getDriver ().findElement (By.xpath ("//*[@text= 'Clique Longo']"));
        new TouchAction (getDriver ())
                .longPress (LongPressOptions.longPressOptions().withElement (ElementOption.element (element)))
                .perform ();

    }
    public String obterTextoCampo() throws MalformedURLException, InterruptedException {
        return getDriver ().findElement (By.xpath ("(//android.widget.TextView)[3]")).getText ();
    }
}
