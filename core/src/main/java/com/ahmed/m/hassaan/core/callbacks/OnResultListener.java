package com.ahmed.m.hassaan.core.callbacks;

import android.app.Instrumentation;

import androidx.activity.result.ActivityResult;

public interface OnResultListener {

    void onResult(ActivityResult result, int requestCode);

}
