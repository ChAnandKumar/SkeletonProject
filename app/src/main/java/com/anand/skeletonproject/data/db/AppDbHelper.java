package com.anand.skeletonproject.data.db;

import com.anand.skeletonproject.data.db.item_model.DaoMaster;
import com.anand.skeletonproject.data.db.item_model.DaoSession;
import com.anand.skeletonproject.data.db.item_model.Item;
import com.anand.skeletonproject.data.db.item_model.User;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

public class AppDbHelper implements DbHelper {


    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return Observable.fromCallable(() -> {
            mDaoSession.getUserDao().saveInTx(user);
            return true;
        });
    }

    @Override
    public Observable<Boolean> isUserEmpty() {
        return Observable.fromCallable(() -> !(mDaoSession.getUserDao().count()>0));
    }

    @Override
    public Observable<User> getUserData() {
        return Observable.fromCallable(() -> (User) mDaoSession.getUserDao().loadAll());
    }

    @Override
    public Observable<List<Item>> getAllItems() {
        return Observable.fromCallable(() -> mDaoSession.getItemDao().loadAll());
    }

    @Override
    public Observable<Boolean> insertItem(Item item) {
        return Observable.fromCallable(() -> {
            mDaoSession.getItemDao().saveInTx(item);
            return true;
        });
    }

    @Override
    public Observable<Boolean> isItemEmpty() {
        return Observable.fromCallable(() -> !(mDaoSession.getItemDao().count()>0));
    }

    @Override
    public Observable<Item> getItemData() {
        return Observable.fromCallable(() -> (Item) mDaoSession.getItemDao().loadAll());
    }

    @Override
    public Observable<Boolean> saveItemList(List<Item> items) {
        return Observable.fromCallable(() -> {
            mDaoSession.getItemDao().saveInTx(items);
            return true;
        });
    }

    @Override
    public Observable<Boolean> updateFav(String itemId, boolean isFav) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return null;
            }
        });
    }

    @Override
    public Observable<Boolean> updateCartItem(String itemId, boolean isInCart) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return null;
            }
        });
    }
}
