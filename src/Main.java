import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@FunctionalInterface
interface GreetingService {
    void sayMessage(String message);
}

public class Main {

    /**
     * 1、Lambda表达式
     */
    public void Lambda() {
        Arrays.asList("a", "b", "a").forEach(e -> System.out.println(e));
    }

    /**
     * 2、接口的默认方法与静态方法
     */
    public void FunctionalInterface() {
        GreetingService service = message -> System.out.println("实现1: " + message);
        service.sayMessage("hello");

        service = message -> System.out.println("实现2: " + message);
        service.sayMessage("hello");
    }

    /**
     * 方法引用
     */
    public void sayHello(GreetingService service, String msg) {
        service.sayMessage(msg);
    }

    /**
     * Optional
     */
    public void sum() {
        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(null);
        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(new Integer(10));

        // Optional.isPresent - 判断值是否存在
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();

        System.out.println(value1 + value2);
    }

    public String test(String allIds, String ids) {
        StringBuffer temp = new StringBuffer();
        for (String allId : allIds.split(",")) {
            boolean exits = false;
            for (String id : ids.split(",")) {
                if (allId.equals(id)) {
                    exits = true;
                    break;
                }
            }
            if (!exits)
                temp.append(allId + ",");
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        //main.Lambda();
        //main.FunctionalInterface();
        //main.sayHello(System.out::print, "hello");
        //main.sum();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入allIds：");
        String allIds = sc.nextLine();
        System.out.println("请输入ids：");
        String ids = sc.nextLine();
        System.out.println(main.test(allIds, ids));
    }
}
