package stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class BuscaSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    @Dado("que estou na página do Blog do Agi")
    public void acessarPaginaBusca() {
        homePage = new HomePage(driver);
        homePage.abrirPagina();
    }

    @Quando("pesquiso por {string}")
    public void pesquisarTermo(String termo) {
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }

    @E("devo ver artigos relacionados")
    public void verificarResultados() {
        Assert.assertTrue(homePage.encontrouResultados());
    }

    @Entao("devo ver uma mensagem de erro")
    public void verificarMensagemErro() {
        Assert.assertTrue(homePage.exibiuMensagemErro());
    }
}
