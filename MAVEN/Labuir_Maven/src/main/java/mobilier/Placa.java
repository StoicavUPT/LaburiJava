package mobilier;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * O placă de pal dreptunghiulară care intră în compoziția unei piese de mobilier.
 */
public class Placa {
    private String descriere;
    private int lungime;
    private int latime;
    private Orientare orientare;
    private boolean[] canturi = new boolean[4];
    private int nrBucati;

    /** Constructor fără parametri (POJO). */
    public Placa() {}

    /**
     * Constructor cu parametri.
     * @param descriere descrierea plăcii (usa, capac, raft etc.)
     * @param lungime lungimea în mm
     * @param latime lățimea în mm
     * @param orientare orientarea fibrei
     * @param canturi cele 4 muchii (true = cant prezent)
     * @param nrBucati numărul de bucăți
     */
    public Placa(String descriere, int lungime, int latime, Orientare orientare,
                 boolean[] canturi, int nrBucati) {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.orientare = orientare;
        this.canturi = canturi;
        this.nrBucati = nrBucati;
    }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public int getLungime() { return lungime; }
    public void setLungime(int lungime) { this.lungime = lungime; }

    public int getLatime() { return latime; }
    public void setLatime(int latime) { this.latime = latime; }

    public Orientare getOrientare() { return orientare; }
    public void setOrientare(Orientare orientare) { this.orientare = orientare; }

    public boolean[] getCanturi() { return canturi; }
    public void setCanturi(boolean[] canturi) { this.canturi = canturi; }

    @JsonProperty("nr_bucati")
    public int getNrBucati() { return nrBucati; }

    @JsonProperty("nr_bucati")
    public void setNrBucati(int nrBucati) { this.nrBucati = nrBucati; }

    /**
     * Calculează aria totală a plăcii, ținând cont de numărul de bucăți.
     * @return aria în mm pătrați
     */
    public long ariaTotala() {
        return (long) lungime * latime * nrBucati;
    }

    @Override
    public String toString() {
        return descriere + ": " + lungime + " x " + latime + " mm, orientare=" + orientare
                + ", canturi=" + Arrays.toString(canturi) + ", bucati=" + nrBucati;
    }
}