package generator;

/**
 * @ClassName Tests
 * @Description TODO
 * @Author cheng
 * @Date 2019/4/25 21:05
 **/
public class Tests {

    //    CompletableFuture
//    LinkedBlockingQueue
    private static void test(){
        StringBuffer sb = new StringBuffer();
        sb.append("a");
        sb.append(2);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        String a = "";
        int b = 123;
        Integer.parseInt(a);//Character.digit
        Integer.valueOf(a);//parseInt
        Tests.test();
    }

}
