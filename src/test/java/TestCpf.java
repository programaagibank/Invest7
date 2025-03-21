import com.invest7.model.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCpf {
    @Test
    public void testSoma() {
        Produto produto = new Produto("Renda fixa", 200);

        String nome = produto.getNome();

        assertEquals("Renda fixa", nome, "O nome está errado!");
    }



    @Test
    public void testDivideByZero() {
        // Aqui, tentamos dividir 10 por 0
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0; // Divisão por zero
        });
    }
}

