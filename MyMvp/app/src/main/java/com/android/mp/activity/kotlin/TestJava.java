package com.android.mp.activity.kotlin;

import com.ham.my_algorithm.other.demo.TestKt;

import org.jetbrains.annotations.NotNull;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

public class TestJava {

    public void testSuspend() {
        TestKt testKt = new TestKt();
        testKt.foo("a", new Continuation<Integer>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return null;
            }

            @Override
            public void resumeWith(@NotNull Object o) {

            }
        });

    }
}
