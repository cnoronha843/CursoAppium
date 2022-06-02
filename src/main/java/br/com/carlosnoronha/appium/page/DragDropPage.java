package br.com.carlosnoronha.appium.page;

import br.com.carlosnoronha.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.util.List;

import static br.com.carlosnoronha.appium.core.DriverFactory.getDriver;

public class DragDropPage extends BasePage {
    public void arrastar(String origem, String destino) throws MalformedURLException, InterruptedException {
        AndroidElement inicio = getDriver ().findElement (By.xpath ("//*[@text='"+origem+"']"));
        AndroidElement fim = getDriver ().findElement (By.xpath ("//*[@text='"+destino+"']"));
        new TouchAction (getDriver ())
                .longPress (new ElementOption ().withElement(inicio))
                .moveTo (new ElementOption().withElement(fim))
                .release ()
                .perform ();

    }
    public String[] obterLista() throws MalformedURLException, InterruptedException {
        List<AndroidElement> element = getDriver ().findElements (By.className ("android.widget.TextView"));
        String[] retorno = new String[element.size ()];
        for (int i = 0; i< element.size (); i++){
            retorno[i] = element.get (i).getText ();
            System.out.print ("\""+retorno[i] +"\",");
        }
        return retorno;
    }
}
