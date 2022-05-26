package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;

import java.net.MalformedURLException;

public class MenuPage extends BasePage {

    public void acessarFormulario() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Formulário");

    }
    public void acessarSplash() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Splash");

    }
    public void acessarAlertas() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Alertas");

    }
}
