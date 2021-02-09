package net.gaddie.mfidtime;

import jdk.internal.misc.VM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class ClockTest {
    @Test
    void shouldPrintTime() {
        final long nanoUTCTime = new Clock().nanoUTCTime();
        final long nanoTimeInMillis = TimeUnit.NANOSECONDS.toMillis(nanoUTCTime);
        final long now = System.currentTimeMillis();

        Assertions.assertTrue(now >= nanoTimeInMillis);
        Assertions.assertTrue(nanoTimeInMillis > 1612121394824L);
    }

    @Test
    void shouldPrintCorrectNanoTimeForJava11() {
        final long seconds =  TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        final long nanos = VM.getNanoTimeAdjustment(seconds);
        System.out.println(TimeUnit.SECONDS.toNanos(seconds) + nanos);
    }
}