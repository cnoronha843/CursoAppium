package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.MenuPage;
import br.com.carlosnoronha.appium.page.seuBarriga.SBContasPage;
import br.com.carlosnoronha.appium.page.seuBarriga.SBLoginPage;
import br.com.carlosnoronha.appium.page.seuBarriga.SBMenuPage;
import br.com.carlosnoronha.appium.page.seuBarriga.SBMovimentacaoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class SBTeste extends BaseTest {

    MenuPage menu = new MenuPage ();
    SBLoginPage login = new SBLoginPage ();
    SBMenuPage  menuSB = new SBMenuPage ();
    SBContasPage contas = new SBContasPage ();
    SBMovimentacaoPage mov = new SBMovimentacaoPage ();


    @Before
    public void setup() throws MalformedURLException, InterruptedException {
        menu.acessarSBNativo ();
        login.setEmail ("carlos@carlos.com");
        login.setSenha ("123");
        login.entrar ();

    }
    @Test
    public void deveInserirContaComSucesso() throws MalformedURLException, InterruptedException {
        menuSB.acessarContas ();
        contas.setContas ("ContaTeste2");
        contas.salvar ();
        Assert.assertTrue (contas.existeUmElementoPorTexto ("Conta adicionada com sucesso"));

    }
    @Test
    public void deveInserirExcluirComSucesso() throws MalformedURLException, InterruptedException {
        menuSB.acessarContas ();
        contas.selecionarContas ("ContaTeste");
        Thread.sleep (3000);
        contas.excluir ();
        Thread.sleep (3000);
        Assert.assertTrue (contas.existeUmElementoPorTexto ("Conta excluída com sucesso"));

    }

    @Test
    public void deveValidarInclusaoMov() throws MalformedURLException, InterruptedException {
        menuSB.acessarMovimentacoes ();
        mov.salvar ();
        Assert.assertTrue (mov.existeUmElementoPorTexto ("Descrição é um campo obrigatório"));
        mov.setDescricao ("Desc");
        mov.salvar ();
        Assert.assertTrue (mov.existeUmElementoPorTexto ("Interessado é um campo obrigatório"));

        mov.setInteressado ("interess");
        mov.salvar ();
        Assert.assertTrue (mov.existeUmElementoPorTexto ("Valor é um campo obrigatório"));
        mov.setValor ("123");
        mov.salvar ();
        Assert.assertTrue (mov.existeUmElementoPorTexto ("Conta é um campo obrigatório"));
        mov.setConta ("ContaTeste2");
        mov.salvar ();
        Assert.assertTrue (mov.existeUmElementoPorTexto ("Movimentação cadastrada com sucesso"));

    }


}
