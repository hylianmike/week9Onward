package com.example.week9onward;

public class ThreadMain {

    public static void main(String[] args) {
        CustomThread thread1 = new CustomThread("Joey1");
        CustomThread thread2 = new CustomThread("Joey2");
        CustomThread thread3 = new CustomThread("Joey3");
        CustomThread thread4 = new CustomThread("Joey4");
        CustomThread thread5 = new CustomThread("Joey5");
        CustomThread thread6 = new CustomThread("Joey6");
        CustomThread thread7 = new CustomThread("Joey7");
        CustomThread thread8 = new CustomThread("Joey8");
        CustomThread thread9 = new CustomThread("Joey9");
        CustomThread thread10 = new CustomThread("Joey10");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        Runnable runnable = () -> {
            System.out.println("Started: " + Thread.currentThread().getName());
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ended: " + Thread.currentThread().getName());
        };

        Thread runnableObject = new Thread(runnable, "RunnableThreadOne");
        runnableObject.start();
    }

}
