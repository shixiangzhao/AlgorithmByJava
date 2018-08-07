package shixzh.abj.toutiao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 求一个字符串中第一个重复的字符，并统计每个字符重复的次数
 * 利用LinkedHashMap来存储键值对，HashMap插入和输出顺序不一样，但LinkedHashMap插入和输出顺序相同，即先存的先显示，也就是尾插
 * HashSet要求不能存重复元素，但HashMap和LinkedHashMap可以存重复元素。
 * @author shixiang.zhao
 */
public class FirstDuplicateChar2 {

    private static void findFirstRepeat(String A, int n) {
        // 以字符为key，以该字符的数量为value
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            // 将String类型按字符逐个转化为char类型
            char c = A.charAt(i);
            // 再将char类型的字符转化为String类型
            String key = String.valueOf(c);
            countChar(linkedHashMap, key);
        }
        // 输出存进哈希表中的所有键值对
        System.out.println("linkedHashMap: " + linkedHashMap);
        // 通过value值反查key的过程
        for (Entry<String, Integer> e : linkedHashMap.entrySet()) {
            if (!e.getValue().equals(1)) { // 第一个数量不为1的字符
                System.out.println("first duplicate char: " + e.getKey());
                break;
            }
        }
    }

    private static void findFirstRepeatChar(String A, int n) {
        // 以字符为key，以该字符的数量为value
        Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            // 将String类型按字符逐个转化为char类型
            char key = A.charAt(i);
            countChar(linkedHashMap, key);
        }
        // 输出存进哈希表中的所有键值对
        System.out.println("linkedHashMap: " + linkedHashMap);
        // 通过value值反查key的过程
        for (Entry<Character, Integer> e : linkedHashMap.entrySet()) {
            if (!e.getValue().equals(1)) { // 第一个数量不为1的字符
                System.out.println("first duplicate char: " + e.getKey());
                break;
            }
        }
    }

    public static <T> void countChar(Map<T, Integer> linkedHashMap, T key) {
        // 判断是否包含指定的键值
        boolean contains = linkedHashMap.containsKey(key);
        if (contains) { // key中已包含
            int sum = linkedHashMap.get(key);
            sum++;
            linkedHashMap.put(key, sum);
        } else { // key中第一次出现
            linkedHashMap.put(key, 1);
        }
    }

    public static void main(String[] args) {
        String A = "qywyerw2333333333tdyd";
        int n = A.length();
        findFirstRepeat(A, n);
        findFirstRepeatChar(A, n);
    }
}
