package tudelft.sum;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class TwoNumbersSumTest {

    private final TwoNumbersSum tns = new TwoNumbersSum();

    private ArrayList<Integer> list(Integer... digits) {
        return new ArrayList<>(Arrays.asList(digits));
    }

    // Casos básicos sin acarreo

    @Test
    void sumaSinAcarreo() {
        // 12 + 34 = 46
        ArrayList<Integer> result = tns.addTwoNumbers(list(1, 2), list(3, 4));
        assertEquals(list(4, 6), result);
    }

    @Test
    void sumaUnDigito() {
        // 3 + 5 = 8
        ArrayList<Integer> result = tns.addTwoNumbers(list(3), list(5));
        assertEquals(list(8), result);
    }

    @Test
    void sumaCero() {
        // 0 + 0 = 0
        ArrayList<Integer> result = tns.addTwoNumbers(list(0), list(0));
        assertEquals(list(0), result);
    }

    // Casos con acarreo INTERNO (dentro del bucle)

    @Test
    void sumaConAcarreoInterno() {
        // 19 + 23 = 42
        ArrayList<Integer> result = tns.addTwoNumbers(list(1, 9), list(2, 3));
        assertEquals(list(4, 2), result);
    }

    @Test
    void sumaConVariosAcarreosInternos() {
        // 199 + 201 = 400
        ArrayList<Integer> result = tns.addTwoNumbers(list(1, 9, 9), list(2, 0, 1));
        assertEquals(list(4, 0, 0), result);
    }

    // Caso que REVELA EL BUG: acarreo que desborda al final
    // El bucle termina pero complement = 1 nunca se agrega

    @Test
    void sumaConAcarreoFinal_bugDetectado() {
        // 99 + 1 = 100  →  resultado esperado: [1, 0, 0]
        // SIN el fix, la clase devuelve [0, 0] (falta el 1 del acarreo final)
        ArrayList<Integer> result = tns.addTwoNumbers(list(9, 9), list(1));
        assertEquals(list(1, 0, 0), result);
    }

    @Test
    void sumaConAcarreoFinalSegundoOperando() {
        // 1 + 99 = 100
        ArrayList<Integer> result = tns.addTwoNumbers(list(1), list(9, 9));
        assertEquals(list(1, 0, 0), result);
    }

    @Test
    void sumaMaximosDigitosIguales() {
        // 999 + 1 = 1000
        ArrayList<Integer> result = tns.addTwoNumbers(list(9, 9, 9), list(1));
        assertEquals(list(1, 0, 0, 0), result);
    }

    @Test
    void sumaNovenoDigito() {
        // 9 + 9 = 18
        ArrayList<Integer> result = tns.addTwoNumbers(list(9), list(9));
        assertEquals(list(1, 8), result);
    }

    // Casos con listas de distinto tamaño

    @Test
    void listasDistintoTamano_primeraMayor() {
        // 100 + 1 = 101
        ArrayList<Integer> result = tns.addTwoNumbers(list(1, 0, 0), list(1));
        assertEquals(list(1, 0, 1), result);
    }

    @Test
    void listasDistintoTamano_segundaMayor() {
        // 1 + 100 = 101
        ArrayList<Integer> result = tns.addTwoNumbers(list(1), list(1, 0, 0));
        assertEquals(list(1, 0, 1), result);
    }

    // Casos extremos

    @Test
    void sumaCeroConNumero() {
        // 0 + 42 = 42
        ArrayList<Integer> result = tns.addTwoNumbers(list(0), list(4, 2));
        assertEquals(list(4, 2), result);
    }

    @Test
    void sumaUnDigitoResultadoDosDigitos() {
        // 5 + 8 = 13
        ArrayList<Integer> result = tns.addTwoNumbers(list(5), list(8));
        assertEquals(list(1, 3), result);
    }
}