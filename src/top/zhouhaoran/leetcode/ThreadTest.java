package top.zhouhaoran.leetcode;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    public static void main(String[] args) {
//        Thread thread = new Thread(new MyThread1("Thread-1"));
//        thread.start();
//        Thread thread2 = new Thread(new MyThread1("Thread-2"));
//        thread2.start();

//        MyThread2 myThread2 = new MyThread2("Haoran-1");
//        myThread2.start();
//        MyThread2 myThread2_2 = new MyThread2("Haoran-2");
//        myThread2_2.start();

//        MyThread3 myThread3 = new MyThread3("haoran-3");
//        myThread3.start();
//        MyThread3 myThread3_2 = new MyThread3("haoran-4");
//        myThread3_2.start();

//        MyThread4 myThread4 = new MyThread4("Haoran-5");
//        myThread4.start();
//        MyThread4 myThread4_2 = new MyThread4("Haoran-6");
//        myThread4_2.start();
//        CallableThreadTest ctt = new CallableThreadTest();
//        FutureTask<Integer> ft = new FutureTask<>(ctt);
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
//            if (i == 20) {
//                new Thread(ft, "111111111111有返回值的线程").start();
//            }
//        }
//
//        try {
//            System.out.println("子线程的返回值: " + ft.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        new Stage().start();


    }
}

class MyThread1 implements Runnable {
    private String threadName;

    public MyThread1(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("线程 " + threadName + ": " + i);
        }
    }
}

class MyThread2 implements Runnable {
    private String threadName;

    public MyThread2(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("线程 " + threadName + ": " + i);
        }
    }

    public void start() {
        Thread thread = new Thread(this, threadName);
        thread.start();
    }
}

class MyThread3 extends Thread {
    private Thread t;
    private String threadName;

    public MyThread3(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + "exiting");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, this.threadName);
            t.start();
        }
    }
}

class MyThread4 extends Thread {
    private String threadName;

    public MyThread4(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Thread: " + this.threadName + " " + i);
        }
    }
}

class CallableThreadTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " dldlaldldaldaldld哈哈" + i);
        }
        return i;
    }
}

class Stage extends Thread {
    @Override
    public void run() {
        System.out.println("欢迎观看隋唐演义");
        // 让观众们安静片刻, 等待大戏上演

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("话说隋朝末年, 隋军与农民起义军杀的昏天黑地...");
        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        Thread armOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
        Thread armOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

        // 启动线程, 让军队开始作战
        armOfSuiDynasty.start();
        armOfRevolt.start();

        // 舞台休眠, 让大家专心观看厮杀
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣, 半路杀出个程咬金");
        Thread mrCheng = new KeyPerson();
        mrCheng.setName("程咬金");
        System.out.println("程咬金的梦想就是结束战争, 使百姓安居乐业!");

        // 停止军队作战
        // 停止线程的方法
        armyTaskOfRevolt.keepRunning = false;
        armyTaskOfSuiDynasty.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
            历史大戏留给关键任务
         */
        mrCheng.start();

        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        armyTaskOfRevolt.keepRunning = true;
        armyTaskOfSuiDynasty.keepRunning = true;

        System.out.println("战争结束, 人民安居乐业, 程先生实现了人生理想");
        System.out.println("谢谢观看隋唐演义, 再见!");
    }
}

class ArmyRunnable implements Runnable {
    volatile boolean keepRunning = true;
    @Override
    public void run() {
        while (keepRunning) {
            // 发动五连击
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "进攻对方[" + i + "]");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗");
    }
}

class KeyPerson extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始了战斗!");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "左突右杀人,攻击隋军");
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗!");
    }
}

