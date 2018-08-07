package shixzh.abj.toutiao;

/**
 * n个人围成一圈开始报数，数到m或者m的倍数的人出圈，剩下的人继续报数，问最后剩下的人的人是谁？
 * 实现思路：该题不涉及复杂的算法思想，纯粹是考验编程功力，当n的倍数的人出圈时，
 * 需要对这些人的状态进行标记，并且再次报数时跳过这些已经标记出圈的人。
 * 最后只剩下一个人的时候对应的小标既是答案。
 * 
 * @author shixzh
 */
public class SpeakAndCount {

    public static void getLastPerson(int n, int m) {
        boolean[] person = new boolean[n]; // 每个人都有两个属性，人员id，人员可否报数。
        int size = n; // 人数, 最外层循环
        int idx = 0; // 人员id，标记第几个人可否报数
        int code = 1; // 报数循环
        while (size > 0) { // 当还有人未出局时，循环报数
            if (!person[idx]) { // 当标识为false时，可以报数
                if (code == m) { // 当报数为m时，则出局
                    person[idx] = true; // 设置出局标识
                    System.out.print(idx + 1 + " "); // 打印出局人ID
                    code = 0; // 重新计数
                    size--; // 一个人出局
                }
                code++; // 报数 +1
            }
            idx++; // 下一个人
            if (idx == n) { // 最后一个人报完，从第一个人开始
                idx = 0;
            }
        }
    }

    public static void main(String[] args) {
        getLastPerson(9, 4);
    }
}
