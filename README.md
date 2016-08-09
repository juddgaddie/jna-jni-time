#Performance comparison clock_gettime() in JNA and JNI 

Read the blog about this benchmark [here](http://wireddevelopment.blogspot.co.uk/2016/08/obtaining-time-in-java-with-nano-second.html).

##Requirements
Linux, tested on Fedora 23 will NOT work on OS X

##Build
[![Build Status](https://travis-ci.org/juddgaddie/jna-jni-time.svg?branch=master)](https://travis-ci.org/juddgaddie/jna-jni-time)
```
./gradlw build
```

##Run
```
./gradlw jmh
```

