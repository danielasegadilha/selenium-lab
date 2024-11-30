package sistemadetestes.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sistemadetestes.pageObject.ProdutoPO;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {
	
	private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
	}

	@Test
	public void TC001_deveVoltarParaPaginaDeLogin() {
		produtoPage.voltaParaPaginaDeLogin();

		assertEquals(produtoPage.obterTituloDaPagina(), "Login");
	}

	@Test
	public void TC002_deveAbrirModalDeCadastroDeProduto() {
		produtoPage.abreModalDeCadastroDeProduto();

		String modalClass = produtoPage.divModal.getAttribute("class");

		assertEquals(modalClass, "modal show");
	}

	@Test
	public void TC003_naoDeveCadastrarProdutoComCodigoNomeQuantidadeValorEDataVazios() {
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.executarCadastroDeProduto("", "", "", "", "");

		String mensagem = produtoPage.obterMensagem();
		produtoPage.fechaModalDeCadastroDeProduto();
		produtoPage.fechaModalDeCadastroDeProduto();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC009_naoDeveCadastrarProdutoComCodigoENomePreenchidosEQuantidadeValorEDataVazios() {
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.executarCadastroDeProduto("1", "Relógio de pulso", "", "", "");
		
		String mensagem = produtoPage.obterMensagem();
		produtoPage.fechaModalDeCadastroDeProduto();
		produtoPage.fechaModalDeCadastroDeProduto();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");

	}
	
	@Test
	public void TC011_naoDeveCadastrarProdutoComCodigoNomeEValorPreenchidosEQuantidadeEDataVazios() {
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.executarCadastroDeProduto("1", "Relógio de pulso", "", "100", "");

		String mensagem = produtoPage.obterMensagem();
		produtoPage.fechaModalDeCadastroDeProduto();
		produtoPage.fechaModalDeCadastroDeProduto();

		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");

	}
	
	@Test
	public void TC012_deveCadastrarProdutoComCodigoNomeQuantidadeValorEDataPreenchidos() {
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.executarCadastroDeProduto("1", "Relógio de pulso", "3", "100", "2024-11-29");

		produtoPage.fechaModalDeCadastroDeProduto();

		assertEquals(produtoPage.obterTituloDaPagina(), "Controle de Produtos");
	}

	@Test
	public void TC014_deveFecharModalDeCadastroDeProdutoSemCadastrarProduto() {
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.fechaModalDeCadastroDeProduto();

		String modalClass = produtoPage.divModal.getAttribute("class");

		assertEquals(modalClass, "modal");
	}

	@Test
	public void TC015_deveFecharModalDeCadastroDeProdutoAoCadastrarProduto() {
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.abreModalDeCadastroDeProduto();
		produtoPage.executarCadastroDeProduto("1", "Relógio de pulso", "3", "100", "2024-11-29");

		produtoPage.fechaModalDeCadastroDeProduto();

		String modalClass = produtoPage.divModal.getAttribute("class");

		assertEquals(modalClass, "modal");

	}
}