package Lab3.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Ex2 {

    public static void showAll(ArrayList<Produs> produse){
        for (var p : produse)
        {
            System.out.println(p);
        }
    }

    public static void qtyToFile(ArrayList<Produs> produse) throws FileNotFoundException {

        var keyScan = new Scanner(System.in);

        var printer = new PrintStream("src/Lab3/ex2/produse_out.csv");
        System.out.print("Introduceti cantitatea: ");
        var qty = keyScan.nextInt();
        for (var p: produse)
        {
            if(p.getQty_() < qty )
            {
                printer.println(p.toCsv());
            }
        }

    }

    public static void showMinPrice(ArrayList<Produs> produse){
        var min  = produse.stream().min(Comparator.comparing(Produs::getPrice_)).get().getPrice_();

        for(var p:produse){
            if(p.getPrice_() == min)
            {
                System.out.println(p);
            }
        }
    }

    public static void sellProdus(ArrayList<Produs> produse){

        var keyScan = new Scanner(System.in);
        System.out.print("Introduceti denumirea");
        var nume = keyScan.nextLine();
        System.out.print("Introduceti cantitatea");
        var qty =  keyScan.nextInt();
        for (var p : produse)
        {
            if (p.getName_().equals(nume)){
                if(p.sell(qty)){
                    if (p.getQty_() == 0){
                        produse.remove(p);
                    }
                }
                return;
            }
        }
        System.out.println("Nu a fost gasit produsul : "+nume);
    }

    public static void showExpirate(ArrayList<Produs> produse)
    {
        var expirate  =  new ArrayList<Produs>();
        var now = LocalDate.now();
        for (var p : produse)
        {
            if(LocalDate.now().isAfter(p.getDataExpirare_())) expirate.add(p);
        }
        showAll(expirate);
    }

    public static void showMenu()
    {
        System.out.println("\n===== MENIU =====");
        System.out.println("1. Afisarea tuturor produselor");
        System.out.println("2. Afisarea produselor expirate");
        System.out.println("3. Vanzarea unui produs");
        System.out.println("4. Afisarea produselor cu pret minim");
        System.out.println("5. Salvarea produselor cu stoc mic in fisier");
        System.out.println("0. Iesire");
        System.out.print("Optiunea: ");
    }

    public static void main(String[] args) throws FileNotFoundException {
        var scan = new Scanner(new File("src/Lab3/ex2/produse.csv"));
        var dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var produse = new ArrayList<Produs>();
        while(scan.hasNextLine())
        {
            var line  = scan.nextLine();
            var info = line.split(",");
            var nume = info[0];
            var pret = Float.parseFloat(info[1]);
            var qty = Integer.parseInt(info[2]);
            var dataExpirare = LocalDate.parse(info[3],dateFormatter);
            produse.add(new Produs(nume, pret,qty,dataExpirare));
        }

        int op = 1;

        var keyScan = new Scanner(System.in);

        while(op!=0)
        {
            showMenu();
            op = keyScan.nextInt();
            switch (op){
                case 0: break;
                case 1:{
                    showAll(produse);
                    break;
                }
                case 2: {
                    showExpirate(produse);
                    break;
                }
                case 3:{
                    sellProdus(produse);
                    break;
                }
                case 4:{
                    showMinPrice(produse);
                    break;
                }
                case 5:
                    qtyToFile(produse);
                    break;
                default:
                    System.out.println("op necunoscuta!");
            }
        }

    }
}
