package perechi;

/**
 * Reprezintă o pereche de numere întregi.
 */
public class PerecheNumere {
    private int a;
    private int b;

    /** Constructor fără parametri (necesar modelului POJO / Jackson). */
    public PerecheNumere() {}

    /**
     * Constructor cu parametri.
     * @param a primul număr
     * @param b al doilea număr
     */
    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    /** @return primul număr */
    public int getA() { return a; }

    /** @param a primul număr */
    public void setA(int a) { this.a = a; }

    /** @return al doilea număr */
    public int getB() { return b; }

    /** @param b al doilea număr */
    public void setB(int b) { this.b = b; }

    /**
     * Verifică dacă cele două numere sunt consecutive în șirul lui Fibonacci
     * (0, 1, 1, 2, 3, 5, 8, ...), în oricare ordine.
     * @return true dacă numerele sunt doi termeni vecini din șir
     */
    public boolean suntConsecutiveFibonacci() {
        if (a < 0 || b < 0) return false;
        int max = Math.max(a, b);
        long x = 0, y = 1;
        while (x <= max) {
            if ((x == a && y == b) || (x == b && y == a)) return true;
            long t = x + y;
            x = y;
            y = t;
        }
        return false;
    }

    /**
     * Calculează cel mai mic multiplu comun al celor două numere.
     * @return cmmmc(a, b); 0 dacă unul dintre numere este 0
     */
    public long cmmmc() {
        if (a == 0 || b == 0) return 0;
        long x = Math.abs((long) a), y = Math.abs((long) b);
        long p = x, q = y;
        while (q != 0) {
            long r = p % q;
            p = q;
            q = r;
        }
        return x / p * y;
    }

    private static int sumaCifrelor(int n) {
        long m = Math.abs((long) n);
        int s = 0;
        while (m > 0) {
            s += m % 10;
            m /= 10;
        }
        return s;
    }

    private static int cifrePare(int n) {
        long m = Math.abs((long) n);
        if (m == 0) return 1; // cifra 0 este pară
        int c = 0;
        while (m > 0) {
            if (m % 2 == 0) c++;
            m /= 10;
        }
        return c;
    }

    /**
     * Verifică dacă cele două numere au suma cifrelor egală.
     * @return true dacă sumele cifrelor coincid
     */
    public boolean areSumaCifrelorEgala() {
        return sumaCifrelor(a) == sumaCifrelor(b);
    }

    /**
     * Verifică dacă cele două numere au același număr de cifre pare.
     * @return true dacă numărul de cifre pare este identic
     */
    public boolean areAcelasiNumarCifrePare() {
        return cifrePare(a) == cifrePare(b);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
}