package shixzh.abj.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List删除偶数项的最高效算法
 */
public class ListRemoveOperation {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(2);
        lst.add(6);
        lst.add(9);
        lst.add(1);
        //removeEvensVerl(lst);
        //removeEvensVerl2(lst); //ConcurrentModificationException
        removeEvensVerl3(lst);
        for (Integer i : lst) {
            System.out.print(i + " ");
        }
    }

    public static void removeEvensVerl(List<Integer> lst) {
        int i = 0;
        while (i < lst.size()) { // 1. 下标删除
            if (lst.get(i) % 2 == 0) { // get对于LinkedList 二次时间
                lst.remove(i); // remove对于ArrayList二次时间
            } else {
                i++;
            }
        }
    }

    public static void removeEvensVerl2(List<Integer> lst) {
        for (Integer i : lst) { // 2. foreach 删除
            if (i % 2 == 0) {
                lst.remove(i); // ConcurrentModificationException
            }
        }
    }

    public static void removeEvensVerl3(List<Integer> lst) {
        Iterator<Integer> itr = lst.iterator(); // 对于LinkedList线性时间（写操作）
        while (itr.hasNext()) { // 3. 迭代器删除
            if (itr.next() % 2 == 0) {
                itr.remove(); // 对于ArrayList二次时间（读操作）
            }
        }
    }
}
