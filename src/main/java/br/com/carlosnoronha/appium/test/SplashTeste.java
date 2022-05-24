package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.MenuPage;
import br.com.carlosnoronha.appium.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class SplashTeste extends BaseTest {
private MenuPage menu = new MenuPage ();
private SplashPage page = new SplashPage ();
    @Test
    public void deveAguardarSplashSumir() throws MalformedURLException, InterruptedException {
        //acessar menu splash
        menu.acessarSplash ();
        page.isTelaSplashVisivel ();
        page.aguardarSplashSumir();
        Assert.assertTrue (page.existeUmElementoPorTexto ("Formulário"));


    }
}
