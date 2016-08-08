package net.gaddie.mfidtime.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.util.concurrent.TimeUnit;

import static net.gaddie.mfidtime.jna.timespec.CLOCK_REALTIME;

public class JnaClock {


    private final timespec.ByReference ts;

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
                Native.loadLibrary(("c"), CLibrary.class);

        void clock_gettime(int i, timespec ts);
    }

    public JnaClock() {
        ts = new timespec.ByReference();

    }

    public long currentTimeNanos(){
        CLibrary.INSTANCE.clock_gettime(CLOCK_REALTIME, ts);
        return TimeUnit.SECONDS.toNanos(ts.tv_sec) + ts.tv_nsec;
    }


    public static void main(String[] args) {
        System.out.println(new JnaClock().currentTimeNanos());
    }
}