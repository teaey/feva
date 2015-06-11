package cn.teaey.feva.tool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaofei.wxf on 2015/6/11.
 * @since 1.0.2
 */
public final class IDGenerator {
    private static final AtomicInteger SEED = new AtomicInteger(0x3b9aca00);

    public static String newStringId() {
        StringBuilder ret = new StringBuilder();
        ret.append(NetUtils.getMacInt64()).append("_").append(NetUtils.getIpInt32()).append("_").append(System.currentTimeMillis()).append("_").append(SEED.incrementAndGet());
        return ret.toString();
    }

    public static long newLongId() {
        return ((long) NetUtils.getIpInt32()) << 32 | SEED.incrementAndGet();
    }

}
