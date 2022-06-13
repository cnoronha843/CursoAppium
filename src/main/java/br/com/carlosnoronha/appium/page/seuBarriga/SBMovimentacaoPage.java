package br.com.carlosnoronha.appium.page.seuBarriga;

import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBMovimentacaoPage extends BasePage {
    public void salvar() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("SALVAR");
    }
    public void setDescricao(String desc) throws MalformedURLException, InterruptedException {
        escrever (By.className ("android.widget.EditText"),desc);
    }
    public void setInteressado(String interessado) throws MalformedURLException, InterruptedException {
        escrever (By.xpath ("//android.widget.EditText[2]"),interessado);

    }
    public void setValor(String valor) throws MalformedURLException, InterruptedException {
        escrever (By.xpath ("//android.widget.EditText[3]"),valor);

    }
    public void setConta(String conta) throws MalformedURLException, InterruptedException {
        clicar (By.xpath ("//android.widget.Spinner[2]"));
        clicar (By.xpath ("//android.widget.CheckedTextView[@text= '"+conta+"']"));

    }

}
