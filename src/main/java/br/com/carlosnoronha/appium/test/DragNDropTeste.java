package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.DragDropPage;
import br.com.carlosnoronha.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class DragNDropTeste extends BaseTest {
        private MenuPage menu = new MenuPage ();
        private DragDropPage page = new DragDropPage ();
        private String[] estadoInicial = new String[]{"Esta","é uma lista","Drag em Drop!","Faça um clique longo,","e arraste para","qualquer local desejado."};
        private String[] estadoIntermediario = new String[]{"é uma lista","Drag em Drop!","Faça um clique longo,","e arraste para","Esta","qualquer local desejado."};
        private String[] estadoFinal = new String[]{"Faça um clique longo,","é uma lista","Drag em Drop!","e arraste para","Esta","qualquer local desejado."};

        @Test
        public void deveEfetuarDragNDrop() throws MalformedURLException, InterruptedException {
                //acessar menu
                menu.clicarDragNDrop ();
                //verificar estado inicial
                Thread.sleep (1000);
                page.obterLista ();
                Assert.assertArrayEquals (estadoInicial,page.obterLista ());
                //arrastar "esta" para "e arraste para"
                Thread.sleep (1000);
                page.arrastar ("Esta", "e arraste para");
                Thread.sleep (1000);
//                verificar o estado intermediario
                page.obterLista ();
                Assert.assertArrayEquals (estadoIntermediario, page.obterLista ());
                Thread.sleep (1000);
                page.arrastar ("Faça um clique longo,", "é uma lista");
                Thread.sleep (1000);
                page.obterLista ();
                Thread.sleep (1000);
                Assert.assertArrayEquals (estadoFinal, page.obterLista ());

        }

}
