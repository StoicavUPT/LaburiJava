package ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ex1.Carte;
import ex2.instrumente.*;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void scriere(Set<InstrumentMuzincal> set) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file=new File("src/main/resources/instrumente.json");
            mapper.writeValue(file,set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Set<InstrumentMuzincal> citire() {
        try {
            File file=new File("src/main/resources/instrumente.json");
            ObjectMapper mapper=new ObjectMapper();
            Set<InstrumentMuzincal> set = mapper
                    .readValue(file, new TypeReference<Set<InstrumentMuzincal>>(){});
            return set;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setup(){
        instrumente.add(new Chitara("Bose",1298.9, TipChitara.CLASICA,9));
        instrumente.add(new Chitara("Samsung",1923.5,TipChitara.ACUSTICA,10));
        instrumente.add(new Chitara("Philips",3500.5,TipChitara.ELECTRICA,5));

        instrumente.add(new SetTobe("Sony",3009.99, TipTobe.ELECTRONICE,5,6));
        instrumente.add(new SetTobe("Bose",1899.9,TipTobe.ACUSTICE,4,2));
        instrumente.add(new SetTobe("Philips",1999.9,TipTobe.ACUSTICE,6,3));

        scriere(instrumente);
    }

    public static void ex5(){
        var introdus = instrumente.add(new SetTobe("Sony",39.99, TipTobe.ELECTRONICE,5,6));
        if(introdus) System.out.println("S a putut introduce");
        else System.out.println("Nu s a putut introduce");
    }

    public static void ex6(){
        instrumente.removeIf((i)->i.getPret()>3000);
    }

    public static void ex7(){
        instrumente.stream()
                .filter((i)->i instanceof Chitara)
                .forEach(System.out::println);
    }

    public static void ex8(){
        instrumente.stream()
                .filter((i)->i.getClass().equals(SetTobe.class))
                .forEach(System.out::println);
    }

    public static void ex9(){
        instrumente.stream()
                .filter((i)-> i instanceof Chitara)
                .map((i)-> (Chitara)i)
                .max(Comparator.comparingInt(Chitara::getNrCorzi))
                .ifPresentOrElse(System.out::println,
                        ()-> System.out.println("Nu a fost gasita o chitara"));
    }


    public static void ex10(){
        instrumente.stream()
                .filter((i)->i instanceof SetTobe)
                .map((i)->(SetTobe)i)
                .filter((t)->t.getTipTobe().equals(TipTobe.ACUSTICE))
                .sorted(Comparator.comparingInt(SetTobe::getNrTobe))
                .forEach(System.out::println);
    }

    static Set<InstrumentMuzincal> instrumente = new HashSet<>();

    public static void main(String[] args) {

        instrumente = citire();
        if(instrumente == null) instrumente = new HashSet<>();
        ex10();

    }
}
