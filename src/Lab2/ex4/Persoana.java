package Lab2.ex4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Persoana {
    private final String nume_;
    private String cnp_;


    private static String approvedStarters_ = "1256";
    private static String cifre_ = "0123456789";
    private static int[] controlNumber_ = new int[]{2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
    Persoana()
    {
        var scan =  new Scanner(System.in);
        System.out.print("Introduceti numele: ");
        nume_ = scan.nextLine();

        var valid = false;

        while(!valid){
            System.out.print("Introduceti CNP-ul: ");
            var cnp = scan.nextLine();
            if(validateCnp(cnp)){
                valid = true;
                cnp_=cnp;
            }
            else {
                System.out.println("CNP-ul introdus nu este valid! Reintroduceti CNP-ul!");
            }
        }

    }


    private boolean validateCnp(String cnp)
    {
        if(cnp.length() !=13) {
            System.out.println("Lungime necorespunzatoare!");
            return false;
        }
        if(approvedStarters_.indexOf(cnp.toCharArray()[0]) == -1) {
            System.out.println("Cifra de inceput "+cnp.toCharArray()[0]+" e necoresnpunzatoare!");
            return false;
        }
        for(var cifra : cnp.toCharArray()){
            if(cifre_.indexOf(cifra) == -1) {
                System.out.println("CNP-ul trebuie sa contina doar cifre");
                return false;
            }
        }
        return validateControlDigit(cnp);
    }

    public Long getVarsta()
    {
        var date = cnp_.substring(1,7);
        var formatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate dataNasterii = LocalDate.parse(date,formatter);
        return ChronoUnit.YEARS.between(dataNasterii,LocalDate.now());
    }


    private boolean validateControlDigit(String cnp){
        var cifra = cnp.toCharArray()[cnp.length()-1];
        cnp = cnp.substring(0,cnp.length()-1);
        var sum =0;
        int index = 0;
        for (var digit : cnp.toCharArray()) {
            sum+= (digit-'0') * controlNumber_[index];
            index++;
        }
        System.out.println(sum % 11 % 10);
        return cifra-'0' == sum % 11 % 10;
    }

    public String getNume_() {
        return nume_;
    }

    public String getCnp_() {
        return cnp_;
    }
}
