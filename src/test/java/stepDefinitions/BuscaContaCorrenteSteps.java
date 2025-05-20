package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

public class BuscaContaCorrenteSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    private static final Logger logger = LoggerFactory.getLogger(BuscaContaCorrenteSteps.class);

    @Dado("que estou na homepage do Blog Agi")
    public void estouNaHomepageBlogAgi() {
        logger.info("Página do Blog Agi acessada com sucesso.");
        homePage = new HomePage(driver);
        homePage.abrirPagina();
    }

    @Quando("pesquiso pelo termo {string}")
    public void pesquisoPeloTermo(String termo) {
        logger.info("Pesquisa pelo termo específico.");
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }

    @Entao("deve retornar artigos sobre Conta Corrente")
    public void deveRetornarArtigosSobreContaCorrente() {
        Assert.assertTrue(homePage.encontrouResultados());
    }

    @Entao("deve aparecer aviso de pesquisa inválida")
    public void deveAparecerAvisoPesquisaInvalida() {
        Assert.assertTrue(homePage.exibiuMensagemErro());
    }
}
