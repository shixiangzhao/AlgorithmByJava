package shixzh.abj.sort;

public class FastSort {

	public static void main(String[] args) {
		int[] n = { 1, 2, 12, 3, 5, 8, 2, 1, 9 };
		BubbleSort.printInteger(n);
		fastSort(n, 1, n.length-1);
		BubbleSort.printInteger(n);

	}

	public static void fastSort(int[] n, int lo, int hi) {
		if (lo > hi)
			return;
		int index = patition(n, lo, hi);
		fastSort(n, lo, index - 1);
		fastSort(n, index + 1, hi);
	}

	public static int patition(int[] n, int lo, int hi) {
		int key = n[lo];
		boolean flag = false;
		while (hi != lo) {
			if(flag) {
				
			}
		}
		n[hi] = key;
		return hi;
	}
}
