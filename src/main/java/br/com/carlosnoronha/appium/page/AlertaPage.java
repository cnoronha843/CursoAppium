package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class AlertaPage extends BasePage {


    public void  clicarAlertaConfirm() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("ALERTA CONFIRM");
    }
    public void  clicarAlertaSimples() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("ALERTA SIMPLES");
    }
    public void  clicarAlertaRestritivo() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("ALERTA RESTRITIVO");
    }
    public String obterTituloAlerta() throws MalformedURLException, InterruptedException {
        return obterTexto (By.id ("android:id/alertTitle"));
    }
    public String obterMenssagemAlerta() throws MalformedURLException, InterruptedException {
        return obterTexto (By.id ("android:id/message"));
    }
    public void confirmar() throws MalformedURLException, InterruptedException {
         clicarBotaoPorTexto ("CONFIRMAR");
    }
    public void sair() throws MalformedURLException, InterruptedException {
        clicarBotaoPorTexto ("SAIR");
    }
    public void clicarForaCaixa() throws MalformedURLException, InterruptedException {
        tap (890,1302);
    }

}
