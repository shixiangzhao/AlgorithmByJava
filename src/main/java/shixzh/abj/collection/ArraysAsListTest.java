package shixzh.abj.collection;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Arrays.asList不支持基本类型，除非自动打包成封装类型
 * 基本数据类型打印的都是地址值，而String类型的数组输出的是数组中的元素，这是为啥嘞？
 * 通过引用Arrays.asList(T...a)方法，可以知道括号中需要一个含数据类型的实参（T一般就是泛型的意思），
 * 而基本数据类型是没有类型（非要用的话可以借助他们的包装类）；可是为什么不满足类型还能使用嘞？
 * 因为数组也是一个类型（下面的方法是没问题的）；也就是说基本数据类型转集合遍历是需要借助其他方法。
 * <p>
 * 2. 此集合是根据数组获得，长度已经固定，不能改变。
 * 在使用Arrays.asList()后调用add，remove这些method时出现
 * java.lang.UnsupportedOperationException异常。
 * 这是由于Arrays.asList() 返回java.util.Arrays$ArrayList， 而不是ArrayList。
 * Arrays$ArrayList和ArrayList都是继承AbstractList，remove，add等method。
 * 在AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
 * ArrayList override这些method来对list进行操作，但是Arrays$ArrayList没有override remove()，add()等，
 * 所以throw UnsupportedOperationException。
 */
public class ArraysAsListTest {
    public static void main(String[] args) {
        // char
        char[] mChar = {'a', 'b'};
        System.out.println("---->char" + Arrays.asList(mChar));
        // char2
        System.out.println("---->char2" + Arrays.asList('a', 'b'));
        // int
        int[] mInt = {1, 23, 4, 5, 56, 77};
        System.out.println("---->int" + Arrays.asList(mInt));
        // int2
        System.out.println("---->int2" + Arrays.asList(1, 23, 4, 5, 56, 77));
        // boolean
        boolean[] mBoolean = {true, false};
        System.out.println("---->boolean" + Arrays.asList(mBoolean));
        // double
        double[] mDouble = {1.1, 2.4, 5.6, 7.8};
        System.out.println("---->double" + Arrays.asList(mDouble));
        // String
        String mString[] = {"花花", "草草", "纷纷"};
        System.out.println("---->String" + Arrays.asList(mString));

        List<String> list = Arrays.asList(mString);
        list.add("ss");// java.lang.UnsupportedOperationException
    }

}
