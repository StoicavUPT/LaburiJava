package Lab4.Devices;


import java.io.Serializable;

public class Copiator extends Echipament  implements Serializable {
    private Format format;
    private double p_ton;

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public double getP_ton() {
        return p_ton;
    }

    public void setP_ton(double p_ton) {
        this.p_ton = p_ton;
    }

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, Status status, Format format, double p_ton) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.format = format;
        this.p_ton = p_ton;
    }

    @Override
    public String toString(){
        return super.toString()+
                " | Format: "+format+
                " | Pagini/toner: "+p_ton;
    }

}

