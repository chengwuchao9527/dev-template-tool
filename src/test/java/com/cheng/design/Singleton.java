package com.cheng.design;

/**
 * @author chengwuchao
 * @date 2023/6/26
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    /**
     * 懒汉式 线程不安全 synchronized 保证安全
     * @return
     */
    public static synchronized Singleton getSingletonInstance(){
        if (singleton == null){
            return new Singleton();
        }
        return singleton;
    }
}

class Singleton2{
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
    }

    public static synchronized Singleton2 getSingletonInstance(){
        return singleton2;
    }
}

enum Singleton3{
    SINGLETON_3
}
