package br.com.carlosnoronha.appium.test;

import br.com.carlosnoronha.appium.core.BaseTest;
import br.com.carlosnoronha.appium.page.MenuPage;
import br.com.carlosnoronha.appium.page.seuBarriga.*;
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
    SBResumoPage resumo = new SBResumoPage ();

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
        contas.setContas ("ContaTeste5");
        contas.salvar ();
        Assert.assertTrue (contas.existeUmElementoPorTexto ("Conta adicionada com sucesso"));

    }
    @Test
    public void deveExcluirComSucesso() throws MalformedURLException, InterruptedException {
        menuSB.acessarContas ();
        contas.selecionarContas ("ContaTeste3");
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
        mov.setValor ("1000");
        mov.salvar ();
        Assert.assertTrue (mov.existeUmElementoPorTexto ("Conta é um campo obrigatório"));
        mov.setConta ("ContaTeste5");
        mov.salvar ();
        Assert.assertTrue (mov.existeUmElementoPorTexto ("Movimentação cadastrada com sucesso"));

    }
    @Test
    public void deveExcluirMovimentacao() throws MalformedURLException, InterruptedException {
        menuSB.acessarResumo ();
        Thread.sleep (2000);
        resumo.selecionarMovimentacao ("123.00");
        Thread.sleep (2000);
        resumo.deletarMovimentacao ("Del");
        Thread.sleep (2000);
        Assert.assertTrue (mov.existeUmElementoPorTexto ("Movimentação removida com sucesso!"));
        Thread.sleep (2000);







    }


}
