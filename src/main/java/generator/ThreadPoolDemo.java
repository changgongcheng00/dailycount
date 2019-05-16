package generator;

import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @ClassName ThreadPoolDemo
 * @Description TODO
 * @Author cheng
 * @Date 2019/4/23 9:00
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //核心线程池大小，线程池最大线程数，空闲线程存活时间，时间单位，队列，拒绝添加任务的策略
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            5, 10, 30, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadFactory() {//自定义线程
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    System.out.println(t);
                    return t;
                }
            },
            //new ThreadPoolExecutor.AbortPolicy()//抛出RejectedExecutionException异常
            //new ThreadPoolExecutor.CallerRunsPolicy()//由向线程池提交任务的线程来执行该任务
            new ThreadPoolExecutor.DiscardOldestPolicy()//抛弃最旧的任务（最先提交而没有得到执行的任务）
            //new ThreadPoolExecutor.DiscardPolicy()//抛弃当前的任务
        );

        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyReturnThread myReturnThread = new MyReturnThread();
        Future<Integer> future = threadPool.submit(myReturnThread);
        threadPool.execute(()->{
            try {
                myThread.run();
                myThread1.run();
                System.out.println("等待结果"+future.get());
                if(future.get() == null){
                    System.out.println("任务完成");
                }
            } catch (Exception e) {//InterruptedException,ExecutionException
                System.out.println(e.getCause().getMessage());
            }finally {
                threadPool.shutdown();
            }
        });
        //System.exit(0);

        //队列
        ScheduledExecutorService sch = Executors.newScheduledThreadPool(2);
        sch.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Stream<String> st;
            }
        },0,10,TimeUnit.MILLISECONDS);
    }

}

class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"线程"+i);
        }
    }
}
class MyReturnThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        for(int i = 90;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"线程"+i);
            Thread.sleep(100);
        }
        return 100;
    }
}
