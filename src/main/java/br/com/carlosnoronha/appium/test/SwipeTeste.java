package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class SwipeTeste extends BaseTest {
    MenuPage menu = new MenuPage ();
    @Test
    public void deveRealizarSwipe() throws MalformedURLException, InterruptedException {
        menu.acessarSwipe ();
        Assert.assertTrue (menu.existeUmElementoPorTexto ("a esquerda"));
        //swipe para direita
        menu.swipeRight ();
        Assert.assertTrue (menu.existeUmElementoPorTexto ("E veja se"));
        menu.clicarPorTexto ("›");
        Assert.assertTrue (menu.existeUmElementoPorTexto ("Chegar até o fim!"));
        menu.swipeLeft ();
        menu.clicarPorTexto ("‹");
        Assert.assertTrue (menu.existeUmElementoPorTexto ("a esquerda"));


    }
}
