package com.taobao.feva.interval;

import com.taobao.feva.interval.Interval.TimeCounter;
import org.junit.Test;

/**
 * @author wxf on 14-5-16.
 */
public class IntervalTest {
    @Test
    public void cpa() {
        for (int i = 0; i < 10000000; i++) {
            TimeCounter.p();
            TimeCounter.q();
            TimeCounter.pn();
            TimeCounter.qn();
        }

        long t = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            long x = System.currentTimeMillis();
            long y = System.currentTimeMillis();
            long w = y - x;
        }
        long j = System.currentTimeMillis();
        System.out.println(j - t);

        t = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            TimeCounter.p();
            TimeCounter.q();
        }
        j = System.currentTimeMillis();
        System.out.println(j - t);

        t = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            TimeCounter.pn();
            TimeCounter.qn();
        }
        j = System.currentTimeMillis();
        System.out.println(j - t);

    }
}
