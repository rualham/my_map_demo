package com.android.mp.activity.kotlin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.coroutines.Continuation;
import retrofit2.Response;

public class TestRetrofit implements INetApi{

    @Nullable
    @Override
    public Object getBaidu(@NotNull String url, @NotNull Continuation<? super Response<String>> $completion) {
        return null;
    }
}
