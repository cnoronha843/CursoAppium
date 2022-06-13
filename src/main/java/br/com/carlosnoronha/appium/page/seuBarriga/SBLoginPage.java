package br.com.carlosnoronha.appium.page.seuBarriga;

import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBLoginPage extends BasePage {
    public void setEmail(String email) throws MalformedURLException, InterruptedException {
        escrever (By.className ("android.widget.EditText"), email);
    }
    public void setSenha(String senha) throws MalformedURLException, InterruptedException {
        escrever (By.xpath ("//android.widget.EditText[2]"), senha);

    }
    public void entrar() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("ENTRAR");
    }

}
