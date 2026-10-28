package mobilier;

import java.util.ArrayList;
import java.util.List;


public class Mobilier {
    public static final long ARIE_COALA = 2800L * 2070L;

    private String nume;
    private List<Placa> placi = new ArrayList<>();

    public Mobilier() {}

    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public List<Placa> getPlaci() { return placi; }
    public void setPlaci(List<Placa> placi) { this.placi = placi; }

    public long ariaTotala() {
        long s = 0;
        for (Placa p : placi) s += p.ariaTotala();
        return s;
    }
    public int numarColiNecesare() {
        return (int) ((ariaTotala() + ARIE_COALA - 1) / ARIE_COALA);
    }

    @Override
    public String toString() {
        return nume + " (" + placi.size() + " tipuri de placi)";
    }
}