package Lab2.ex4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


// facem calculele inafara construcotrului
public class Persoana {
    private final String nume_;
    private String cnp_;



    Persoana(String nume, String cnp)
    {

        nume_= nume;
        cnp_ = cnp;

    }


    public Long getVarsta()
    {
        var date = cnp_.substring(1,7);
        var formatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate dataNasterii = LocalDate.parse(date,formatter);
        return ChronoUnit.YEARS.between(dataNasterii,LocalDate.now());
    }


    public String getNume_() {
        return nume_;
    }

    public String getCnp_() {
        return cnp_;
    }
}
