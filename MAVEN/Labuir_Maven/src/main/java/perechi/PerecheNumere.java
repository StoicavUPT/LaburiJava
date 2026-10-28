package perechi;
public class PerecheNumere {
    private int a;
    private int b;
    public PerecheNumere() {}

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() { return a; }


    public void setA(int a) { this.a = a; }

    public int getB() { return b; }

    public void setB(int b) { this.b = b; }


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

    public boolean areSumaCifrelorEgala() {
        return sumaCifrelor(a) == sumaCifrelor(b);
    }


    public boolean areAcelasiNumarCifrePare() {
        return cifrePare(a) == cifrePare(b);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
}