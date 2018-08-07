package shixzh.abj.toutiao;

/**
 * 求1-N之间序列和为N的所有子序列（不包括N本身）
 * 比如：N=15时，其所有和为15子序列
 * 1 2 3 4 5
 * 4 5 6
 * 7 8
 * 
 * @author shixiang.zhao
 */
public class SumNArray {

    public static void getAns(int n) {
        int min = 1;
        int sum = 1;
        int max = 1;
        //剪枝策略，两个数和为N必然只能在1到n/2+1之间循环
        while (min <= n / 2 + 1) {
            if (sum == n) {
                for (int k = min; k <= max; k++) {
                    System.out.print(k + " ");
                }
                System.out.println();
                //找到一组之后，min和max指针都要前移，sum-（上一个min）+（下一个max）
                sum = sum - min;
                min++;
                max++;
                sum = sum + max;
            }
            if (sum > n) {
                sum = sum - min;
                min++;
            } else {
                max++;
                sum = sum + max;
            }
        }
    }

    public static void main(String[] args) {
        getAns(15);
    }
}
