package Lab2.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) throws FileNotFoundException {
        var scan = new Scanner(new File("src/Lab2/ex3/in.txt"));
        var sirDeInserat = scan.nextLine();
        var sir = scan.nextLine();
        var pozitie = scan.nextInt();
        StringBuilder builder =  new StringBuilder(sir);
        builder.insert(pozitie,sirDeInserat);
        System.out.println(builder);

        var pozitieSters=5;
        var numarSters=6;
        builder.delete(pozitieSters,pozitieSters+numarSters);
        System.out.println(builder);
    }
}
