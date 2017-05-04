package com.anand.skeletonproject.di.component;

import android.app.Application;
import android.content.Context;

import com.anand.skeletonproject.SkeletonApp;
import com.anand.skeletonproject.data.DataManager;
import com.anand.skeletonproject.di.ApplicationContext;
import com.anand.skeletonproject.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(SkeletonApp demoApp);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
