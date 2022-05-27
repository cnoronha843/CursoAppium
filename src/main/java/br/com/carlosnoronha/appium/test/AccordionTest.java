package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.page.AccordionPage;
import br.com.carlosnoronha.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class AccordionTest {
    MenuPage menu = new MenuPage ();
    AccordionPage page = new AccordionPage ();
    @Test
    public void deveInteragirComAccordion() throws MalformedURLException, InterruptedException {
        //acessar menu
        menu.acessarAccordion ();
        //clicar op1
        page.clicarOp1 ();
        //verficar texto op1
        Thread.sleep (2000);
        Assert.assertEquals ("Esta é a descrição da opção 1", page.obterValorOp1 ());
    }

}
