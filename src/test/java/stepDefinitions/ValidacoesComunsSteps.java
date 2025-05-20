package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

public class ValidacoesComunsSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(Hooks.driver);

    private static final Logger logger = LoggerFactory.getLogger(ValidacoesComunsSteps.class);

    @Dado("que estou na página do Blog do Agi")
    public void acessarPaginaCartoes() {
        logger.info("Página do Blog Agi acessada com sucesso.");
        homePage = new HomePage(driver);
        homePage.abrirPagina();
    }
    @Entao("devo ver artigos relacionados")
    public void verificarArtigosRelacionados() {
        Assert.assertTrue(homePage.encontrouResultados());
    }

    @Entao("devo ver uma mensagem de erro")
    public void verificarMensagemErro() {
        Assert.assertTrue(homePage.exibiuMensagemErro());
    }
}
