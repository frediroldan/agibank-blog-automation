package stepDefinitions;

import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class BuscaCartoesSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    @Dado("que estou na página do Blog do Agi")
    public void acessarPaginaCartoes() {
        homePage = new HomePage(driver);
        homePage.abrirPagina();
    }

    @Quando("pesquiso por {string}")
    public void pesquisarPorCartoes(String termo) {
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }
}
