package br.com.carlosnoronha.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import static br.com.carlosnoronha.appium.core.DriverFactory.getDriver;

public class BasePage {

    public void escrever (By by, String texto) throws MalformedURLException, InterruptedException {
        getDriver ().
                findElement (by).sendKeys (texto);
    }
    public String obterTexto(By by) throws MalformedURLException, InterruptedException {

        return getDriver ().findElement (by).getText ();

    }
    public void selecionarCombo(By by, String valor) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (by).click ();
//            DriverFactory.getDiver ().findElement (MobileBy.className ("android.widget.Spinner")).click ();
        //selecionar opção desejada
        clicarPorTexto (valor);
    }
    public void clicarFormulario(String texto) throws MalformedURLException, InterruptedException {
//        Thread.sleep (1000);
        getDriver ().findElement (By.xpath ("//android.widget.TextView[@text= '"+texto+"']")).click ();

    }
    public void clicarPorChecked(String texto) throws MalformedURLException, InterruptedException {
//        Thread.sleep (1000);
        getDriver ().findElement (By.xpath ("//android.widget.CheckedTextView[@text= '"+texto+"']")).click ();

    }
    public void clicarBotaoPorTexto(String texto) throws MalformedURLException, InterruptedException {
//        Thread.sleep (1000);
        getDriver ().findElement (By.xpath ("//android.widget.Button[@text= '"+texto+"']")).click ();

    }
    public void clicarPorTexto(String texto) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (By.xpath ("//android.widget.TextView[@text= '"+texto+"']")).click ();
    }
    public void clicarPorTextoView(String texto) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (By.xpath ("//android.view.View[@text= '"+texto+"']")).click ();
    }
    public void clicarPorTextoButton(String texto) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (By.xpath ("//android.view.Button[@text= '"+texto+"']")).click ();
    }
    public void clicarPorId(String texto) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (By.id (texto)).click ();
    }
    public void clicarSalvar() throws MalformedURLException, InterruptedException {
//        Thread.sleep (1000);
        getDriver ().findElement (By.xpath ("//android.widget.TextView[@text= 'SALVAR']")).click ();

    }
    public boolean isCheckMarcado(By by) throws MalformedURLException, InterruptedException {
        return getDriver ().findElement (by).getAttribute ("checked").equals ("true");
    }
    public void clicar(By by) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (by).click ();
    }
    public boolean existeUmElementoPorTexto(String texto) throws MalformedURLException, InterruptedException {
        List<AndroidElement> elementos = getDriver ().findElements (By.xpath ("//*[@text='" + texto + "']"));
        return elementos.size () > 0;
    }
    public void tap (Integer x, Integer y) throws MalformedURLException, InterruptedException {
        new TouchAction (DriverFactory.getDriver ()).longPress  (PointOption.point (x,y) ).perform ();
    }

    public String obterTextoPorTexto(String texto) throws MalformedURLException, InterruptedException {

        return getDriver ().findElement (By.xpath ("//android.view.View[@text= '"+texto+"']")).getText ();

    }
    public String obterMenssagemAlerta() throws MalformedURLException, InterruptedException {
        return obterTexto (By.id ("android:id/message"));
    }


    public void scroll(double inicio, double fim) throws MalformedURLException, InterruptedException {
        //pegar o tamanho da tela
        Dimension size = getDriver ().manage ().window ().getSize ();
        //Denifinir x
        int x = size.width / 2;
        //Definir Y inicial
        int start_y = (int) (size.height * inicio);
        //Definir Y final
        int end_y = (int) (size.height * fim);
        //pressionar um ponto da tela
        new TouchAction (getDriver ())
                .press (PointOption.point (x,start_y))//segura neste ponto da tela
                .waitAction (WaitOptions.waitOptions (Duration.ofMillis (500)))// espera por 500 milisegundos
                .moveTo (PointOption.point (x,end_y))//arrasta até este ponto
                .release ()//solta a tela
                .perform ();

    }
}
