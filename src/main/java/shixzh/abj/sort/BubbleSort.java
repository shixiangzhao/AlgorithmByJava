package shixzh.abj.sort;

public class BubbleSort {

	// 形参n传过来一个引用类型，所以排序之后不需要返回
	public static void bubbleSort(int[] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = i + 1; j < n.length; j++) {
				if (n[i] > n[j]) {
					swap(n, i, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] n = { 1, 2, 12, 3, 5, 8, 2, 1, 9 };
		printInteger(n);
		bubbleSort(n);
		printInteger(n);
	}

	// 形参如果是n[i]、n[j],因为传过来一个值类型，交换之后还要把值传回去，
	// Java没有同时返回两个值得方法，故考虑传过来一个引用n
	public static void swap(int[] n, int i, int j) {
		int temp = n[i];
		n[i] = n[j];
		n[j] = temp;
	}

	public static void printInteger(int[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}
}
