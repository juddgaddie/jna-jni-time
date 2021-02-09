package net.gaddie.benchmark;


import net.gaddie.mfidtime.Clock;
import net.gaddie.mfidtime.jna.JnaClock;
import net.gaddie.mfidtime.jna.JnaClockNativeMapping;
import org.openjdk.jmh.annotations.*;

import java.time.Instant;
import java.util.concurrent.TimeUnit;
import jdk.internal.misc.VM;


@State(Scope.Benchmark)
public class GetCurrentTimeBenchmark {


    private Clock jniClock;
    private JnaClock jnaClock;
    private JnaClockNativeMapping jnaClockNativeMapping;

    @Setup
    public void setup(){
        jniClock = new Clock();
        jnaClock = new JnaClock();
        jnaClockNativeMapping = new JnaClockNativeMapping();
    }

    @Benchmark @BenchmarkMode(Mode.SampleTime)
    public long measureGetJavaCurrentTime(){
        return System.currentTimeMillis();
    }

    @Benchmark @BenchmarkMode(Mode.SampleTime)
    public long measureGetJava11CurrentWallClockNanos(){
        final long seconds =  TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        final long nanos = VM.getNanoTimeAdjustment(seconds);
        return TimeUnit.SECONDS.toNanos(seconds) + nanos;
    }

    @Benchmark @BenchmarkMode(Mode.SampleTime)
    public long measureJava11GetTimeFromInstant(){
        return TimeUnit.SECONDS.toNanos(Instant.now().getEpochSecond()) + Instant.now().getNano();
    }

    @Benchmark @BenchmarkMode(Mode.SampleTime)
    public long measureGetJNICurrentNanoTime(){
        return jniClock.nanoUTCTime();
    }

//    @Benchmark @BenchmarkMode(Mode.SampleTime)
//    public long measureGetJNACurrentNanoTime(){
//        return jnaClock.currentTimeNanos();
//    }

//    @Benchmark @BenchmarkMode(Mode.SampleTime)
//    public long measureGetJNADirectMappingCurrentNanoTime(){
//        return jnaClockNativeMapping.currentTimeNanos();
//    }

}
