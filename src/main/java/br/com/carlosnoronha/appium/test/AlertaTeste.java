package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.AlertaPage;
import br.com.carlosnoronha.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import java.net.MalformedURLException;
public class AlertaTeste extends BaseTest {
    MenuPage menu = new MenuPage ();
    AlertaPage page = new AlertaPage ();
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
}
