package br.com.carlosnoronha.test;
import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.page.FormularioPage;
import br.com.carlosnoronha.page.MenuPage;
import org.junit.*;

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
        Thread.sleep (1000);
        //Escrever no formulario
        String valorEntrada = "Carlos André";
        page.escreverNome (valorEntrada);
        //Salvar o que foi escrito
        Thread.sleep (1000);
        page.salvar ();
        Thread.sleep (1000);
        //Capturar o texto escrito
        String valorExibido = page.obterNome ();
        //Validar se o valor exibido é igual ao valor salvo
        Assert.assertEquals (valorEntrada,valorExibido);
    }
    @Test
    public void deveInteragirCombo () throws InterruptedException, MalformedURLException {
        Thread.sleep (1000);
        //Clicar no combo
        page.selecionarCombo ("PS4");
        Thread.sleep (1000);
        page.salvar ();
        Thread.sleep (1000);
        String opcaoExibida = page.obterValorCombo ();
        System.out.println (opcaoExibida.substring (9));
        Assert.assertEquals ("ps4",opcaoExibida.substring (9));
    }
    @Test
    public void deveInteragirSwitchCheckBox () throws InterruptedException, MalformedURLException {
        Thread.sleep (2000);
        Assert.assertFalse (page.resultCheckBox ());
        Assert.assertTrue (page.resultSwitch ());
        page.clicarCheckBox ();
        page.clicarSwitch ();
        Thread.sleep (1000);
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
        Thread.sleep (1000);
        String nomeExibido = page.obterNome ();
        String consoleExibido = page.obterConsole ();
        String switchExibido = page.obterSwitch ();
        String checkBoxExibido = page.obterCheckBox ();
        Assert.assertEquals (valorEntrada,nomeExibido);
        Assert.assertEquals ("ps4",consoleExibido);
        Assert.assertEquals ("Off",switchExibido);
        Assert.assertEquals ("Marcado",checkBoxExibido);
    }



}
