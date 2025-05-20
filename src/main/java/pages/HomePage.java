package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Pesquisar') or @aria-label='Pesquisar']")
    WebElement botaoPesquisar;

    @FindBy(css = "input.search-field")
    WebElement campoBusca;

    @FindBy(css = ".post-title")
    private List<WebElement> artigos;

    @FindBy(css = ".search-no-results")
    private WebElement mensagemErro;

    public void abrirPagina() {
        driver.get("https://blogdoagi.com.br/");
    }

    public void clicarLupa() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(botaoPesquisar)).click();
    }

    public void buscarPor(String termo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(botaoPesquisar)).click();
        wait.until(ExpectedConditions.visibilityOf(campoBusca));
        wait.until(ExpectedConditions.elementToBeClickable(campoBusca));
        campoBusca.clear();
        campoBusca.sendKeys(termo + Keys.ENTER);
    }

    public boolean encontrouResultados() {
        return !artigos.isEmpty();
    }

    public boolean exibiuMensagemErro() {
        return mensagemErro.isDisplayed();
    }
}
