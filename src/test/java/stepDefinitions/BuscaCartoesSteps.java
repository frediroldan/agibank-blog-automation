package stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class BuscaCartoesSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    @Dado("que estou na página do Blog do Agi")
    public void acessarPaginaCartoes() {
        homePage = new HomePage(driver);
        homePage.acessarPaginaInicial();
    }

    @Quando("pesquiso por {string}")
    public void pesquisarPorCartoes(String termo) {
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }

    @E("devo ver artigos relacionados")
    public void verificarArtigosCartoes() {
        Assert.assertTrue(homePage.resultadoEncontrado());
    }

    @Entao("devo ver uma mensagem de erro")
    public void verificarErroCartoes() {
        Assert.assertTrue(homePage.exibiuMensagemSemResultados());
    }
}
