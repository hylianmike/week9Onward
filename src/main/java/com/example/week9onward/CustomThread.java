package com.example.week9onward;

public class CustomThread extends Thread {

    public CustomThread(String name){
        this.setName(name);
    }

    public void run(){
        System.out.println("Started: " + Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ended: " + Thread.currentThread().getName());
    }

}
