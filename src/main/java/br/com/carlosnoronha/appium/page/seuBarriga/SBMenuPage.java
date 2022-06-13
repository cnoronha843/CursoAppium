package br.com.carlosnoronha.appium.page.seuBarriga;

import br.com.carlosnoronha.appium.core.BasePage;

import java.net.MalformedURLException;

public class SBMenuPage extends BasePage {
    public void acessarContas() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("Contas");
    }

    public void acessarMovimentacoes() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("Mov...");

    }
}
