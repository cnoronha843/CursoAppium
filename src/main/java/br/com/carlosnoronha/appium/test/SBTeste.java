package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.MenuPage;
import br.com.carlosnoronha.appium.page.SBLoginPage;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class SBTeste extends BaseTest {

    MenuPage menu = new MenuPage ();
    SBLoginPage login = new SBLoginPage ();

    @Before
    public void setup() throws MalformedURLException, InterruptedException {
        menu.acessarSBNativo ();
        login.setEmail ("carlos@carlos.com");
        login.setSenha ("123");
        login.entrar ();

    }
    @Test
    public void test(){}


}
