package concurrency.atomic;

import java.util.concurrent.CountDownLatch;

/**
 *CountDownLatch:在完成一组正在其他线程中执行的操作之前，
 * 它允许一个或多个线程一直等待。
 *重点方法：
 * await():当CountDownLatch的计数为0之前，await所在的线程才是挂起的
 */
public class Sample2_2 {
    //保证A和B之前的顺序
    static CountDownLatch latch = new CountDownLatch(1);
    //保证B和C之间的关系
    static CountDownLatch latch2 = new CountDownLatch(1);
    public static void main(String[] args) {
        final Alternate alternate = new Alternate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    alternate.printA();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    alternate.printB();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    alternate.printC();
                }
            }
        }, "C").start();
    }
    static class Alternate {
        public void printA() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            latch.countDown();
        }
        public void printB() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            latch2.countDown();
        }
        public void printC() {
            try {
                latch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}