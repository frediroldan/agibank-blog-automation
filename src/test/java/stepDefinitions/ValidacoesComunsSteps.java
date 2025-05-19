package stepDefinitions;

import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class ValidacoesComunsSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(Hooks.driver);

    @Entao("devo ver artigos relacionados")
    public void verificarArtigosRelacionados() {
        Assert.assertTrue(homePage.encontrouResultados());
    }

    @Entao("devo ver uma mensagem de erro")
    public void verificarMensagemErro() {
        Assert.assertTrue(homePage.exibiuMensagemErro());
    }
}
