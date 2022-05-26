package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static br.com.carlosnoronha.appium.core.DriverFactory.getDriver;

public class SplashPage extends BasePage {
    public boolean isTelaSplashVisivel() throws MalformedURLException, InterruptedException {
        return existeUmElementoPorTexto ("Splash!");
    }
    public void aguardarSplashSumir() throws MalformedURLException, InterruptedException {
        getDriver().manage ().timeouts ().implicitlyWait (0, TimeUnit.SECONDS);
        WebDriverWait wait =new WebDriverWait (getDriver (),10);
        wait.until (ExpectedConditions.invisibilityOfElementLocated(By.xpath ("//*[@text='Splash!']")));

    }
}
