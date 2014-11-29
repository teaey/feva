package cn.teaey.feva.common;

import junit.framework.TestCase;

import java.util.concurrent.locks.LockSupport;

/**
 * @author teaey masfay@163.com
 * @date 2014-05-23
 * @since 1.0.0.0
 */
public class IntervalTest extends TestCase {
    public void test() {
        long i = Interval.interval(new Runnable() {
            @Override
            public void run() {
                LockSupport.parkNanos(1000000);
            }
        }, 200);
        System.out.println(i);
    }
}
