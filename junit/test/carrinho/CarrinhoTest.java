package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
	Carrinho carrinho;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}
	
	@Test
	public void testCriaCarrinho() {
		Assertions.assertAll(
				"carrinho",
				() -> assertTrue(0.00 == carrinho.getValorTotal()),
				() -> assertTrue(0 == carrinho.getQtdeItems())
				);
	}
	
	@Test
	public void testAdicionaItem() {
		Produto produto1 = new Produto("Produto01", 100.00);
		carrinho.addItem(produto1);
		Assertions.assertAll(
				"carrinho",
				() -> assertEquals(100.00, carrinho.getValorTotal()),
				() -> assertEquals(1, carrinho.getQtdeItems())
				);
	}
	
	@Test
	public void testRemoveItemInexistente() {
		Produto produto1 = new Produto("Produto01", 100.00);
		assertThrows(
				ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(produto1)
				);
	}
	
	@Test
	public void testRemoveItem() {
		Produto produto1 = new Produto("Produto01", 100.00);
		carrinho.addItem(produto1);
		try {
			carrinho.removeItem(produto1);
			Assertions.assertAll(
					"carrinho",
					() -> assertTrue(0.00 == carrinho.getValorTotal()),
					() -> assertTrue(0 == carrinho.getQtdeItems())
					);
		} catch(ProdutoNaoEncontradoException e) {
			
		}
		
	}
	
	@Test
	public void esvaziaCarrinho() {
		Produto produto1 = new Produto("Produto01", 100.00);
		Produto produto2 = new Produto("Produto02", 50.00);
		Produto produto3 = new Produto("Produto03", 370.00);
		Produto produto4 = new Produto("Produto01", 130.00);
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		carrinho.addItem(produto3);
		carrinho.addItem(produto4);
		carrinho.esvazia();
		Assertions.assertAll(
				"carrinho",
				() -> assertTrue(0.00 == carrinho.getValorTotal()),
				() -> assertTrue(0 == carrinho.getQtdeItems())
				);
	}
	
	
	
}
