package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.MenuPage;
import br.com.carlosnoronha.appium.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class WebViewTeste extends BaseTest {

    private MenuPage menu = new MenuPage ();
    private WebViewPage page = new WebViewPage ();

    @Test
    public void deveFazerLogin() throws MalformedURLException, InterruptedException {
        menu.acessarSBHibrido ();
        Thread.sleep (3000);
        page.entrarContextoWeb ();
        Thread.sleep (3000);
        page.setEmail ("carlos@carlos.com");
        page.setSenha("123");
        Thread.sleep (3000);
        page.entrarWebView ();
        Assert.assertEquals ("Bem vindo, Carlos!",page.getMensagem ());
        Thread.sleep (3000);



    }

    @After
    public void tearDown() throws MalformedURLException, InterruptedException {
        page.sairContextoWeb ();

    }

}
