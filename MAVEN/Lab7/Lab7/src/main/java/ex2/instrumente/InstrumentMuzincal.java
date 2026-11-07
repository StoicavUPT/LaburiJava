package ex2.instrumente;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class InstrumentMuzincal {
    private String producator;
    private double pret;

    InstrumentMuzincal(){}

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public InstrumentMuzincal(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "InstrumentMuzincal{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        var i = (InstrumentMuzincal) o ;
        return producator.equals(i.producator) && pret == i.pret;
    }

    @Override
    public int hashCode(){
        return Objects.hash(producator,pret);
    }
}
