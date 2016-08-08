package net.gaddie.mfidtime.jna;


import com.sun.jna.Native;
import com.sun.jna.Platform;

import java.util.concurrent.TimeUnit;

public class JnaClockNativeMapping {

    private final timespec.ByReference ts;

    public static native void clock_gettime(int i, timespec ts);

    static {
        Native.register(Platform.C_LIBRARY_NAME);
    }

    public JnaClockNativeMapping() {
        ts = new timespec.ByReference();

    }

    public long currentTimeNanos() {
        clock_gettime(timespec.CLOCK_REALTIME, ts);
        return TimeUnit.SECONDS.toNanos(ts.tv_sec) + ts.tv_nsec;
    }

    public static void main(String[] args) {
        final JnaClockNativeMapping jnaClockNativeMapping = new JnaClockNativeMapping();
        System.out.println(jnaClockNativeMapping.currentTimeNanos());
    }
}
