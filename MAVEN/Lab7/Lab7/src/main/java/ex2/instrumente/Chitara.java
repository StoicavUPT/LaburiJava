package ex2.instrumente;

import java.util.Objects;

public class Chitara extends InstrumentMuzincal{
    private TipChitara tipChitara;
    private int nrCorzi;

    public TipChitara getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(TipChitara tipChitara) {
        this.tipChitara = tipChitara;
    }

    public int getNrCorzi() {
        return nrCorzi;
    }

    public void setNrCorzi(int nrCorzi) {
        this.nrCorzi = nrCorzi;
    }

    public Chitara(){
        super();
    }

    public Chitara(String producator, double pret, TipChitara tipChitara, int nrCorzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nrCorzi = nrCorzi;
    }

    @Override
    public String toString() {
        return super.toString()+"Chitara{" +
                "tipChitara=" + tipChitara +
                ", nrCorzi=" + nrCorzi +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        var c = (Chitara)o;
        return super.equals(o) &&
                tipChitara.equals(c.tipChitara) &&
                nrCorzi == c.nrCorzi;
    }

    @Override
    public int hashCode(){
        return Objects.hash(tipChitara,nrCorzi);
    }
}
