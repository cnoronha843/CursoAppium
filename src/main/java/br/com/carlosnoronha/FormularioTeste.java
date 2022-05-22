package br.com.carlosnoronha;
import br.com.carlosnoronha.appium.core.DriverFactory;
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


public class FormularioTeste {
               public static AndroidDriver<AndroidElement> driver;
                @Before
                public void inicializarAppium() throws MalformedURLException, InterruptedException {
                    driver = DriverFactory.getDiver ();
                    //Selecionar formulario
                    MobileElement formulario = driver.findElement (By.xpath ("//android.widget.TextView[@text= 'Formulário']"));
                    formulario.click ();
                    Thread.sleep (1000);
                }

                @Test
                public void devePreencherCampo () throws InterruptedException {
                    Thread.sleep (1000);

                    //Escrever no formulario
                    MobileElement el2 = driver.findElement (By.className ("android.widget.EditText"));
                el2.sendKeys ("Carlos André");
                String valorEntrada = el2.getText ();
                //Salvar o que foi escrito
                    MobileElement el3 = driver.findElement (By.className ("android.widget.Button"));
                el3.click ();
                    Thread.sleep (1000);

                    //Capturar o texto escrito
                    MobileElement el4 = driver.findElement (By.xpath ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]"));
                //Validar se o valor exibido é igual ao valor salvo
                String valorExibido = el4.getText ();
                Assert.assertEquals (valorEntrada,valorExibido.substring (6));

            }
                @Test
                public void deveInteragirCombo () throws  InterruptedException {
                    Thread.sleep (1000);
                    //Clicar no combo
                    MobileElement el2 = driver.findElement (By.className ("android.widget.Spinner"));
                    el2.click ();
                    Thread.sleep (1000);

                    //Selecionar opcao desejada
                    MobileElement el3 = driver.findElement (By.xpath ("//android.widget.CheckedTextView[@text= 'PS4']"));
                    String opcaoSelecionada = el3.getText ().toLowerCase(Locale.ROOT);
                    el3.click ();
                    Thread.sleep (1000);

                    //Salvar o que foi escrito
                    MobileElement el4 = driver.findElement (By.xpath ("//android.widget.TextView[@text= 'SALVAR']"));
                    el4.click ();
                    Thread.sleep (1000);
                    //Capturar o texto escrito
                    MobileElement el5 = driver.findElement (By.xpath ("//android.widget.TextView[@text= 'Console: ps4']"));
                    String opcaoExibida = el5.getText ();
                    System.out.println (opcaoExibida.substring (9));
                    Assert.assertEquals (opcaoSelecionada,opcaoExibida.substring (9));
    }
                @Test
                public void deveInteragirSwitchCheckBox () throws InterruptedException {
                    //Selecionar Limpar formulario
                    MobileElement el1 = driver.findElement (By.xpath ("//android.widget.TextView[@text= 'LIMPAR']"));
                    el1.click ();
                    Thread.sleep (2000);
                    //Verificar status dos elementos
                    MobileElement botaoSwitch = driver.findElement (By.className ("android.widget.Switch"));
                    MobileElement checkBox = driver.findElement (By.className ("android.widget.CheckBox"));
                    if (botaoSwitch.getAttribute ("checked").equals ("true") && checkBox.getAttribute ("checked").equals ("false")){
            //            //Clicar nos elementos
                        checkBox.click ();
                    botaoSwitch.click ();

            //            //Capturar o que foi alterado
            //            //Validar se o valor exibido é igual ao valor salvo
                        if (botaoSwitch.getAttribute ("checked").equals ("false")  && checkBox.getAttribute ("checked").equals ("true")  ){
                            Assert.assertTrue (true);
                        }
                    }
                }
                @Test
                public void preencherTodoFormulario () throws InterruptedException {
                    //Selecionar Limpar formulario
                    MobileElement el1 = driver.findElement (By.xpath ("//android.widget.TextView[@text= 'LIMPAR']"));
                    el1.click ();
                    MobileElement nome = driver.findElement (By.xpath ("//android.widget.EditText[@text='Nome']"));
                    String nomeInserido = "Carlos André";
                    nome.sendKeys (nomeInserido);
                    MobileElement comboBox = driver.findElement (By.className ("android.widget.Spinner"));
                    comboBox.click ();
                    Thread.sleep (1000);
                    MobileElement ps4 = driver.findElement (By.xpath ("//android.widget.CheckedTextView[@text='PS4']"));
                    ps4.click ();
                    MobileElement checkBox = driver.findElement (By.className ("android.widget.CheckBox"));
                    checkBox.click ();
                    MobileElement clickSwitch = driver.findElement (By.className ("android.widget.Switch"));
                    clickSwitch.click ();
                    MobileElement salvar = driver.findElement (By.xpath ("//android.widget.Button[@text='']"));
                    salvar.click ();
                    Thread.sleep (1000);
                    String nomeExibido = driver.findElement (By.xpath ("//android.widget.TextView[starts-with(@text,'Nome:')]")).getText ().substring (6);
                    String consoleExibido = driver.findElement (By.xpath ("//android.widget.TextView[starts-with(@text,'Console:')]")).getText ().substring (9);
                    String switchExibido = driver.findElement (By.xpath ("//android.widget.TextView[starts-with(@text,'Switch:')]")).getText ().substring (8);
                    String checkBoxExibido = driver.findElement (By.xpath ("//android.widget.TextView[starts-with(@text,'Checkbox:')]")).getText ().substring (10);
                    System.out.println (nomeExibido);
                    System.out.println (consoleExibido);
                    System.out.println (switchExibido);
                    System.out.println (checkBoxExibido);
                    Assert.assertEquals (nomeInserido,nomeExibido);
                    Assert.assertEquals ("ps4",consoleExibido);
                    Assert.assertEquals ("Off",switchExibido);
                    Assert.assertEquals ("Marcado",checkBoxExibido);



                }

                @After
                public void fecharApp(){
                    DriverFactory.killDriver ();
                }

}
