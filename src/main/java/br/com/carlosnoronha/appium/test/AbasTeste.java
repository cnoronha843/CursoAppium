package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.page.AbasPage;
import br.com.carlosnoronha.appium.page.AlertaPage;
import br.com.carlosnoronha.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.net.MalformedURLException;

public class AbasTeste {
    MenuPage menu = new MenuPage ();
    AbasPage page = new AbasPage ();

    @Test
    public void deveNavegarNasAbas() throws MalformedURLException, InterruptedException {
//        Acessar o menu de abas
        menu.acessarAbas ();
//        validar o texto da aba 1
        Assert.assertEquals ("Este é o conteúdo da Aba 1",page.obterTextoAba ("Este é o conteúdo da Aba 1"));
//        clicar na aba 2
        page.clicarAba2 ();
//        validar o texto da aba2
        Assert.assertEquals ("Este é o conteúdo da Aba 2",page.obterTextoAba ("Este é o conteúdo da Aba 2"));

    }

}
