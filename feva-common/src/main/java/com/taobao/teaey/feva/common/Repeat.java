package com.taobao.teaey.feva.common;

/**
 * @author teaey masfay@163.com
 * @date 2014-05-23
 * @since 1.0.0.0
 */
public class Repeat {
    public static final void repeat(final Runnable r, final int round) {
        if (round < 1) {
            throw new IllegalArgumentException("round must > 0");
        }
        for (int i = 0; i < round; i++) {
            r.run();
        }
    }
}
