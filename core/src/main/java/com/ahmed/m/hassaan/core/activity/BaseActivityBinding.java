package com.ahmed.m.hassaan.core.activity;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.ahmed.m.hassaan.core.activity.BaseActivity;


public abstract class BaseActivityBinding<BINDING extends ViewDataBinding> extends AppCompatActivity {


    BINDING binding;
//
//    public BaseActivityBinding() {
//        this.binding  = DataBindingUtil.setContentView(this, getLayoutId());
//    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutId());

    }


    @LayoutRes
    public abstract int getLayoutId();


    public BINDING getBinding() {
        return binding;
    }

    @Override
    protected void onDestroy() {
        if (binding != null) {
            binding.unbind();
            binding = null;
        }

        super.onDestroy();
    }


}
