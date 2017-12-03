package shixzh.abj.markallen;

import java.util.Random;

public class TestDataUtil {

    public static int[] getRandomIntArray(int count) {
        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
            Random ran = new Random(i);
            a[i] = ran.nextInt(100) - 50;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        return a;
    }

    public static Integer[] getOrderIntegerArray(int count) {
        Integer[] a = new Integer[count];
        for (int i = 0; i < count; i++) {
            a[i] = 2 * i + 1;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        return a;
    }
}
