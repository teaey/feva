package com.taobao.teaey.feva.common;

/**
 * @author teaey masfay@163.com
 * @date 2014-05-23
 * @since 1.0.0.0
 */
public class Interval {
    public static final long interval(Runnable r, int round){
        ElapseCounter.p();
        Repeat.repeat(r, round);
        return ElapseCounter.q();
    }
    public static final long intervalNanos(Runnable r, int round){
        ElapseCounter.pn();
        Repeat.repeat(r, round);
        return ElapseCounter.qn();
    }
}
