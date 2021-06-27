package calculadora;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(6, 5);
		assertTrue(multiplicacao == 30);
	}
	
	@Test
	public void testSomatoria() {
		int somatorio = calc.somatoria(6);
		assertTrue(somatorio == 21);
	}
	
	@Test
	public void testSomatoriaDe0() {
		int somatorio = calc.somatoria(0);
		assertTrue(somatorio == 0);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@Test
	public void testEhPositivo() {
		boolean result1 = calc.ehPositivo(0);
		boolean result2 = calc.ehPositivo(2);
		boolean result3 = calc.ehPositivo(-3);
		assertAll("positivo",
				() -> assertTrue(result1),
				() -> assertTrue(result2),
				() -> assertFalse(result3)
				);
	}
	
	@Test
	public void testCompara() {
		int result1 = calc.compara(2,2);
		int result2 = calc.compara(5, 3);
		int result3 = calc.compara(-3, 20);
		assertAll("positivo",
				() -> assertEquals(0, result1),
				() -> assertEquals(1, result2),
				() -> assertEquals(-1, result3)
				);
	}

}
