package generator;

/**
 * @ClassName Singlton
 * @Description TODO 单例-静态内部类  5中
 * @Author cheng
 * @Date 2019/4/16 0:13
 **/
public class Singlton {
    private static class SingltonHolder{
        private static final Singlton INATANCE = new Singlton();
    }
    private Singlton(){}
    public static final Singlton getInstance (){
        return SingltonHolder.INATANCE;
    }
}

/**
 * Description 私有构造器，静态get方法
 * @Date 2019/4/16 0:30
 * @Author zhangcheng
 */
class DoubleSinglton{
    private volatile static DoubleSinglton singlton;
    private DoubleSinglton(){}
    public static DoubleSinglton getSinglton(){
        if(singlton == null){
            synchronized (DoubleSinglton.class){
                if(singlton == null){
                    singlton = new DoubleSinglton();
                }
            }
        }
        return singlton;
    }
}
