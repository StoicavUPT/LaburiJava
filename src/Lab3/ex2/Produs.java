package Lab3.ex2;

import java.time.LocalDate;

public class Produs {
    private String name_;
    private float price_;
    private int qty_;
    private LocalDate dataExpirare_;

    public static float incasari = 0;

    public Produs(String name_, float price_, int qty_, LocalDate dataExpirare_) {
        this.name_ = name_;
        this.price_ = price_;
        this.qty_ = qty_;
        this.dataExpirare_ = dataExpirare_;
    }

    @Override
    public String toString()
    {
        return "nume: "+name_+" || pret: "+price_+" || qty: "+qty_+" || data expirare: "+dataExpirare_;
    }

    public LocalDate getDataExpirare_(){
        return dataExpirare_;
    }
    public String getName_()
    {
        return name_;
    }

    public float getPrice_()
    {
        return price_;
    }

    public int getQty_(){return qty_;}

    public boolean sell(int qty){
        if(qty_-qty >= 0){
            qty_-=qty;
            incasari += qty*price_;
            return true;
        }
        System.out.println("Nu exista stoc pentru cantitatea introdusa!!!S");
        return false;
    }

    public String toCsv()
    {
        return name_+","+price_+","+qty_+","+dataExpirare_.toString();
    }

}
