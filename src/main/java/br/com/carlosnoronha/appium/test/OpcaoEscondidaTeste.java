package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.core.DriverFactory;
import br.com.carlosnoronha.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class OpcaoEscondidaTeste extends BaseTest {
    private MenuPage menu = new MenuPage ();
    @Test
    public void deveEncontrarOpcaoEscondida() throws MalformedURLException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver (),10);//vai checar por 10 segundos
        wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@text='Formulário']")));//vai esperar até que este xpath esteja na tela
        menu.scrollDown ();
        menu.clicarPorTexto ("Opção bem escondida");

        Assert.assertEquals ("Você achou essa opção", menu.obterMenssagemAlerta ());
        menu.clicarBotaoPorTexto ("OK");
    }
}
