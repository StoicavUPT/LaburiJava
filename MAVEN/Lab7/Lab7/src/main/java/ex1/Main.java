package ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void scriere(HashMap<Integer,Carte> map) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static HashMap<Integer,Carte> citire() {
        try {
            File file=new File("src/main/resources/carti.json");
            ObjectMapper mapper=new ObjectMapper();
            HashMap<Integer,Carte> map = mapper
                    .readValue(file, new TypeReference<HashMap<Integer,Carte>>(){});
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    static void ex1(){
        carti.forEach((numar,carte)->{
            System.out.println(numar+" "+carte);
        });
    }

    static void ex2(Carte carte){
        carti.values().removeIf(
                (c)->{
                    return c.equals(carte);}
        );
    }

    static void ex3(Carte carte){
        var key = carti.keySet().stream()
                        .max(Integer::compare).get();
        carti.putIfAbsent(key+1,carte);
    }
    static void ex4(){
        scriere(carti);
    }
    static Set<Carte> ex5(){
        var set = carti.values().stream().
                filter((c)->c.autorul().equals("Yuval Noah Harari"))
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
        return set;
    }

    static void ex6(Set<Carte> set){
        set.stream()
                .sorted((a,b)->a.titlul().compareTo(b.titlul()))
                .forEach(System.out::println);
    }

    static void ex7(){
        carti.values().stream()
                .min(Comparator.comparingInt(Carte::anul))
                .ifPresentOrElse(System.out::println,
                        ()-> System.out.println("Nu a fost gasita vreo carte"));
    }

    static HashMap<Integer,Carte> carti;

    public static void main(String[] args) {
        carti = citire();
        ex7();
    }
}