package Lab2.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) throws FileNotFoundException {
        var word = "llo";
        var scan = new Scanner(new File("src/Lab2/ex2/cantec_in.txt"));
        var print = new PrintStream("src/Lab2/ex2/cantec_out.txt");
        ArrayList<Vers> versuri = new ArrayList<>();
        while (scan.hasNextLine()){
            var vers = new Vers(scan.nextLine(),word);
            print.println(vers.processedVerse_);
            versuri.add(vers);
        }
    }
}
