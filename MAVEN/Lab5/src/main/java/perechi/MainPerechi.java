package perechi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPerechi {
    private static final File FISIER = new File("src/main/resources/perechi.json");
    static void scriere(List<PerecheNumere> lista) {
        try {
            new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(FISIER, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static List<PerecheNumere> citire() {
        try {
            return new ObjectMapper().readValue(FISIER, new TypeReference<List<PerecheNumere>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(8, 13));
        lista.add(new PerecheNumere(12, 18));
        lista.add(new PerecheNumere(123, 51));
        lista.add(new PerecheNumere(246, 4802));
        scriere(lista);

        List<PerecheNumere> citite = citire();
        for (PerecheNumere p : citite) {
            System.out.println(p
                    + " fibonacci=" + p.suntConsecutiveFibonacci()
                    + " cmmmc=" + p.cmmmc()
                    + " sumaCifreEgala=" + p.areSumaCifrelorEgala()
                    + " cifrePareEgale=" + p.areAcelasiNumarCifrePare());
        }
    }
}