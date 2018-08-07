package shixzh.abj.toutiao;

/**
 * 二分法查找元素第一次出现的位置
 *
 * @author shixiang.zhao
 */
public class SearchForFirstLocation {

    /**
     * @param A   int型数组
     * @param val 所要寻找的数字
     * @return 数字在数组中的位置序号
     */
    public static int getPos(int[] A, int val) {
        int n = A.length;
        int low = 0, high = n - 1, mid;
        if (n == 0 || A == null)
            return -1;
        while (low <= high) {
            mid = (low + high) / 2;
            // 当找出相等的位置后需要继续向前查找，最后返回第一次出现的位置(二分法前提是有序数组)
            if (val == A[mid]) {
                for (int j = mid; j >= 0; j--) {
                    if (A[j] != A[mid]) {
                        mid = j + 1;
                        break;
                    } else if (A[j] == A[mid]) {
                        mid = j;
                        continue;
                    }
                }
                return mid;

            } else if (val < A[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int A[] = {4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 9, 12};
        int val = 7;
        int result = getPos(A, val);
        System.out.println(result);
    }
}
