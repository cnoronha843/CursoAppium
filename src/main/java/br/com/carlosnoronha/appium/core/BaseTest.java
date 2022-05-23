package br.com.carlosnoronha.appium.core;

import org.junit.After;

public class BaseTest {
    @After
    public void fecharApp(){
        DriverFactory.killDriver ();
    }
}
