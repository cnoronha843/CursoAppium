package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import br.com.carlosnoronha.appium.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class MenuPage extends BasePage {

    public void acessarFormulario() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Formulário");

    }
    public void acessarSBNativo() throws MalformedURLException, InterruptedException {
        clicarFormulario ("SeuBarriga Nativo");

    }
    public void acessarSplash() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Splash");

    }
    public void acessarAlertas() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Alertas");

    }
    public void acessarAbas() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Abas");

    }
    public void acessarAccordion() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Accordion");
    }
    public void acessarCliques() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Cliques");
    }
    public void acessarSwipe() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Swipe");
    }

    public void clicarSwipeList() throws MalformedURLException, InterruptedException {
        clicarFormulario ("Swipe List");
    }
    public void acessarSBHibrido() throws MalformedURLException, InterruptedException {
        clicarFormulario ("SeuBarriga Híbrido");
    }
    public void clicarDragNDrop() throws MalformedURLException, InterruptedException {
        WebDriverWait wait = new WebDriverWait (DriverFactory.getDriver (),10);
        wait.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@text='Formulário']")));
        scrollDown ();
        clicarFormulario ("Drag and drop");
    }


}
