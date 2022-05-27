package br.com.carlosnoronha.appium.test;
import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.FormularioPage;
import br.com.carlosnoronha.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;


public class FormularioTeste extends BaseTest {

    private MenuPage menu = new MenuPage ();
    private FormularioPage page = new FormularioPage ();
    @Before
    public void inicializarAppium() throws MalformedURLException, InterruptedException {
        //Selecionar formulario
        menu.acessarFormulario ();
        Thread.sleep (2000);
    }

    @Test
    public void devePreencherCampo () throws InterruptedException, MalformedURLException {
        //Escrever no formulario
        String valorEntrada = "Carlos André";
        page.escreverNome (valorEntrada);
        //Salvar o que foi escrito
//        Thread.sleep (1000);
        page.salvar ();
//        Thread.sleep (1000);
        //Capturar o texto escrito
        String valorExibido = page.obterNome ();
        //Validar se o valor exibido é igual ao valor salvo
        Assert.assertEquals (valorEntrada,valorExibido);
    }
    @Test
    public void deveInteragirCombo () throws InterruptedException, MalformedURLException {
        //Clicar no combo
        page.selecionarCombo ("PS4");
//        Thread.sleep (1000);
        page.salvar ();
//        Thread.sleep (1000);
        String opcaoExibida = page.obterValorCombo ();
        System.out.println (opcaoExibida.substring (9));
        Assert.assertEquals ("ps4",opcaoExibida.substring (9));
    }
    @Test
    public void deveInteragirSwitchCheckBox () throws InterruptedException, MalformedURLException {
        Assert.assertFalse (page.resultCheckBox ());
        Assert.assertTrue (page.resultSwitch ());
        page.clicarCheckBox ();
        page.clicarSwitch ();
//        Thread.sleep (1000);
        Assert.assertTrue (page.resultCheckBox ());
        Assert.assertFalse (page.resultSwitch ());

    }
    @Test
    public void preencherTodoFormulario () throws InterruptedException, MalformedURLException {

        String valorEntrada = "Carlos André";
        page.escreverNome (valorEntrada);
        page.clicarSwitch ();
        page.clicarCheckBox ();
        page.selecionarCombo ("PS4");
        page.salvar ();
//        Thread.sleep (1000);
        String nomeExibido = page.obterNome ();
        String consoleExibido = page.obterConsole ();
        String switchExibido = page.obterSwitch ();
        String checkBoxExibido = page.obterCheckBox ();
        Assert.assertEquals (valorEntrada,nomeExibido);
        Assert.assertEquals ("ps4",consoleExibido);
        Assert.assertEquals ("Off",switchExibido);
        Assert.assertEquals ("Marcado",checkBoxExibido);
    }
    @Test
    public void deveAlterarData() throws MalformedURLException, InterruptedException {
        page.clicarPorTexto ("01/01/2000");
        page.clicarPorTextoView ("7");
        page.clicarPorId ("android:id/button1");
        Assert.assertTrue (page.existeUmElementoPorTexto ("07/01/2000"));

    }
    @Test
    public void deveAlterarTime() throws MalformedURLException, InterruptedException {
        page.clicarPorTexto ("12:00");
        page.clicar (MobileBy.AccessibilityId ("10"));
        page.clicar (MobileBy.AccessibilityId ("40"));
        page.clicarPorId ("android:id/button1");
        Assert.assertTrue (page.existeUmElementoPorTexto ("10:40"));

    }

}
