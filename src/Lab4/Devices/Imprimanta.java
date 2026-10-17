package Lab4.Devices;


import java.io.Serializable;

public class Imprimanta extends Echipament  implements Serializable {



    public double getPpm() {
        return ppm;
    }

    public void setPpm(double ppm) {
        this.ppm = ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }

    public double getP_car() {
        return p_car;
    }

    public void setP_car(double p_car) {
        this.p_car = p_car;
    }

    public ModTiparire getModTiparire() {
        return modTiparire;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }

    private double ppm;
    private String rezolutie;
    private double p_car;
    private ModTiparire modTiparire;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Status status, double ppm, ModTiparire modTiparire, String rezolutie, double p_car) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.ppm = ppm;
        this.modTiparire = modTiparire;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
    }

    @Override
    public String toString(){
        return super.toString()+
                " | Pagini pe minut: "+ppm+
                " | Mod Tiparire: "+modTiparire+
                " | Rezoltuie: "+rezolutie+
                " | Pagini/cartus: "+p_car;
    }


}
