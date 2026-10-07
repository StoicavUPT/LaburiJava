package Lab2.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.print("Introudceti numarul de persoane care trebuie citite: ");
        var nr  = scan.nextInt();
        List<Persoana> persoane =  new ArrayList<>();
        while(nr>0)
        {
            System.out.print("Introduceti numele: ");
            var nume = scan.next();
            var valid = false;
            String cnp ="";
            while(!valid)
            {
                System.out.print("Introduceti CNP-ul: ");
                cnp = scan.next();
                if(Validator.validateCnp(cnp)){
                    valid = true;
                }else{
                    System.out.println("CNP INVALID!");
                }
            }
            persoane.add(new Persoana(nume,cnp));
            nr--;
        }

        for(var persoana : persoane)
        {
            System.out.println(persoana.getNume_()+", "+persoana.getCnp_()+", "+persoana.getVarsta());
        }
    }
}
