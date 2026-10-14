package Lab3.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        var scan =  new Scanner(new File("src/Lab3/ex1/in.txt"));
        var parabole = new ArrayList<Parabola>();
        while(scan.hasNextLine())
        {
            var a = scan.nextInt();
            var b = scan.nextInt();
            var c = scan.nextInt();

            parabole.add(new Parabola(a,b,c));
        }

        for (var p : parabole)
        {
            System.out.print(p+" || Varf : "+ Arrays.toString(p.getVarfParabola())+ "\n");
        }

        var mijlocSegment = Parabola.getMijlocSegmentIntersectare(parabole.getFirst(),parabole.getLast());
        var lungimeSegment = parabole.getFirst().getLungimeSegmentIntersectare(parabole.getLast());

        System.out.println("Pentru prima si ultima \nmijlocul : "+Arrays.toString(mijlocSegment));
        System.out.println("lungimea : "+lungimeSegment);
    }
}
