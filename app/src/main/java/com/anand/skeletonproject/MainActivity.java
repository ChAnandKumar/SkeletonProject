package com.anand.skeletonproject;

import android.content.Intent;
import android.os.Bundle;

import com.anand.skeletonproject.ui.base.BaseActivity;
import com.anand.skeletonproject.ui.home.HomeActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        startActivity(new Intent(this, HomeActivity.class));

    }

    @Override
    protected void setUp() {

    }
}
