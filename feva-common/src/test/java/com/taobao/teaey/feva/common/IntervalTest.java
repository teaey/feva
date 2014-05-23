package com.taobao.teaey.feva.common;

import junit.framework.TestCase;

/**
 * @author teaey masfay@163.com
 * @date 2014-05-23
 * @since 1.0.0.0
 */
public class IntervalTest extends TestCase {
    public void test() {
        int round = 10000000;
        for (int i = 0; i < round; i++) {
            ElapseCounter.p();
            ElapseCounter.q();
            ElapseCounter.pn();
            ElapseCounter.qn();
        }

        long t = System.currentTimeMillis();

        for (int i = 0; i < round; i++) {
            long x = System.currentTimeMillis();
            long y = System.currentTimeMillis();
            long w = y - x;
        }
        long j = System.currentTimeMillis();
        System.out.println("System.currentTimeMillis use " + (j - t) + "ms");

        t = System.currentTimeMillis();

        for (int i = 0; i < round; i++) {
            ElapseCounter.p();
            ElapseCounter.q();
        }
        j = System.currentTimeMillis();
        System.out.println("pq use " + (j - t) + "ms");

        t = System.currentTimeMillis();
        for (int i = 0; i < round; i++) {
            ElapseCounter.pn();
            ElapseCounter.qn();
        }
        j = System.currentTimeMillis();
        System.out.println("pnqn use " + (j - t) + "ms");
    }
}
