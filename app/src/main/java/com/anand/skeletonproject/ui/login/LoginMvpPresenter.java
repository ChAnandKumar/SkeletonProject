package com.anand.skeletonproject.ui.login;

import com.anand.skeletonproject.di.PerActivity;
import com.anand.skeletonproject.ui.base.MvpPresenter;

/**
 * Created by anand.chandaliya on 05-05-2017.
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {
}
