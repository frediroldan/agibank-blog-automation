package stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class BuscaCartoesSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    @Given("que estou na página do Blog do Agi")
    public void acessarPaginaCartoes() {
        homePage = new HomePage(driver);
        homePage.abrirPagina();
    }

    @When("pesquiso por {string}")
    public void pesquisarPorCartoes(String termo) {
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }

    @Then("devo ver artigos relacionados")
    public void verificarArtigosCartoes() {
        Assert.assertTrue(homePage.encontrouResultados());
    }

    @Then("devo ver uma mensagem de erro")
    public void verificarErroCartoes() {
        Assert.assertTrue(homePage.exibiuMensagemErro());
    }
}
