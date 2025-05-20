package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

public class BuscaINSSSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    private static final Logger logger = LoggerFactory.getLogger(BuscaINSSSteps.class);

    @Quando("pesquiso por {string} no campo de busca do INSS")
    public void pesquisarPorINSS(String termo) {
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }
}
