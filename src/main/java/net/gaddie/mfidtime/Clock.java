package net.gaddie.mfidtime;


public class Clock {
    static {
        System.loadLibrary("nativetime"); // by convention libnativetime.so
    }

    private native long currentTimeNanos();

    public long nanoUTCTime() {
        return currentTimeNanos();
    }
}
