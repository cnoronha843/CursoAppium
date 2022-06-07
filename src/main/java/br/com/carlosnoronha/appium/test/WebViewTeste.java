package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.MenuPage;
import br.com.carlosnoronha.appium.page.WebViewPage;
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
        page.setEmail ("carlos@carlos.com");

    }

}
