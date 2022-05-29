package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.CliquesPage;
import br.com.carlosnoronha.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class CliquesTeste extends BaseTest {
    private MenuPage menu = new MenuPage ();
    private CliquesPage page = new CliquesPage ();
    @Test
    public void deveRealizarCliqueLongo() throws MalformedURLException, InterruptedException {
        menu.acessarCliques ();
        Thread.sleep (1000);
        page.cliqueLongo ();
        Thread.sleep (1000);
        Assert.assertEquals ("Clique Longo", page.obterTextoCampo ());
        Thread.sleep (1000);
//



    }
}
