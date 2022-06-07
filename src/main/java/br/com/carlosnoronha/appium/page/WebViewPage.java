package br.com.carlosnoronha.appium.page;
import br.com.carlosnoronha.appium.core.BasePage;
import org.openqa.selenium.By;
import java.net.MalformedURLException;
import java.util.Set;

import static br.com.carlosnoronha.appium.core.DriverFactory.*;

public class WebViewPage extends BasePage {
    public void entrarContextoWeb()  {
        try {

            Set<String> contextHandles = getDriver ().getContextHandles ();
            for (String valor : contextHandles){
                System.out.println (valor);
            }
            getDriver ().context ((String) contextHandles.toArray ()[1]);
        }catch (InterruptedException | MalformedURLException e){
            e.printStackTrace ();
        }





    }

    public void setEmail(String valor ) throws MalformedURLException, InterruptedException {
        getDriver ().findElement (By.id ("email"));
    }

}
