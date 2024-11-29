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
	public void TC002_naoDeveCadastrarProdutoComTodosOsCamposVazios() {
		produtoPage.executarCadastroDeProduto("", "", "", "", "");
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC007_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {
		produtoPage.escrever(produtoPage.inputEmail, "teste");
		produtoPage.inputSenha.sendKeys("");

		produtoPage.buttonSalvar.click();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC009_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
		produtoPage.escrever(loginPage.inputEmail, "");
		produtoPage.escrever(loginPage.inputSenha, "teste");

		produtoPage.buttonSalvar.click();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC007_deveLogarNoSistemaComEmailESenhaCorretos() {
		produtoPage.executarCadastroDeProduto("admin@admin.com", "admin@123");
		
		assertEquals(produtoPage.obterTituloDaPagina(), "Controle de Produtos");
	}
}