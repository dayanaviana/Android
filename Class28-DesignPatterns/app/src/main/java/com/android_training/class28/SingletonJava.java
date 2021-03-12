package com.android_training.class28;

public class SingletonJava {

    private static int count = 0;
    private static SingletonJava instance;

    private SingletonJava(){
        this.count++;
    }

    public static SingletonJava getInstance(){
        if(instance==null){
            instance = new SingletonJava();
        }
        return instance;
    }

    public int getCount(){
        return count;
    }
}
