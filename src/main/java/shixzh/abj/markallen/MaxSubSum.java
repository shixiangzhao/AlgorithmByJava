package shixzh.abj.markallen;

import java.util.Date;
import java.util.Random;

public class MaxSubSum {

    public static void main(String[] args) {
        int count = 10000;
        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
            Random ran = new Random(i);
            a[i] = ran.nextInt(100) - 50;
            System.out.print(a[i] + " ");
        }
        System.out.println();

        Date startTime = new Date();
        System.out.println(maxSubSum1(a));
        System.out.println("maxSubSum1 time(ms): " + (new Date().getTime() - startTime.getTime()));

        startTime = new Date();
        System.out.println(maxSubSum2(a));
        System.out.println("maxSubSum2 time(ms): " + (new Date().getTime() - startTime.getTime()));

        startTime = new Date();
        System.out.println(maxSubSum4(a));
        System.out.println("maxSubSum4 time(ms): " + (new Date().getTime() - startTime.getTime()));
    }

    // O(N3)
    public static int maxSubSum1(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k < j; k++) {
                    thisSum += a[k];
                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    // O(N2)
    public static int maxSubSum2(int[] a) {
        int maxSum = 0;

        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    // O(NlogN)
    public static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    public static int maxSumRec(int[] a, int left, int right) {

        if (left == right) {//Base case
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;//增量
        int maxLeftSum = maxSumRec(a, left, center);//递归
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i <= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i--) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum, maxRightSum,
                maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int maxLeftSum, int maxRightSum, int i) {
        // TODO Auto-generated method stub
        return 0;
    }

    // O(N)
    public static int maxSubSum4(int[] a) {
        int maxSum = 0;

        int thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
