package com.anand.skeletonproject.ui.home;

import com.anand.skeletonproject.di.PerActivity;
import com.anand.skeletonproject.ui.base.MvpPresenter;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */
@PerActivity
public interface HomeMvpPresenter<V extends HomeMvpView> extends MvpPresenter<V> {
}
