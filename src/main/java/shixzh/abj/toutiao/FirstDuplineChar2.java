package shixzh.abj.toutiao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 求一个字符串中第一个重复的字符
 * 
 * @author shixiang.zhao
 */
public class FirstDuplineChar2 {

    private static void findFirstRepeat(String A, int n) {
        int sum = 1;// 新插入的key-value给value赋初始值都为1
        // 用LinkedHashMap来存储键值对
        // HashMap插入和输出顺序不一样
        // 但LinkedHashMap插入和输出顺序相同，即先存的先显示，也就是尾插
        // HashSet要求不能存重复元素，但HashMap和LinkedHashMap可以存重复元素。
        Map<String, Integer> hashMap = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            // 将main中传过来的String类型参数一个字符一个字符的转化为char类型，方便处理。
            char item = A.charAt(i);
            // 再将每一个char类型的字符转化为String类型。这一步操作和上一步操作作用是分离出每一个字符。
            String item2 = String.valueOf(item);
            String key = item2;
            // 判断是否包含指定的键值
            boolean contains = hashMap.containsKey(key);
            if (contains) { // 如果条件为真
                sum++;
                hashMap.put(item2, sum);// 输出信息
            } else {
                sum = 1;
                hashMap.put(item2, sum);
            }
        }
        // 输出存进哈希表中的所有键值对
        System.out.println(hashMap);
        // 以下是通过给定的value值反查key的过程
        // 将所有的键值对存在一个entrySet中
        // 遍历entrySet,若找到value等于给定的value值，则将其对应key值存在keyList中。
        List<String> keyList = new ArrayList<String>();
        for (Entry<String, Integer> e : hashMap.entrySet()) {
            if (e.getValue().equals(2)) {
                keyList.add(e.getKey());
            }
        }
        // 最后遍历keyList，输出第一次出现的key即可。
        for (String i : keyList) {
            System.out.println(i);
            break;
        }
    }

    public static void main(String[] args) {
        String A = "qywyer2333333333tdd";
        int n = A.length();
        findFirstRepeat(A, n);
    }
}
