package com.anand.skeletonproject.ui.home;

import android.util.Log;

import com.anand.skeletonproject.data.DataManager;
import com.anand.skeletonproject.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> implements HomeMvpPresenter<V> {

    @Inject
    public HomePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        Log.i("anand","in onAttach of Home Presenter");
    }
}
