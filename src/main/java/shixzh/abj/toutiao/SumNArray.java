package shixzh.abj.toutiao;

public class SumNArray {
	public static void getAns(int n) {
		int min = 1;
		int sum = 1;
		int max = 1;
		while (min <= n / 2 + 1) {
			if (sum == n) {
				for (int k = min; k <= max; k++) {
					System.out.print(k + " ");
				}
				System.out.println();
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
