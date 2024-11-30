package sistemadetestes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProdutoPO extends BasePO {

	//padrão da variável: nome do elemento html + o que ele representa

	@FindBy(id = "btn-adicionar")
	public WebElement buttonAdicionar;

	@FindBy(id = "codigo")
	public WebElement inputCodigo;

	@FindBy(id = "nome")
	public WebElement inputNome;

	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;

	@FindBy(id = "valor")
	public WebElement inputValor;

	@FindBy(id = "data")
	public WebElement inputData;

	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;

	//document.querySelector('form>div.alert>span')
	//document.querySelector('form.form-login>div.alert>span').textContent
	//@FindBy(css = "form.form-login>div.alert>span")
	@FindBy(id = "mensagem")
	public WebElement spanMensagem;
	//capturar a mensagem funciona por id também

	/**
	 * Construtor padrão para criação de uma nova instância da página de login
	 * @param driver Driver da página de login
	 * */
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public String obterTituloPagina() {
		return driver.getTitle();
	}

	/**
	 * Método que abre o modal no sistema
	 * */
	public void abreModalDeCadastroDeProduto() {
		buttonAdicionar.click();
		buttonAdicionar.click();
	}

	/**
	 * Método que tenta executar a ação no sistema
	 * @param codigo Codigo do produto para tentativa de cadastro de produto
	 * @param nome Nome do produto para tentativa de cadastro de produto
	 * @param quantidade Quantidade do produto para tentativa de cadastro de produto
	 * @param valor Preço para tentativa de cadastro de produto
	 * @param data Data para tentativa de cadastro de produto
	 * */
	public void executarCadastroDeProduto(String codigo, String nome, String quantidade, String valor, String data) {
		abreModalDeCadastroDeProduto();
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);
		buttonSalvar.click();

	}
	
	public String obterTituloDaPagina() {
		return driver.getTitle();
	}

}
