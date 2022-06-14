package br.com.carlosnoronha.appium.page.seuBarriga;

import br.com.carlosnoronha.appium.core.BasePage;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static br.com.carlosnoronha.appium.core.DriverFactory.getDriver;

public class SBResumoPage extends BasePage {
    public void selecionarMovimentacao(String opcao) throws MalformedURLException, InterruptedException {
        swipeElement (getDriver ().findElement (By.xpath ("//*[@text='"+opcao+"']/..")),0.9,0.1);

    }
    public void deletarMovimentacao(String opcao) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (By.xpath ("//*[@text='"+opcao+"']/..")).click ();
    }
}
