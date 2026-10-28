package perechi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Program principal pentru lucrul cu liste de {@link PerecheNumere} în format JSON.
 */
public class MainPerechi {
    private static final File FISIER = new File("src/main/resources/perechi.json");

    /**
     * Salvează lista de perechi în fișierul JSON.
     * @param lista lista de salvat
     */
    static void scriere(List<PerecheNumere> lista) {
        try {
            new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(FISIER, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Încarcă lista de perechi din fișierul JSON.
     * @return lista citită sau null în caz de eroare
     */
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