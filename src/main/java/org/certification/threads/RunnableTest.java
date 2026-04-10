package org.certification.threads;

import java.util.concurrent.*;

public class RunnableTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future = es.submit(() -> 3+5);
        try{
            System.out.println("The answer is: "+future.get(500, TimeUnit.MICROSECONDS));
        }catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }finally {
            es.shutdown();
        }
    }
}
