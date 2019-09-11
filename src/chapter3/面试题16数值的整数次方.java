package chapter3;

import org.junit.Test;

public class 面试题16数值的整数次方 {
    public double Power(double base, int exponent) {
        if (base == 0)
            return 0;
        if (exponent < 0)
            return 1 / Power(base, -exponent);
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double d = Power(base, exponent / 2);
        if ((exponent & 1) == 0)
            return d * d;
        else
            return d * d * base;
    }

    @Test
    public void test() {
        System.out.println(Power(2, 0));
        System.out.println(Power(0, -2));
    }
}
