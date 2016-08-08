
# OpenJDK 8 code that called from System.currentTimeMillis();
#http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/87ee5ee27509/src/os/linux/vm/os_linux.cpp#l1364

# http://juliusdavies.ca/posix_clocks/clock_realtime_linux_faq.html
#Shows current clock source
cat /sys/devices/system/clocksource/*/current_clocksource

#Show available clock sources
/sys/devices/system/clocksource/*/available_clocksource

cd src/main/java
javah net.gaddie.mfidtime.Clock
javac net/gaddie/mfidtime/Clock.java

cd src/nativetime
gcc -fPIC -O2 -I $JAVA_HOME/include -I $JAVA_HOME/include/linux -I headers/ -shared -o libnativetime.so c/nativetime.c
java -Djava.library.path=$(pwd)  -cp . com.transficc.highrestime.Clock