package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

public class BuscaCartoesSteps {
    WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);
    private static final Logger logger = LoggerFactory.getLogger(BuscaCartoesSteps.class);

    @Quando("pesquiso por {string} no menu de cartões")
    public void pesquisarPorCartoes(String termo) {
        logger.info("Clica na Lupa e realiza a pesquisa pelo termo específico.");
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }

}
