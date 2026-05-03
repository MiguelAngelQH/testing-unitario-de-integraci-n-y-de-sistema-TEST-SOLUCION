package tudelft.mirror;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MirrorTest {

    private final Mirror mirror = new Mirror();

    @Test
    void ejemploAbXYZba() {
        // "abXYZba" → "ab"
        // begin=0 'a'=='a', begin=1 'b'=='b', begin=2 'X'!='Z' → break
        // begin(2) != end(4), retorna mirror="ab"
        assertEquals("ab", mirror.mirrorEnds("abXYZba"));
    }

    @Test
    void ejemploAbca() {
        // "abca" → "a"
        // begin=0 'a'=='a', begin=1 'b'!='c' → break
        // begin(1) != end(2), retorna mirror="a"
        assertEquals("a", mirror.mirrorEnds("abca"));
    }

    @Test
    void ejemploAba() {
        // "aba" → "aba"  (longitud impar, llega al centro)
        // begin=0 'a'=='a', begin=1 end=1 → bucle termina (begin < end es false)
        // begin(1) == end(1), retorna toda la cadena "aba"
        assertEquals("aba", mirror.mirrorEnds("aba"));
    }

    // Cadenas de longitud IMPAR

    @Test
    void longitudImpar_mirrorParcial() {
        // "xyzyx" → "xy"
        // begin=0 'x'=='x', begin=1 'y'=='y', begin=2 end=2 → bucle termina
        // begin == end, retorna toda la cadena "xyzyx"
        assertEquals("xyzyx", mirror.mirrorEnds("xyzyx"));
    }

    @Test
    void longitudImpar_sinMirror() {
        // "abcde" → ""
        // begin=0 'a'!='e' → break inmediato
        // begin(0) != end(4), retorna mirror=""
        assertEquals("", mirror.mirrorEnds("abcde"));
    }

    @Test
    void longitudImpar_unSoloCaracter() {
        // "a" → "a"
        // bucle no se ejecuta (begin=0, end=0, begin < end es false)
        // begin(0) == end(0), retorna toda la cadena "a"
        assertEquals("a", mirror.mirrorEnds("a"));
    }

    @Test
    void longitudImpar_tresCaracteresIguales() {
        // "aaa" → "aaa"
        // begin=0 'a'=='a' → mirror="a", begin=1 end=1 → bucle termina
        // begin == end, retorna toda la cadena
        assertEquals("aaa", mirror.mirrorEnds("aaa"));
    }

    // Cadenas de longitud PAR

    @Test
    void longitudPar_mirrorCompleto() {
        // "abba" → "ab"
        // begin=0 'a'=='a', begin=1 'b'=='b', begin=2 end=1 → bucle termina (begin < end false)
        // begin(2) != end(1), retorna mirror="ab"
        assertEquals("ab", mirror.mirrorEnds("abba"));
    }

    @Test
    void longitudPar_sinMirror() {
        // "abcd" → ""
        // begin=0 'a'!='d' → break inmediato
        // begin(0) != end(3), retorna mirror=""
        assertEquals("", mirror.mirrorEnds("abcd"));
    }

    @Test
    void longitudPar_unCaracterCoincide() {
        // "abcd" con primer/ultimo igual: "abca" ya cubierto arriba
        // "xaby" → ""
        assertEquals("", mirror.mirrorEnds("xaby"));
    }

    @Test
    void longitudPar_dosCaracteres_iguales() {
        // "aa" → "a"
        // begin=0 'a'=='a' → mirror="a", begin=1 end=0 → bucle termina
        // begin(1) != end(0), retorna mirror="a"
        assertEquals("a", mirror.mirrorEnds("aa"));
    }

    @Test
    void longitudPar_dosCaracteres_distintos() {
        // "ab" → ""
        // begin=0 'a'!='b' → break
        // begin(0) != end(1), retorna mirror=""
        assertEquals("", mirror.mirrorEnds("ab"));
    }

    // Casos extremos

    @Test
    void cadenaVacia() {
        // "" → ""
        // bucle no se ejecuta, begin(0) == end(-1) es false, retorna mirror=""
        assertEquals("", mirror.mirrorEnds(""));
    }

    @Test
    void todosCaracteresIgualesPar() {
        // "aaaa" → "aa"
        // begin=0 'a'=='a', begin=1 'a'=='a', begin=2 end=1 → termina
        // begin != end, retorna mirror="aa"
        assertEquals("aa", mirror.mirrorEnds("aaaa"));
    }

    @Test
    void todosCaracteresIgualesImpar() {
        // "aaaaa" → "aaaaa"
        // begin=0 'a'=='a', begin=1 'a'=='a', begin=2 end=2 → termina
        // begin == end, retorna toda la cadena
        assertEquals("aaaaa", mirror.mirrorEnds("aaaaa"));
    }
}