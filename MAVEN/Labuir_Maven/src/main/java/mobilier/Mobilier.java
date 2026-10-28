package mobilier;

import java.util.ArrayList;
import java.util.List;

/**
 * O piesă de mobilier compusă din mai multe plăci de pal.
 */
public class Mobilier {
    /** Aria unei coli de pal (2800 x 2070 mm), în mm pătrați. */
    public static final long ARIE_COALA = 2800L * 2070L;

    private String nume;
    private List<Placa> placi = new ArrayList<>();

    /** Constructor fără parametri (POJO). */
    public Mobilier() {}

    /**
     * Constructor cu parametri.
     * @param nume numele piesei
     * @param placi lista plăcilor componente
     */
    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public List<Placa> getPlaci() { return placi; }
    public void setPlaci(List<Placa> placi) { this.placi = placi; }

    /**
     * Aria totală a tuturor plăcilor piesei.
     * @return aria în mm pătrați
     */
    public long ariaTotala() {
        long s = 0;
        for (Placa p : placi) s += p.ariaTotala();
        return s;
    }

    /**
     * Estimează numărul de coli de pal necesare (doar după arie, rotunjit în sus).
     * @return numărul estimat de coli
     */
    public int numarColiNecesare() {
        return (int) ((ariaTotala() + ARIE_COALA - 1) / ARIE_COALA);
    }

    @Override
    public String toString() {
        return nume + " (" + placi.size() + " tipuri de placi)";
    }
}