package net.gaddie.mfidtime.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;


public class timespec extends Structure {
    protected static final int CLOCK_REALTIME = 0;
    protected static final int CLOCK_MONOTONIC = 1;
    protected static final int CLOCK_PROCESS_CPUTIME_ID = 2;
    protected static final int CLOCK_THREAD_CPUTIME_ID = 3;
    protected static final int CLOCK_MONOTONIC_RAW = 4;
    protected static final int CLOCK_REALTIME_COARSE = 5;
    protected static final int CLOCK_MONOTONIC_COARSE = 6;
    protected static final int CLOCK_BOOTTIME = 7;
    protected static final int CLOCK_REALTIME_ALARM = 8;
    protected static final int CLOCK_BOOTTIME_ALARM = 9;
    protected static final int CLOCK_SGI_CYCLE = 10;     /* Hardware specific */
    protected static final int CLOCK_TAI = 11;

    /**
     * Seconds.<br>
     * C type : __time_t
     */
    public long tv_sec;
    /**
     * Nanoseconds.<br>
     * C type : __syscall_slong_t
     */
    public long tv_nsec;

    public timespec() {
        super();
    }

    protected List<?> getFieldOrder() {
        return Arrays.asList("tv_sec", "tv_nsec");
    }

    protected ByReference newByReference() {
        return new ByReference();
    }

    protected ByValue newByValue() {
        return new ByValue();
    }

    protected timespec newInstance() {
        return new timespec();
    }

    public static class ByReference extends timespec implements Structure.ByReference {
    }


    public static class ByValue extends timespec implements Structure.ByValue {

    }

}
