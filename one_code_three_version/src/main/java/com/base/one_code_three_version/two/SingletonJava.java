package com.base.one_code_three_version.two;

import static java.sql.DriverManager.println;

/**
 * @author Jason
 * Java版单例
 */
public class SingletonJava {
    private static SingletonJava instance;

    private SingletonJava() {

    }

    public synchronized static SingletonJava getInstance() {
        if (instance == null) {
            instance = new SingletonJava();
        }
        return instance;
    }

    public void singletionTest() {
        println("--->singletion Java");
    }


}