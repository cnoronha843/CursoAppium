package br.com.carlosnoronha.appium.core;




import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    @Rule
    public TestName testName = new TestName ();

    @AfterClass
    public static void finalizarClasse(){
                DriverFactory.killDriver ();
    }

    @After
    public void fecharApp() throws IOException, InterruptedException {
        gerarScreenShot ();
        DriverFactory.getDriver ().resetApp ();

    }
    public void gerarScreenShot() throws IOException, InterruptedException {
        File imagem = ((TakesScreenshot)  DriverFactory.getDriver ()).getScreenshotAs (OutputType.FILE);
        FileUtils.copyFile  ( imagem,new File ("target/screenshots/"+testName.getMethodName ()+".png"));
    }
}
