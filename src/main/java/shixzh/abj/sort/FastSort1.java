package shixzh.abj.sort;

public class FastSort1 {

	public static void main(String[] args) {
		int[] n = { 48, 15, 24, 59, 64, 79, 97, 40, 19 };
		quickSort(n, 0, n.length - 1);
	}

	/**
	 * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
	 * 
	 * @param numbers
	 *            带查找数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 * @return 中轴所在位置
	 */
	public static int getMiddle(int[] numbers, int low, int high) {
		int temp = numbers[low]; // 数组的第一个作为中轴
		while (low < high) {
			printInteger(numbers, low, high, temp, 0);
			while (low < high && numbers[high] > temp) {
				high--;
				printInteger(numbers, low, high, temp, 0);
			}
			numbers[low] = numbers[high];// 比中轴小的记录移到低端
			printInteger(numbers, low, high, temp, 1);
			while (low < high && numbers[low] < temp) {
				low++;
				printInteger(numbers, low, high, temp, 0);
			}
			numbers[high] = numbers[low]; // 比中轴大的记录移到高端
			printInteger(numbers, low, high, temp, -1);
		}
		numbers[low] = temp; // 中轴记录到尾
		printInteger(numbers, low, high, temp, 0);
		return low; // 返回中轴的位置
	}

	/**
	 * 
	 * @param numbers
	 *            带排序数组
	 * @param low
	 *            开始位置
	 * @param high
	 *            结束位置
	 */
	public static void quickSort(int[] numbers, int low, int high) {
		if (low >= high) {
			return;
		}
		System.out.println("one time quick sort: ");
		int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二
		quickSort(numbers, low, middle - 1); // 对低字段表进行递归排序
		quickSort(numbers, middle + 1, high); // 对高字段表进行递归排序
	}

	public static void printInteger(int[] n, int low, int high, int key, int state) {
		System.out.print("key: " + key + " sort: ");
		for (int i = 0; i < n.length; i++) {
			if (state == 0) {
				if (i == low || i == high) {
					System.out.print("[" + n[i] + "] ");
				} else {
					System.out.print(n[i] + " ");
				}
			} else if (state == 1) {
				if (i == low) {
					System.out.print("[" + n[i] + "] ");
				} else if (i == high) {
					System.out.print("[  ] ");
				} else {
					System.out.print(n[i] + " ");
				}
			} else if (state == -1) {
				if (i == low) {
					System.out.print("[  ] ");
				} else if (i == high) {
					System.out.print("[" + n[i] + "] ");
				} else {
					System.out.print(n[i] + " ");
				}
			}
		}
		System.out.println();
	}
}
