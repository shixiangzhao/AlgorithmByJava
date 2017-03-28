package shixzh.abj.sort;

import static shixzh.abj.sort.BubbleSort.printInteger;
import static shixzh.abj.sort.BubbleSort.swap;

public class FastSort {

	public static void main(String[] args) {
		int[] n = { 48, 15, 24, 59, 64, 79, 97, 40, 19 };
		quickSort(n, 0, n.length - 1);
	}
	/**
	 * 
	 * 1.快速排序，首先把数组的第一个数拿出来作为key，在数组前后分别设置一个i,j做为标识，
	 * 然后拿key对数组从j往前遍历，j--，直到找到第一个小于key的arrays[j]，
	 * 交换arrays[i]和arrays[j]，再拿着这个key要从i往后遍历，i++，
	 * 直到找到大于key的arrays[i]，交换arrays[i]和arrays[j]，
	 * 一直循环到i=j结束，当这里结束后，大于key的值都到了它的后面，小于key的就到了它的前面；
	 * 然后对i=j交点的左右两边再进行递归调用就可以完成整个数组的排序。
	 * 
	 * @param arrays
	 *            要排序的数组
	 * @param start
	 *            数组的最小下标
	 * @param end
	 *            数组的最大下标
	 */
	public static void quickSort(int[] arrays, int start, int end) {
		if (start >= end) {
			return;
		}

		int i = start;
		int j = end;
		int value = arrays[i];
		System.out.println("value = array[i] = " + value);
		boolean flag = true;
		while (i != j) {
			System.out.println("i = " + i + " j = " + j + " array[i] = " + arrays[i] + " array[j] = " + arrays[j]);
			if (flag) {
				if (value > arrays[j]) {
					System.out.print("value(" + value + ") > arrays[j](" + arrays[j] + ") swap: ");
					swap(arrays, i, j);
					flag = false;
					printInteger(arrays);
				} else {
					j--;
				}
			} else {
				if (value < arrays[i]) {
					System.out.print("value(" + value + ") < arrays[i](" + arrays[i] + ") swap: ");
					swap(arrays, i, j);
					flag = true;
					printInteger(arrays);
				} else {
					i++;
				}
			}
		}
		System.out.println("one time quick sort over...");
		quickSort(arrays, start, j - 1);
		System.out.println("i = " + i + " j = " + j + " array[i] = " + arrays[i] + " array[j] = " + arrays[j]);
		quickSort(arrays, i + 1, end);
		System.out.println("i = " + i + " j = " + j + " array[i] = " + arrays[i] + " array[j] = " + arrays[j]);

	}
}
