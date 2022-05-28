package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.AlertaPage;
import br.com.carlosnoronha.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
public class AlertaTeste extends BaseTest {
    MenuPage menu = new MenuPage ();
    AlertaPage page = new AlertaPage ();

    @Before
    public void setup() throws MalformedURLException, InterruptedException {
        menu.acessarAlertas ();
    }

    @Test
    public void deveConfirmarAlertas() throws MalformedURLException, InterruptedException {
        menu.acessarAlertas ();
        page.clicarAlertaConfirm ();
        Assert.assertEquals ("Info", page.obterTituloAlerta ());
        Assert.assertEquals ("Confirma a operação?", page.obterMenssagemAlerta ());
        page.confirmar ();
        Assert.assertEquals ("Confirmado", page.obterMenssagemAlerta ());
        page.sair ();
    }
    @Test
    public void deveClicarFora() throws MalformedURLException, InterruptedException {
        page.clicarAlertaSimples ();
        //clicar fora da caixa
        Thread.sleep (5000);
        page.clicarForaCaixa ();
        Thread.sleep (3000);

        //verificar se a mensagem não está mais na tela
//        System.out.println (page.obterTextoPorTexto ("Pode clicar no OK ou fora da caixa para sair"));
        Assert.assertFalse ( page.existeUmElementoPorTexto ("Pode clicar no OK ou fora da caixa para sair"));

    }
}
