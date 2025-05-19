package stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class BuscaEmprestimoConsignadoSteps {

    WebDriver driver = Hooks.driver;
    HomePage home;

    @Dado("que estou na página inicial do Blog do Agi")
    public void que_estou_na_pagina_inicial_do_blog() {
        home = new HomePage(driver);
        home.acessarPaginaInicial();
    }

    @Quando("clico na lupa e digito {string}")
    public void clico_na_lupa_e_digito(String termo) {
        home.clicarLupa();
        home.buscarPor(termo);
    }

    @Quando("pressiono Enter")
    public void pressiono_enter() {
    }

    @E("devo ver uma lista de artigos relacionados ao termo buscado")
    public void devo_ver_lista_de_artigos() {
        Assert.assertTrue(home.resultadoEncontrado());
    }

    @Entao("devo ver uma mensagem indicando que nenhum resultado foi encontrado")
    public void devo_ver_mensagem_sem_resultado() {
        Assert.assertTrue(home.exibiuMensagemSemResultados());
    }
}
