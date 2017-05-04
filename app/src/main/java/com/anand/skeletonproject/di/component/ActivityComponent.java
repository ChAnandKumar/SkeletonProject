package com.anand.skeletonproject.di.component;

import com.anand.skeletonproject.MainActivity;
import com.anand.skeletonproject.di.PerActivity;
import com.anand.skeletonproject.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
