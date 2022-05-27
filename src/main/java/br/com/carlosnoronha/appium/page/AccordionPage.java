package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class AccordionPage extends BasePage {

    public void clicarOp1() throws MalformedURLException, InterruptedException {
        clicarPorTexto ("Opção 1");
    }
    public String obterValorOp1() throws MalformedURLException, InterruptedException {
       return obterTexto (By.xpath ("//*[@text='Esta é a descrição da opção 1']"));
//       return obterTexto (By.xpath ("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }


}
