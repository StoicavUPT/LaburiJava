package mobilier;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class MainMobilier {

    static List<Mobilier> citire(String cale) {
        try {
            return new ObjectMapper().readValue(new File(cale), new TypeReference<List<Mobilier>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void afisareToate(List<Mobilier> lista) {
        for (Mobilier m : lista) {
            System.out.println(m);
            for (Placa p : m.getPlaci()) System.out.println("   " + p);
        }
    }

    static void afisarePlaci(List<Mobilier> lista, String nume) {
        for (Mobilier m : lista) {
            if (m.getNume().equalsIgnoreCase(nume)) {
                System.out.println("Placile pentru " + m.getNume() + ":");
                for (Placa p : m.getPlaci()) System.out.println("   " + p);
                return;
            }
        }
        System.out.println("Nu exista piesa " + nume);
    }

    static void afisareColi(List<Mobilier> lista, String nume) {
        for (Mobilier m : lista) {
            if (m.getNume().equalsIgnoreCase(nume)) {
                System.out.println(m.getNume() + ": arie " + m.ariaTotala() + " mm2 -> "
                        + m.numarColiNecesare() + " coli de pal (2800 x 2070 mm)");
                return;
            }
        }
        System.out.println("Nu exista piesa " + nume);
    }

    public static void main(String[] args) {
        List<Mobilier> lista = citire("src/main/resources/mobilier.json");
        if (lista == null) return;
        afisareToate(lista);
        System.out.println();
        afisarePlaci(lista, "dulap 1");
        System.out.println();
        for (Mobilier m : lista) afisareColi(lista, m.getNume());
    }
}