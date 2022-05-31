package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.MenuPage;
import br.com.carlosnoronha.appium.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class SwipeElementTeste extends BaseTest {
    private MenuPage menu = new MenuPage ();
    private SwipeListPage page = new SwipeListPage ();
    @Test
    public void deveresolverDesafio() throws MalformedURLException, InterruptedException {
        menu.clicarSwipeList();
        page.swipeElementRight ("Opção 1");
        page.clicarBotaoMais ();
        Assert.assertTrue (page.existeUmElementoPorTexto ("Opção 1 (+)"));
        page.swipeElementRight ("Opção 4");
        page.clicarPorTexto ("(-)");
        Assert.assertTrue (page.existeUmElementoPorTexto ("Opção 4 (-)"));
        page.swipeElementLeft ("Opção 5 (-)");
        Assert.assertTrue (page.existeUmElementoPorTexto ("Opção 5"));

    }
}

