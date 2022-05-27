package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class AbasPage extends BasePage {
    public String obterTextoAba(String texto) throws MalformedURLException, InterruptedException {
        return obterTexto (By.xpath ("//android.widget.TextView[@text= '"+texto+"']"));
    }
    public void clicarAba2() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("Aba 2");
    }


}
