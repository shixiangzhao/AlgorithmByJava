package shixzh.abj.basetype;

/**
 * 静态变量，静态初始化块，变量，初始化块，构造器的执行顺序测试
 * @author shixiang.zhao
 *
 */
public class InitialOrderTest extends InitialOrderParent {

    // 静态变量 
    public static String staticField = "静态变量";
    // 变量 
    public String field = "变量";

    // 静态初始化块 
    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    // 初始化块 
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 构造器 
    public InitialOrderTest() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}

class InitialOrderParent extends InitialOrderParent2{

    // 静态变量 
    public static String staticField = "父类-静态变量";
    // 变量 
    public String field = "父类-变量";

    // 静态初始化块 
    static {
        System.out.println(staticField);
        System.out.println("父类-静态初始化块");
    }

    // 初始化块 
    {
        System.out.println(field);
        System.out.println("父类-初始化块");
    }

    // 构造器 
    public InitialOrderParent() {
        System.out.println("父类-构造器");
    }
}

class InitialOrderParent2 {

    // 静态变量 
    public static String staticField = "父类2-静态变量";
    // 变量 
    public String field = "父类2-变量";

    // 静态初始化块 
    static {
        System.out.println(staticField);
        System.out.println("父类2-静态初始化块");
    }

    // 初始化块 
    {
        System.out.println(field);
        System.out.println("父类2-初始化块");
    }

    // 构造器 
    public InitialOrderParent2() {
        System.out.println("父类2-构造器");
    }
}
