package concurrency.atomic;

import org.junit.jupiter.api.Test;

/**
 * 实现线程顺序执行方式1：
 * 这是我做的艺龙的一道笔试题
 * 输入 hello
 * 线程1，2，3分别给这个字符串拼接 _a,_b,_c
 * 最后打印 hello_a_b_c
 * 这篇博客：https://blog.csdn.net/Small_Lee/article/details/79321871还记录了一些其他的方案
 */
public class Sample2 {
    private String s = "hello";
    @Test
    public void test() {
        final Alternate alternate = new Alternate();
        final Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                alternate.addA();
            }
        },"A");
        a.start();
        final Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.join();
                    alternate.addB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B");
        b.start();
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    b.join();
                    alternate.addC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C");
        c.start();
        try {
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    class Alternate{
        public void addA(){
            s += "_a";
        }
        public void addB(){
            s += "_b";
        }
        public void addC(){
            s += "_c";
        }
    }
}