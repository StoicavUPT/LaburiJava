package Lab3.ex1;

import java.security.KeyPair;
import java.util.ArrayList;

public class Parabola {
    private int a_;
    private int b_;
    private int c_;

    Parabola(int a, int b, int c)
    {
        a_=a;
        b_=b;
        c_=c;
    }

    public float[] getVarfParabola(){
        return new float[]{
                -1*((float)b_/(2*a_)),
                (float)(-1*Math.pow((float)b_,2)+4*a_*c_)/(4*a_)};
    }

    @Override
    public String toString() {
        return "f(x) = "+a_+"*x^2 + "+b_+"*x + "+c_;
    }

    public float[] getMijlocSegmentIntersectare(Parabola other)
    {
        var varf1 = getVarfParabola();
        var varf2 = other.getVarfParabola();

        return new float[]{(
                varf1[0]+varf2[0])/2,
                (varf1[1]+varf2[1])/2};
    }

    static public float[] getMijlocSegmentIntersectare(Parabola p1, Parabola p2){
        var varf1 = p1.getVarfParabola();
        var varf2 = p2.getVarfParabola();

        return new float[]{(
                varf1[0]+varf2[0])/2,
                (varf1[1]+varf2[1])/2};
    }
    public float getLungimeSegmentIntersectare(Parabola other)
    {
        var varf1 = getVarfParabola();
        var varf2 = other.getVarfParabola();
        var dx = varf2[0] - varf1[0];
        var dy = varf2[1] - varf1[1];
        return (float) Math.hypot(dx,dy);
    }

    static public float getLungimeSegmentIntersectare(Parabola p1, Parabola p2){
        var varf1 = p1.getVarfParabola();
        var varf2 = p2.getVarfParabola();
        var dx = varf2[0] - varf1[0];
        var dy = varf2[1] - varf1[1];
        return (float) Math.hypot(dx,dy);
    }



    public int getA_() {
        return a_;
    }

    public void setA_(int a_) {
        this.a_ = a_;
    }

    public int getB_() {
        return b_;
    }

    public void setB_(int b_) {
        this.b_ = b_;
    }

    public int getC_() {
        return c_;
    }

    public void setC_(int c_) {
        this.c_ = c_;
    }
}
