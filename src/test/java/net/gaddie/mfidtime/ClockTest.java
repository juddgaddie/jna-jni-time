package net.gaddie.mfidtime;

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

}