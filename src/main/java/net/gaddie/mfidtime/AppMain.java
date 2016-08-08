package net.gaddie.mfidtime;

public class AppMain {

    public static void main(String[] args) {
        final Clock clock = new Clock();
        final long nanoUTCTime = clock.nanoUTCTime();
        final long utcTimeMillis = System.currentTimeMillis();
        System.out.println("Time in Nanos from clock_gettime(CLOCK_REALTIME, &t): " + nanoUTCTime);
        System.out.println("Time in Nanos from System.currentMillis() * 1000: " + utcTimeMillis * 1000);
    }
}
