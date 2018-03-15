package shixzh.abj.basetype;

/**
 * 静态变量与静态代码块之间的执行先后顺序测试
 * http://blog.csdn.net/meegomeego/article/details/47295237
 * @author shixiang.zhao
 *
 */
public class StaticBlockOrderTest {

    // 静态变量 
    public static TestA a = new TestA();

    // 静态初始化块 
    static {
        System.out.println("静态初始化块");
        System.out.println(a);
        //System.out.println(b); //will be wrong.
        
    }

    // 静态变量 
    public static TestB b = new TestB();

    public static void main(String[] args) {
        new StaticBlockOrderTest();
    }
}

class TestA {

    public TestA() {
        System.out.println("Test--A");
    }
}

class TestB {

    public TestB() {
        System.out.println("Test--B");
    }
}
