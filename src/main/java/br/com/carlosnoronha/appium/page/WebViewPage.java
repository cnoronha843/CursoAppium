package br.com.carlosnoronha.appium.page;
import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.util.Set;

import static br.com.carlosnoronha.appium.core.DriverFactory.*;

public class WebViewPage extends BasePage {
    public void entrarContextoWeb() throws MalformedURLException, InterruptedException {


            Set<String> contextHandles = getDriver ().getContextHandles ();
//            for (String valor : contextHandles){
//                System.out.println (valor);
//            }
            getDriver ().context ((String) contextHandles.toArray ()[1]);






    }

    public void setEmail(String valor ) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (By.xpath ("//input[@type='email']")).sendKeys (valor);
    }

    public void setSenha(String valor) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (By.xpath ("//input[@type='password']")).sendKeys (valor);
    }

    public String getMensagem() throws MalformedURLException, InterruptedException {
        return obterTexto (By.xpath ("//div[@class='alert alert-success']"));
    }
    public void entrarWebView() throws MalformedURLException, InterruptedException {
        clicar (By.xpath ("//button[@type='submit']"));
    }

    public void sairContextoWeb() throws MalformedURLException, InterruptedException {
        getDriver ().context ((String) getDriver ().getContextHandles ().toArray ()[0]);
    }
}
