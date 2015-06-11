package cn.teaey.feva.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author teaey masfay@163.com
 * @date 2014-10-19
 * @since 1.0.0
 */
public class Debug {
    public static final String readLine(InputStream in) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        return r.readLine();
    }

    public static final Integer readLineForInteger(InputStream in) throws IOException {
        String str = readLine(in);
        return Integer.valueOf(str);
    }

    public static final Long readLineForLong(InputStream in) throws IOException {
        String str = readLine(in);
        return Long.valueOf(str);
    }

    public static final Float readLineForFloat(InputStream in) throws IOException {
        String str = readLine(in);
        return Float.valueOf(str);
    }

    public static final Double readLineForDouble(InputStream in) throws IOException {
        String str = readLine(in);
        return Double.valueOf(str);
    }

    public static final Short readLineForShort(InputStream in) throws IOException {
        String str = readLine(in);
        return Short.valueOf(str);
    }

    public static final Byte readLineForByte(InputStream in) throws IOException {
        String str = readLine(in);
        return Byte.valueOf(str);
    }

    public static final String readLine() throws IOException {
        return readLine(System.in);
    }

    public static final Integer readLineForInteger() throws IOException {
        return readLineForInteger(System.in);
    }

    public static final Long readLineForLong() throws IOException {
        return readLineForLong(System.in);
    }

    public static final Float readLineForFloat() throws IOException {
        return readLineForFloat(System.in);
    }

    public static final Double readLineForDouble() throws IOException {
        return readLineForDouble(System.in);
    }

    public static final Short readLineForShort() throws IOException {
        return readLineForShort(System.in);
    }

    public static final Byte readLineForByte() throws IOException {
        return readLineForByte(System.in);
    }
}
