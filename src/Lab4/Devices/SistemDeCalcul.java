package Lab4.Devices;

import java.io.Serializable;

public class SistemDeCalcul extends Echipament implements Serializable {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare sistemOperare;

    public String getTip_mon() {
        return tip_mon;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public double getVit_proc() {
        return vit_proc;
    }

    public void setVit_proc(double vit_proc) {
        this.vit_proc = vit_proc;
    }

    public int getC_hdd() {
        return c_hdd;
    }

    public void setC_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    public SistemOperare getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    public SistemDeCalcul(String denumire, int nr_inv, double pret, String zona_mag, Status status, String tip_mon, double vit_proc, int c_hdd, SistemOperare sistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemOperare = sistemOperare;
    }


    @Override
    public String toString(){
        return super.toString()+
                " | Tip monitor: "+tip_mon+
                " | Viteza Procesor: "+vit_proc+
                " | Capacitate HDD: "+c_hdd+
                " | Sistem Operare: "+sistemOperare;
    }
}
