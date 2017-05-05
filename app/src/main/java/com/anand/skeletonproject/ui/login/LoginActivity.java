package com.anand.skeletonproject.ui.login;

import android.os.Bundle;

import com.anand.skeletonproject.R;
import com.anand.skeletonproject.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
    }

    @Override
    protected void setUp() {

    }
}
