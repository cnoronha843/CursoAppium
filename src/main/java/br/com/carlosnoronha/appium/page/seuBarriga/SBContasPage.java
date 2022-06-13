package br.com.carlosnoronha.appium.page.seuBarriga;

import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBContasPage extends BasePage {
    public void setContas(String nome) throws MalformedURLException, InterruptedException {
        escrever (By.className ("android.widget.EditText"), nome);
    }
    public void salvar() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("SALVAR");
    }
    public void excluir() throws MalformedURLException, InterruptedException {
        tap (960,134);
    }
    public void selecionarContas ( String conta) throws MalformedURLException, InterruptedException {
        cliqueLongo (By.xpath ("//*[@text= '"+conta+"']"));
    }


}
