package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import br.com.carlosnoronha.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;

import static br.com.carlosnoronha.appium.core.DriverFactory.*;

public class SwipeListPage extends BasePage {
    public void swipeElementLeft(String opcao) throws MalformedURLException, InterruptedException {
        swipeElement (getDriver ().findElement (By.xpath ("//*[@text='"+opcao+"']/..")),0.1,0.9);
    }
    public void swipeElementRight(String opcao) throws MalformedURLException, InterruptedException {
        swipeElement (getDriver ().findElement (By.xpath ("//*[@text='"+opcao+"']/..")),0.9,0.1);
    }
    public void clicarBotaoMais() throws MalformedURLException, InterruptedException {
//        MobileElement botao = getDriver ().findElement (By.xpath ("//*[@text='(+)']/.."));

        new TouchAction (getDriver ())
                .tap (PointOption.point (799,204))
                .perform ();


    }
}
