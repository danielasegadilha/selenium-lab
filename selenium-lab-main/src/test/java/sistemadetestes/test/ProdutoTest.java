package sistemadetestes.test;

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
	public void TC001_naoDeveCadastrarProdutoComCodigoNomeQuantidadeValorEDataVazios() {
		produtoPage.executarCadastroDeProduto("", "", "", "", "");

		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC007_naoDeveCadastrarProdutoComCodigoENomePreenchidosEQuantidadeValorEDataVazios() {
//		produtoPage.abreModalDeCadastroDeProduto();
//		produtoPage.escrever(produtoPage.inputCodigo, "1");
//		produtoPage.escrever(produtoPage.inputNome, "Relógio de pulso");
//		produtoPage.escrever(produtoPage.inputQuantidade, "");
//		produtoPage.escrever(produtoPage.inputValor, "");
//		produtoPage.escrever(produtoPage.inputData, "");

		produtoPage.executarCadastroDeProduto("1", "Relógio de pulso", "", "", "");
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC009_naoDeveCadastrarProdutoComCodigoNomeEValorPreenchidosEQuantidadeEDataVazios() {
//		produtoPage.abreModalDeCadastroDeProduto();
//		produtoPage.escrever(produtoPage.inputCodigo, "1");
//		produtoPage.escrever(produtoPage.inputNome, "Relógio de pulso");
//		produtoPage.escrever(produtoPage.inputQuantidade, "");
//		produtoPage.escrever(produtoPage.inputValor, "100");
//		produtoPage.escrever(produtoPage.inputData, "");

		produtoPage.executarCadastroDeProduto("1", "Relógio de pulso", "100", "", "");
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC010_deveCadastrarProdutoComCodigoNomeQuantidadeValorEDataPreenchidos() {
		produtoPage.executarCadastroDeProduto("1", "Relógio de pulso", "3", "100", "2024-11-29");

		assertEquals(produtoPage.obterTituloDaPagina(), "Controle de Produtos");
	}
}