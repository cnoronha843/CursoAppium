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
    public void acessarAbas() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Abas");

    }
    public void acessarAccordion() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Accordion");
    }
    public void acessarCliques() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Cliques");
    }
    public void acessarSwipe() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Swipe");

    }

    public void clicarSwipeList() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Swipe List");
    }
}
