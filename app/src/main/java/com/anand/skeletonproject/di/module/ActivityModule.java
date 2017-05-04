package com.anand.skeletonproject.di.module;

import android.app.Activity;
import android.content.Context;

import com.anand.skeletonproject.di.ActivityContext;
import com.anand.skeletonproject.di.PerActivity;
import com.anand.skeletonproject.ui.home.HomeMvpPresenter;
import com.anand.skeletonproject.ui.home.HomeMvpView;
import com.anand.skeletonproject.ui.home.HomePresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }


    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeMvpView> provideHomeView(HomePresenter<HomeMvpView> viewHomePresenter){
        return viewHomePresenter;
    }



}
