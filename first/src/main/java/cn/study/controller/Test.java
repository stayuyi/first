package cn.study.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

/**
 * 用beforeAfterTest测试session缓存
 * <p>
 * Created by yuyi on 2018/9/16.
 */

public class Test {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    //这里用实例变量,会造成线程不安全


    @Before
    public void init() {
        System.out.println("before");


    }

    @After
    public void after() {
           System.out.println("before");
    }


    @org.junit.Test
    public void test() {
        System.out.println("test");
    }

}
