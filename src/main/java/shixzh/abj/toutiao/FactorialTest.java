package shixzh.abj.toutiao;

/**
 * 求任意整数的阶乘 
 * 阶乘的定义：所有小于及等于该数的正整数的积 
 * 实现思路：典型的递归算法，f(n)=n*f(n-1)
 * @author shixzh
 *
 */
public class FactorialTest {

	public static int factorial(int n) {
		if (n > 1) {
			return n = n * factorial(n - 1);
		} else {
			return n;
		}
	}

	// 递归可以通过最简单的一叉树结构来理解，
	// 或者栈的结构，先进后出，n=1最后进去，最先出来
	public static int factorial1(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println("n! = " + factorial(n));
		System.out.println("n! = " + factorial1(n));
	}
}
