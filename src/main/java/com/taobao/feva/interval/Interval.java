package com.taobao.feva.interval;

/**
 * @author wxf on 14-5-16.
 */
public class Interval {

    static final class TimeCounter {
        static final class LocalData {
            long data;
        }

        private static final ThreadLocal<LocalData> timestamp = new ThreadLocal<LocalData>() {
            @Override
            protected LocalData initialValue() {
                return new LocalData();
            }
        };
        private static final ThreadLocal<LocalData> timestampNanos = new ThreadLocal<LocalData>() {
            @Override
            protected LocalData initialValue() {
                return new LocalData();
            }
        };

        static final void p() {
            timestamp.get().data = System.currentTimeMillis();
        }

        static final long q() {
            return System.currentTimeMillis() - timestamp.get().data;
        }

        static final void pn() {
            timestamp.get().data = System.nanoTime();
        }

        static final long qn() {
            return System.nanoTime() - timestampNanos.get().data;
        }
    }
}
