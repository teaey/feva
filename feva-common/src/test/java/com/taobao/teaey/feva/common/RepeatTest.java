package com.taobao.teaey.feva.common;

import junit.framework.TestCase;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author teaey masfay@163.com
 * @date 14-5-23
 * @since 1.0.0.0
 */
public class RepeatTest extends TestCase {
    public void test(){
        final AtomicInteger count = new AtomicInteger();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.print(count.incrementAndGet());
                System.out.print("-");
            }
        };
        System.out.println(10);
        Repeat.repeat(r, 10);
    }
}
