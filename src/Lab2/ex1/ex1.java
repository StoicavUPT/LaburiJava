package Lab2.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        var fileScanner = new Scanner(new File("src/Lab2/ex1/judete_in.txt"));
        String judete[] = new String[41];
        int index= 0;
        while(fileScanner.hasNextLine())
        {
            judete[index] = fileScanner.nextLine();
            index++;
        }
        System.out.print("Introduceti un judet: ");
        var scanner = new Scanner(System.in);
        var judet = scanner.nextLine();
        Arrays.sort(judete);
        var gasit = Arrays.binarySearch(judete,judet);
        System.out.println(Arrays.toString(judete));
        System.out.println("Judet gasit pe pozitia "+gasit);
    }
}
