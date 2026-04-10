package org.certification.threads;


import static java.lang.Thread.sleep;

class CountDown implements Runnable {
    String[] timeStr = {"ten", "nine", "eight", "seven", "six", "five", "four", "three", "two", "one"};

    @Override
    public void run() {
        for (String time : timeStr) {
            System.out.println(time);
            try {
                sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class TimeBomb {
    public static void main(String[] args) {
        Thread timer = new Thread(new CountDown());
        System.out.println("Bomb is ticking...");
        timer.start();
        try {
            timer.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Boom!!!!");
    }
}
