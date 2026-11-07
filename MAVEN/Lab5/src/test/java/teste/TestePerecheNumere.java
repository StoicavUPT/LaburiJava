package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import perechi.PerecheNumere;

public class TestePerecheNumere {
    // Fibonacci consecutive
    @Test void fib1() { assertTrue(new PerecheNumere(8, 13).suntConsecutiveFibonacci()); }
    @Test void fib2() { assertTrue(new PerecheNumere(13, 8).suntConsecutiveFibonacci()); }
    @Test void fib3() { assertFalse(new PerecheNumere(5, 13).suntConsecutiveFibonacci()); }
    @Test void fib4() { assertTrue(new PerecheNumere(1, 1).suntConsecutiveFibonacci()); }

    // cmmmc
    @Test void cmmmc1() { assertEquals(36, new PerecheNumere(12, 18).cmmmc()); }
    @Test void cmmmc2() { assertEquals(35, new PerecheNumere(5, 7).cmmmc()); }
    @Test void cmmmc3() { assertEquals(0, new PerecheNumere(0, 9).cmmmc()); }

    // suma cifrelor
    @Test void suma1() { assertTrue(new PerecheNumere(123, 51).areSumaCifrelorEgala()); }
    @Test void suma2() { assertFalse(new PerecheNumere(10, 11).areSumaCifrelorEgala()); }
    @Test void suma3() { assertTrue(new PerecheNumere(0, 0).areSumaCifrelorEgala()); }

    // cifre pare
    @Test void pare1() { assertFalse(new PerecheNumere(246, 4802).areAcelasiNumarCifrePare()); }
    @Test void pare2() { assertTrue(new PerecheNumere(2468, 8642).areAcelasiNumarCifrePare()); }
    @Test void pare3() { assertFalse(new PerecheNumere(135, 24).areAcelasiNumarCifrePare()); }
}