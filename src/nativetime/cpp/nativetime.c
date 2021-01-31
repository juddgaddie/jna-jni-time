#include <time.h>
#include <sys/time.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <jni.h>
#include "clock.h"


#define SECONDS      1000000000
#define NANOSECONDS  1

JNIEXPORT jlong JNICALL Java_net_gaddie_mfidtime_Clock_currentTimeNanos
  (JNIEnv *env, jobject thisObj) {

      struct timespec t;
      int r;
      // Implemented as vDSO on modern kernels
      r = clock_gettime(CLOCK_REALTIME, &t);
      uint64_t nowNanos = (uint64_t) t.tv_sec * SECONDS + t.tv_nsec * NANOSECONDS;

      if (r != 0) {
              fprintf(stderr ,"ERROR: Failed, clock_gettime(CLOCK_REALTIME) returned %i exiting \n", r);
              return (jlong)0;
      }
      return (jlong) nowNanos;
}


