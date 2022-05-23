package br.com.carlosnoronha.appium.core;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static br.com.carlosnoronha.appium.core.DriverFactory.getDiver;

public class BasePage {

    public void escrever (By by, String texto) throws MalformedURLException, InterruptedException {
        getDiver().
                findElement (by).sendKeys (texto);
    }
    public String obterTexto(By by) throws MalformedURLException, InterruptedException {

        return getDiver ().findElement (by).getText ();

    }
    public void selecionarCombo(By by, String valor) throws MalformedURLException, InterruptedException {
        getDiver ().findElement (by).click ();
//            DriverFactory.getDiver ().findElement (MobileBy.className ("android.widget.Spinner")).click ();
        //selecionar opção desejada
        clicarPorTexto (valor);
    }

    public void clicarFormulario(String texto) throws MalformedURLException, InterruptedException {
        Thread.sleep (1000);
        getDiver ().findElement (By.xpath ("//android.widget.TextView[@text= '"+texto+"']")).click ();

    }

    public void clicarPorTexto(String texto) throws MalformedURLException, InterruptedException {
        Thread.sleep (1000);
        getDiver ().findElement (By.xpath ("//android.widget.CheckedTextView[@text= '"+texto+"']")).click ();

    }
    public void clicarSalvar() throws MalformedURLException, InterruptedException {
        Thread.sleep (1000);
        getDiver ().findElement (By.xpath ("//android.widget.TextView[@text= 'SALVAR']")).click ();

    }
    public boolean isCheckMarcado(By by) throws MalformedURLException, InterruptedException {
        return getDiver ().findElement (by).getAttribute ("checked").equals ("true");
    }
    public void clicar(By by) throws MalformedURLException, InterruptedException {
        getDiver ().findElement (by).click ();
    }
}
