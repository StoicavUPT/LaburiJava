package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mobilier.Mobilier;
import mobilier.Orientare;
import mobilier.Placa;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TesteMobilier {
    @Test
    void coala() {
        Placa p = new Placa("t", 2800, 2070, Orientare.ORICARE, new boolean[4], 1);
        assertEquals(1, new Mobilier("m", List.of(p)).numarColiNecesare());
    }

    @Test
    void douaColi() {
        Placa p = new Placa("t", 2800, 2070, Orientare.ORICARE, new boolean[4], 2);
        Placa q = new Placa("t", 10, 10, Orientare.ORICARE, new boolean[4], 1);
        assertEquals(3, new Mobilier("m", List.of(p, q)).numarColiNecesare());
    }
}