package com.taobao.teaey.feva.common;

import junit.framework.TestCase;

import java.util.concurrent.locks.LockSupport;

/**
 * @author teaey masfay@163.com
 * @date 2014-05-23
 * @since 1.0.0.0
 */
public class ElapseTest extends TestCase {
    public void test(){
        System.out.println("1 millis");
        park(1);

        System.out.println("10 millis");
        park(10);

        System.out.println("100 millis");
        park(100);
    }

    void park(int mills){
        Elapse.p();
        LockSupport.parkNanos(mills * 1000000);
        System.out.println(Elapse.q());
    }
}
