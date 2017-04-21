package shixzh.abj.toutiao;

public class SearchForFirstLocation {
	public static int getPos(int[] A, int n, int val) {
		int low = 0, high = n - 1, mid;
		if (n == 0 || A == null)
			return -1;
		while (low <= high) {
			mid = (low + high) / 2;
			// 当第一次找出相等的位置后需要继续向前查找，最后返回第一次出现的位置
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
		int A[] = { 4, 4, 5, 5, 5, 6, 5, 6, 7, 9, 6, 12 };
		int val = 6;
		int n = A.length;
		int result = getPos(A, n, val);
		System.out.println(result);
	}
}
