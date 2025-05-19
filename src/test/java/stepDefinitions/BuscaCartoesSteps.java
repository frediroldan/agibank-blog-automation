package stepDefinitions;

import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

public class BuscaCartoesSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;
    private static final Logger logger = LoggerFactory.getLogger(BuscaCartoesSteps.class);

    @Dado("que estou na página do Blog do Agi")
    public void acessarPaginaCartoes() {
        logger.info("Página do Blog Agi acessada com sucesso.");
        homePage = new HomePage(driver);
        homePage.abrirPagina();
    }

    @Quando("pesquiso por {string}")
    public void pesquisarPorCartoes(String termo) {
        logger.info("Clica na Lupa e realiza a pesquisa pelo termo específico.");
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }
}
