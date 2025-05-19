package stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class BuscaContaCorrenteSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage;

    @Dado("que estou na homepage do Blog Agi")
    public void que_estou_na_homepage_do_blog_agi() {
        homePage = new HomePage(driver);
        homePage.abrirPagina();
    }

    @Quando("pesquiso pelo termo {string}")
    public void pesquiso_pelo_termo(String termo) {
        homePage.clicarLupa();
        homePage.buscarPor(termo);
    }

    @E("deve retornar artigos sobre Conta Corrente")
    public void deve_retornar_artigos_sobre_conta_corrente() {
        Assert.assertTrue(homePage.encontrouResultados());
    }

    @Entao("deve aparecer aviso de pesquisa inválida")
    public void deve_aparecer_aviso_de_pesquisa_inválida() {
        Assert.assertTrue(homePage.exibiuMensagemErro());
    }
}
