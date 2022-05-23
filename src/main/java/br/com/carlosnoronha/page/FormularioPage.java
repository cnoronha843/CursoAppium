package br.com.carlosnoronha.page;

import br.com.carlosnoronha.appium.core.DSL;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.Locale;

public class FormularioPage {
    private DSL dsl = new DSL ();

    public void escreverNome(String nome) throws MalformedURLException, InterruptedException {
        dsl.escrever (By.className ("android.widget.EditText"),nome);
    }
    public String obterNome() throws MalformedURLException, InterruptedException {
        return dsl.obterTexto (MobileBy.xpath ("//android.widget.TextView[starts-with(@text,'Nome:')]")).substring (6);
    }
    public String obterConsole() throws MalformedURLException, InterruptedException {
        return dsl.obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Console:')]")).substring (9);
    }
    public String obterCheckBox() throws MalformedURLException, InterruptedException {
        return dsl.obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Checkbox:')]")).substring (10);
    }
    public String obterSwitch() throws MalformedURLException, InterruptedException {
        return dsl.obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Switch:')]")).substring (8);
    }

    public void salvar() throws MalformedURLException, InterruptedException {
        dsl.clicarSalvar ();
    }
    public void selecionarCombo(String valor) throws MalformedURLException, InterruptedException {
        dsl.selecionarCombo (MobileBy.className ("android.widget.Spinner"),valor);
    }
    public String obterValorCombo() throws MalformedURLException, InterruptedException {
        return dsl.obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Console:')]"));
    }
    public void clicarCheckBox () throws MalformedURLException, InterruptedException {
        dsl.clicar (By.className ("android.widget.CheckBox"));
    }
    public boolean resultCheckBox() throws MalformedURLException, InterruptedException {
        return  dsl.isCheckMarcado (By.className ("android.widget.CheckBox"));
    }
    public void clicarSwitch () throws MalformedURLException, InterruptedException {
        dsl.clicar (By.className ("android.widget.Switch"));
    }
    public boolean resultSwitch() throws MalformedURLException, InterruptedException {
        return dsl.isCheckMarcado(By.className ("android.widget.Switch"));
    }

}
