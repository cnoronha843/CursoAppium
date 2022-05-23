package br.com.carlosnoronha.page;

import br.com.carlosnoronha.appium.core.DSL;

import java.net.MalformedURLException;

public class MenuPage {
    private DSL dsl = new DSL ();

    public void acessarFormulario() throws MalformedURLException, InterruptedException {
        dsl.clicarFormulario ("Formulário");

    }
}
