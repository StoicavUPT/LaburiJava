package Lab4;

import Lab4.Devices.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


//luam variabila in care pastram numele fisierului binar , ne facem o const
//facem cu alte tipuri de .getclass
//pattern matching instance of
public class MainProgram {


    final static public String fisBinar="src/Lab4/echip.bin";
    final static public String fisTxt="src/Lab4/echipamente.txt";

    public static void showMenu(){
        System.out.println("\n========== MENIU ==========");
        System.out.println("1. Afisarea tuturor echipamentelor");
        System.out.println("2. Afisarea imprimantelor");
        System.out.println("3. Afisarea copiatoarelor");
        System.out.println("4. Afisarea sistemelor de calcul");
        System.out.println("5. Modificarea starii unui echipament");
        System.out.println("6. Setarea unui mod de scriere pentru o imprimanta");
        System.out.println("7. Setarea unui format de copiere pentru copiatoare");
        System.out.println("8. Instalarea unui anumit sistem de operare");
        System.out.println("9. Serializare echipamente");
        System.out.println("10. Deserializare echipamente");
        System.out.println("0. Iesire");
        System.out.println("============================");
        System.out.print("Selectati o optiune: ");
    }

    static void serialize(Object echipamente) {
        try {
            FileOutputStream f = new FileOutputStream(fisBinar);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(echipamente);
            oos.close();
            f.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Echipament> deserialize() {
        try {
            FileInputStream f = new FileInputStream(fisBinar);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return (ArrayList<Echipament>)o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void showAllEchipamente(ArrayList<Echipament> echipamente){
        for(var e : echipamente){
            System.out.println(e);
        }
    }

    public static void showVandute(ArrayList<Echipament> echipamente){
        for(var e : echipamente){
            if(e.getStatus() == Status.VANDUT){
                System.out.println(e);
            }
        }
    }

    public static void showImprimante(ArrayList<Echipament> echipamente){
        for(var e : echipamente){
            if(e.getClass() == Imprimanta.class){
                System.out.println(e);
            }
        }
    }

    public static void showSistemeCalcul(ArrayList<Echipament> echipamente){
        for(var e : echipamente){
            if(e instanceof SistemDeCalcul){
                System.out.println(e);
            }
        }
    }

    public static void showCopiatoare(ArrayList<Echipament> echipamente){
        for(var e : echipamente){
            if(Copiator.class.isInstance(e)){
                System.out.println(e);
            }
        }
    }

    public static int getNrinventar(){
        var scan = new Scanner(System.in);
        System.out.print("Introducet numarul de inventar al echipamentului: ");
        return scan.nextInt();
    }


    public static void modificareStatus(ArrayList<Echipament> echipamente){
        var scan =  new Scanner(System.in);
        var inv = getNrinventar();
        Echipament e = null;
        for(var echipament: echipamente){
            if(echipament.getNr_inv() == inv){
                e = echipament;
                break;
            }
        }
        if(e == null){
            System.out.println("Nu a fost gasit un echipament cu numarul de inventar "+inv);
            return;
        }
        System.out.print("Introduceti statusul "+ Arrays.toString(Status.values())+" :");
        var status = scan.next();

        e.setStatus(Status.valueOf(status.toUpperCase()));
    }

    public static void modificareModScriere(ArrayList<Echipament> echipamente){
        var scan =  new Scanner(System.in);
        var inv = getNrinventar();
        System.out.print("Introduceti Modul de scriere "+ Arrays.toString(ModTiparire.values())+" :");
        var mod = scan.next();

        for(var echipament: echipamente){
            if(echipament instanceof Imprimanta i && echipament.getNr_inv() == inv){
                i.setModTiparire(ModTiparire.valueOf(mod.toUpperCase()));
                return;
            }
        }
        System.out.println("Nu a fost gasit o imprimanta cu numarul de inventar "+inv);

    }

    public static void modificareFormatCopiere(ArrayList<Echipament> echipamente){
        var scan =  new Scanner(System.in);
        var inv = getNrinventar();
        Echipament e = null;
        for(var echipament: echipamente){
            if(echipament.getClass() == Copiator.class && echipament.getNr_inv() == inv){
                e = echipament;
                break;
            }
        }
        if(e == null){
            System.out.println("Nu a fost gasit un copiator cu numarul de inventar "+inv);
            return;
        }
        System.out.print("Introduceti Formatul "+ Arrays.toString(Format.values())+" :");
        var format = scan.next();
        ((Copiator) e).setFormat(Format.valueOf(format.toUpperCase()));

    }


    public static void modificareSistemOperare(ArrayList<Echipament> echipamente){
        var scan =  new Scanner(System.in);
        var inv = getNrinventar();
        Echipament e = null;
        for(var echipament: echipamente){
            if(echipament.getClass() == SistemDeCalcul.class && echipament.getNr_inv() == inv){
                e = echipament;
                break;
            }
        }
        if(e == null){
            System.out.println("Nu a fost gasit un sistem de calcul cu numarul de inventar "+inv);
            return;
        }
        System.out.print("Introduceti sistemul de operare "+ Arrays.toString(SistemOperare.values())+" :");
        var sistem = scan.next();
        ((SistemDeCalcul) e).setSistemOperare(SistemOperare.valueOf(sistem.toUpperCase()));

    }


    public static void main(String[] args) throws FileNotFoundException {
        var fileScan = new Scanner(new File(fisTxt));
        var echipamente = new ArrayList<Echipament>();
        var processedLines = new ArrayList<ArrayList<String>>();
        while (fileScan.hasNextLine()) {
            processedLines.add(
                    new ArrayList<>(List.of(fileScan.nextLine().split(";")))
            );
        }
        for(var line: processedLines)
        {
            var nume = line.getFirst();
            var nr_inv = Integer.parseInt(line.get(1));
            var pret = Double.parseDouble(line.get(2));
            var zona_mag = line.get(3);
            var status = Status.valueOf(line.get(4).toUpperCase());
            var tip = line.get(5);
            switch (tip){
                case "imprimanta":{
                    var ppm = Double.parseDouble(line.get(6));
                    var rezolutie = line.get(7);
                    var p_car = Double.parseDouble(line.get(8));
                    var modTiparire = ModTiparire.valueOf(line.get(9).toUpperCase());
                    echipamente.add(new Imprimanta(nume,nr_inv,pret,zona_mag,status,ppm,modTiparire,rezolutie,p_car));
                    break;
                }
                case "copiator":{
                    var p_ton= Double.parseDouble(line.get(6));
                    var format = Format.valueOf(line.get(7).toUpperCase());
                    echipamente.add(new Copiator(nume,nr_inv,pret,zona_mag,status,format,p_ton));
                    break;
                }
                case "sistem de calcul":{
                    var tip_mon = line.get(6);
                    var vit_proc = Double.parseDouble(line.get(7));
                    var c_hdd  = Integer.parseInt(line.get(8));
                    var sistemOperare = SistemOperare.valueOf(line.get(9).toUpperCase());
                    echipamente.add(new SistemDeCalcul(nume,nr_inv,pret,zona_mag,status,tip_mon,vit_proc,c_hdd,sistemOperare));
                    break;
                }
                default:{
                    System.out.println("Tip de echipament necunoscut!");
                    break;
                }
            }
        }
        var keyScan = new Scanner(System.in);

        int op = 1;
        while(op!=0){
            showMenu();
            op = keyScan.nextInt();
            switch (op){
                case 1:{
                    showAllEchipamente(echipamente);
                    break;
                }
                case 2:{
                    showImprimante(echipamente);
                    break;
                }
                case 3:{
                    showCopiatoare(echipamente);
                    break;
                }
                case 4:{
                    showSistemeCalcul(echipamente);
                    break;
                }
                case 5:{
                    modificareStatus(echipamente);
                    break;
                }
                case 6:{
                    modificareModScriere(echipamente);
                    break;
                }
                case 7:{
                    modificareFormatCopiere(echipamente);
                    break;
                }
                case 8:{
                    modificareSistemOperare(echipamente);
                    break;
                }
                case 9:{
                    serialize(echipamente);
                    break;
                }
                case 10:{
                    echipamente = deserialize();
                    if(echipamente == null) echipamente = new ArrayList<>();
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Optiune necunoscuta!");
                    break;
                }
            }
        }


    }
}
