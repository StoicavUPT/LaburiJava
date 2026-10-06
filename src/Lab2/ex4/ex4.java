package Lab2.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.print("Introudceti numarul de persoane care trebuie citite: ");
        var nr  = scan.nextInt();
        ArrayList<Persoana> persoane =  new ArrayList<>();
        while(nr>0)
        {
            persoane.add(new Persoana());
            nr--;
        }

        for(var persoana : persoane)
        {
            System.out.println(persoana.getNume_()+", "+persoana.getCnp_()+", "+persoana.getVarsta());
        }
    }
}
