package ex2.instrumente;

import java.util.Objects;

public class SetTobe extends InstrumentMuzincal{
    private TipTobe tipTobe;
    private int nrTobe;
    private int nrCinele;

    public TipTobe getTipTobe() {
        return tipTobe;
    }

    public void setTipTobe(TipTobe tipTobe) {
        this.tipTobe = tipTobe;
    }

    public int getNrTobe() {
        return nrTobe;
    }

    public void setNrTobe(int nrTobe) {
        this.nrTobe = nrTobe;
    }

    public int getNrCinele() {
        return nrCinele;
    }

    public void setNrCinele(int nrCinele) {
        this.nrCinele = nrCinele;
    }

    public SetTobe(){
        super();
    }

    public SetTobe(String producator, double pret, TipTobe tipTobe, int nrTobe, int nrCinele) {
        super(producator, pret);
        this.tipTobe = tipTobe;
        this.nrTobe = nrTobe;
        this.nrCinele = nrCinele;
    }

    @Override
    public String toString() {
        return super.toString()+"SetTobe{" +
                "tipTobe=" + tipTobe +
                ", nrTobe=" + nrTobe +
                ", nrCinele=" + nrCinele +
                '}';
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        var t = (SetTobe)o;

        return super.equals(o) &&
                tipTobe.equals(t.tipTobe) &&
                nrTobe == t.nrTobe &&
                nrCinele == t.nrCinele;
    }

    @Override
    public int hashCode(){
        return Objects.hash(tipTobe,nrTobe,nrCinele);
    }
}
