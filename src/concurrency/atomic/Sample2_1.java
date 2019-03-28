package concurrency.atomic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现线程顺序执行方式1：
 * 这是我做的艺龙的一道笔试题
 * 输入 hello
 * 线程1，2，3分别给这个字符串拼接 _a,_b,_c
 * 最后打印 hello_a_b_c
 * 这篇博客：https://blog.csdn.net/Small_Lee/article/details/79321871还记录了一些其他的方案
 */
public class Sample2_1 {
    static String s = "hello";
    public static void main(String[] args) {
        final Alternate alternate = new Alternate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 2; i++) {
                    alternate.addA();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 2; i++) {
                    alternate.addB();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                alternate.addC();
            }
        }, "C").start();
    }
    static class Alternate {
        private int num = 1;
        private Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        public void addA() {
            lock.lock();
            try {
                if (num != 1) {
                    condition1.await();
                }
                s += "_a";
                num = 2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void addB() {
            lock.lock();
            try {
                if (num != 2) {
                    condition2.await();
                }
                s += "_b";
                num = 3;
                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void addC() {
            lock.lock();
            try {
                if (num != 3) {
                    condition3.await();
                }
                s += "_c";
                num = 3;
                System.out.println(s);
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

///**
// * 可参考的实现线程顺序执行方式3：
// * 同步方法结合wait和notify
// * 可以实现多轮打印
// */
//public class TestThread3 {
//    public static void main(String[] args) {
//        final Alternate alternate = new Alternate();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 2; i++) {
//                    alternate.printA();
//                }
//            }
//        }, "A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 2; i++) {
//                    alternate.printB();
//                }
//            }
//        }, "B").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 2; i++) {
//                    alternate.printC();
//                }
//            }
//        }, "C").start();
//    }
//    static class Alternate {
//        private int num = 1;
//        public synchronized void printA() {
//            try {
//                if (num != 1) {
//                    wait();
//                }
//                for (int i = 1; i <= 3; i++) {
//                    System.out.println(Thread.currentThread().getName() + i);
//                }
//                num = 2;
//                notifyAll();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        public synchronized void printB() {
//            try {
//                if (num != 2) {
//                    wait();
//                }
//                for (int i = 1; i <= 3; i++) {
//                    System.out.println(Thread.currentThread().getName() + i);
//                }
//                num = 3;
//                notifyAll();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        public synchronized void printC() {
//            try {
//                if (num != 3) {
//                    wait();
//                }
//                for (int i = 1; i <= 3; i++) {
//                    System.out.println(Thread.currentThread().getName() + i);
//                }
//                num = 3;
//                notifyAll();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}