package br.com.carlosnoronha;
import br.com.carlosnoronha.appium.core.DSL;
import br.com.carlosnoronha.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;


public class FormularioTeste {

    private DSL dsl = new DSL ();
    @Before
    public void inicializarAppium() throws MalformedURLException, InterruptedException {
        //Selecionar formulario
        dsl.clicarFormulario ("Formulário");
        Thread.sleep (2000);
    }

    @Test
    public void devePreencherCampo () throws InterruptedException, MalformedURLException {
        Thread.sleep (1000);
        //Escrever no formulario
        String valorEntrada = "Carlos André";
        dsl.escrever (By.className ("android.widget.EditText"),valorEntrada);
        //Salvar o que foi escrito
        dsl.clicar (By.className ("android.widget.Button"));
        Thread.sleep (1000);
        //Capturar o texto escrito
        String valorExibido = dsl.obterTexto (MobileBy.xpath ("//android.widget.TextView[starts-with(@text,'Nome:')]")).substring (6);
        //Validar se o valor exibido é igual ao valor salvo
        Assert.assertEquals (valorEntrada,valorExibido);
    }
    @Test
    public void deveInteragirCombo () throws InterruptedException, MalformedURLException {
        Thread.sleep (1000);
        //Clicar no combo
        dsl.selecionarCombo (MobileBy.className ("android.widget.Spinner"),"PS4");
        Thread.sleep (1000);
//                    String opcaoSelecionada = dsl.obterTexto (MobileBy.xpath ("//android.widget.CheckedTextView[@text= 'PS4']"));
        Thread.sleep (1000);
        //Salvar o que foi escrito
        dsl.clicarSalvar ();
        Thread.sleep (1000);
        //Capturar o texto escrito
        String opcaoExibida = dsl.obterTexto (By.xpath ("//android.widget.TextView[@text= 'Console: ps4']"));
        System.out.println (opcaoExibida.substring (9));
        Assert.assertEquals ("ps4",opcaoExibida.substring (9));
    }
    @Test
    public void deveInteragirSwitchCheckBox () throws InterruptedException, MalformedURLException {
        Thread.sleep (2000);
        Assert.assertFalse (dsl.isCheckMarcado (By.className ("android.widget.CheckBox")));
        Assert.assertTrue (dsl.isCheckMarcado (By.className ("android.widget.Switch")));
        Thread.sleep (1000);
        dsl.clicar (By.className ("android.widget.CheckBox"));
        dsl.clicar (By.className ("android.widget.Switch"));
        Assert.assertTrue (dsl.isCheckMarcado (By.className ("android.widget.CheckBox")));
        Assert.assertFalse (dsl.isCheckMarcado (By.className ("android.widget.Switch")));

    }
    @Test
    public void preencherTodoFormulario () throws InterruptedException, MalformedURLException {

        String valorEntrada = "Carlos André";
        dsl.escrever (By.className ("android.widget.EditText"),valorEntrada);
        dsl.selecionarCombo (MobileBy.className ("android.widget.Spinner"),"PS4");
        Thread.sleep (1000);
        dsl.clicar (By.className ("android.widget.CheckBox"));
        dsl.clicar (By.className ("android.widget.Switch"));
        Thread.sleep (1000);
        dsl.clicarSalvar ();
        Thread.sleep (1000);
        String nomeExibido = dsl.obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Nome:')]")).substring (6);
        String consoleExibido = dsl.obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Console:')]")).substring (9);
        String switchExibido = dsl.obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Switch:')]")).substring (8);
        String checkBoxExibido = dsl.obterTexto (By.xpath ("//android.widget.TextView[starts-with(@text,'Checkbox:')]")).substring (10);
        Assert.assertEquals (valorEntrada,nomeExibido);
        Assert.assertEquals ("ps4",consoleExibido);
        Assert.assertEquals ("Off",switchExibido);
        Assert.assertEquals ("Marcado",checkBoxExibido);
    }

    @After
    public void fecharApp(){
        DriverFactory.killDriver ();
    }

}
