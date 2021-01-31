package net.gaddie.benchmark;


import net.gaddie.mfidtime.Clock;
import net.gaddie.mfidtime.jna.JnaClock;
import net.gaddie.mfidtime.jna.JnaClockNativeMapping;
import org.openjdk.jmh.annotations.*;

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
    public long measureGetJNICurrentNanoTime(){
        return jniClock.nanoUTCTime();
    }

    @Benchmark @BenchmarkMode(Mode.SampleTime)
    public long measureGetJNACurrentNanoTime(){
        return jnaClock.currentTimeNanos();
    }

    @Benchmark @BenchmarkMode(Mode.SampleTime)
    public long measureGetJNADirectMappingCurrentNanoTime(){
        return jnaClockNativeMapping.currentTimeNanos();
    }

}
