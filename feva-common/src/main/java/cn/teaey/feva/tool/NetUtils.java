package cn.teaey.feva.tool;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Enumeration;

/**
 * @author xiaofei.wxf on 2015/6/11.
 * @since 1.0.2
 */
public final class NetUtils {
    private static class _IP_ {

        private static volatile String ipString;
        private static volatile int ipInt32;
        private static volatile byte[] ipBytes;
        private static final ByteBuffer byteBuffer = ByteBuffer.allocate(4);

        private static void init() {
            try {
                Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
                while (enumeration.hasMoreElements()) {
                    NetworkInterface networkInterface = enumeration.nextElement();
                    if (networkInterface.isVirtual()) {
                        continue;
                    }
                    Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
                    while (addressEnumeration.hasMoreElements()) {
                        InetAddress address = addressEnumeration.nextElement();
                        if (address instanceof Inet6Address) {
                            continue;
                        }
                        if (null != address && !address.isLoopbackAddress()) {
                            ipBytes = address.getAddress();
                            ipString = address.getHostAddress();
                            byteBuffer.put(ipBytes, 0, 4);
                            byteBuffer.rewind();
                            ipInt32 = byteBuffer.getInt();
                            return;
                        }
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    private static class _MAC_ {

        private static volatile long macInt64;
        private static volatile byte[] macBytes;
        private static final ByteBuffer byteBuffer = ByteBuffer.allocate(8);


        private static void init() {
            try {
                Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
                while (enumeration.hasMoreElements()) {
                    NetworkInterface networkInterface = enumeration.nextElement();
                    if (networkInterface.isVirtual()) {
                        continue;
                    }
                    Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
                    while (addressEnumeration.hasMoreElements()) {
                        InetAddress address = addressEnumeration.nextElement();
                        if (address instanceof Inet6Address) {
                            continue;
                        }
                        if (null != address && !address.isLoopbackAddress()) {
                            macBytes = networkInterface.getHardwareAddress();
                            byteBuffer.position(0);
                            byteBuffer.put((byte) 0);
                            byteBuffer.put((byte) 0);
                            byteBuffer.put(macBytes);
                            byteBuffer.rewind();
                            macInt64 = byteBuffer.getLong();
                            return;
                        }
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    public static long getMacInt64() {
        if (0 == _MAC_.macInt64) {
            _MAC_.init();
        }
        return _MAC_.macInt64;
    }

    public static byte[] getMacBytes() {
        if (null == _MAC_.macBytes) {
            _MAC_.init();
        }
        return _MAC_.macBytes;
    }

    public static String getIpString() {
        if (null == _IP_.ipString) {
            _IP_.init();
        }
        return _IP_.ipString;
    }

    public static byte[] getIpBytes() {
        if (null == _IP_.ipBytes) {
            _IP_.init();
        }
        return _IP_.ipBytes;
    }

    public static int getIpInt32() {
        if (_IP_.ipInt32 == 0) {
            _IP_.init();
        }
        return _IP_.ipInt32;
    }
}
