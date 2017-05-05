package com.anand.skeletonproject;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.anand.skeletonproject.data.DataManager;
import com.anand.skeletonproject.di.component.ApplicationComponent;
import com.anand.skeletonproject.di.component.BusComponent;
import com.anand.skeletonproject.di.component.DaggerApplicationComponent;
import com.anand.skeletonproject.di.component.DaggerBusComponent;
import com.anand.skeletonproject.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

public class SkeletonApp extends Application {

    @Inject
    DataManager dataManager;

    private static BusComponent sBusComponent;
    private ApplicationComponent applicationComponent;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        this.applicationComponent.inject(this);
        sBusComponent = DaggerBusComponent.builder().build();

    }

    public static BusComponent getBusComponent() {
        return sBusComponent;
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

}
