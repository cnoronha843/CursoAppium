package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class FormularioPage extends BasePage {

    public void escreverNome(String nome) throws MalformedURLException, InterruptedException {
        escrever (By.className ("android.widget.EditText"),nome);
    }
    public String obterNome() throws MalformedURLException, InterruptedException {
        return obterTexto (MobileBy.xpath ("//android.widget.TextView[starts-with(@text,'Nome:')]")).substring (6);
    }
    public String obterConsole() throws MalformedURLException, InterruptedException {
        return obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Console:')]")).substring (9);
    }
    public String obterCheckBox() throws MalformedURLException, InterruptedException {
        return obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Checkbox:')]")).substring (10);
    }
    public String obterSwitch() throws MalformedURLException, InterruptedException {
        return obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Switch:')]")).substring (8);
    }

    public void salvar() throws MalformedURLException, InterruptedException {
        clicarSalvar ();
    }
    public void selecionarCombo(String valor) throws MalformedURLException, InterruptedException {
        selecionarCombo (MobileBy.className ("android.widget.Spinner"),valor);
    }
    public String obterValorCombo() throws MalformedURLException, InterruptedException {
        return obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Console:')]"));
    }
    public void clicarCheckBox () throws MalformedURLException, InterruptedException {
        clicar (By.className ("android.widget.CheckBox"));
    }
    public boolean resultCheckBox() throws MalformedURLException, InterruptedException {
        return  isCheckMarcado (By.className ("android.widget.CheckBox"));
    }
    public void clicarSwitch () throws MalformedURLException, InterruptedException {
        clicar (By.className ("android.widget.Switch"));
    }
    public boolean resultSwitch() throws MalformedURLException, InterruptedException {
        return isCheckMarcado(By.className ("android.widget.Switch"));
    }

}
