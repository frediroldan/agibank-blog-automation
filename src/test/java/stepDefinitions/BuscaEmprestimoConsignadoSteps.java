package stepDefinitions;

import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

public class BuscaEmprestimoConsignadoSteps {

    WebDriver driver = Hooks.driver;
    HomePage home;

    private static final Logger logger = LoggerFactory.getLogger(BuscaEmprestimoConsignadoSteps.class);

    @Dado("que estou na página inicial do Blog do Agi")
    public void estouPaginaInicialBlog() {
        home = new HomePage(driver);
        home.abrirPagina();
    }

    @Quando("clico na lupa e digito {string}")
    public void clicoLupaDigito(String termo) {
        home.clicarLupa();
        home.buscarPor(termo);
    }

    @Quando("pressiono Enter")
    public void pressionoEnter() {
    }

    @E("devo ver uma lista de artigos relacionados ao termo buscado")
    public void devoVerListaArtigos() {
        Assert.assertTrue(home.encontrouResultados());
    }

    @Entao("devo ver uma mensagem indicando que nenhum resultado foi encontrado")
    public void devoVerMensagemSemResultado() {
        Assert.assertTrue(home.exibiuMensagemErro());
    }
}
