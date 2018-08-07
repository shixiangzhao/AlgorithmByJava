package shixzh.abj.count;

import java.util.Date;

public class DigitCounts {
    public static void main(String[] args) {
        Date start = new Date();
        int count = digitCounts(2, 2000000);
        Date end = new Date();
        System.out.println("count: " + count);
        System.out.print("time: " + (end.getTime() - start.getTime()) + " ms");
    }

    public static int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = 0; i <= n; i++) {
            Integer in = i;
            char[] inChar = in.toString().toCharArray();
            for (char c : inChar) {
                if (Integer.valueOf(String.valueOf(c)) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
