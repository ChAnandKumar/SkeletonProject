package com.anand.skeletonproject.data;

import android.content.Context;

import com.anand.skeletonproject.data.db.DbHelper;
import com.anand.skeletonproject.data.db.item_model.Item;
import com.anand.skeletonproject.data.db.item_model.User;
import com.anand.skeletonproject.data.network.ApiHelper;
import com.anand.skeletonproject.data.network.ItemServices;
import com.anand.skeletonproject.data.prefs.PreferencesHelper;
import com.anand.skeletonproject.di.ApplicationContext;
import com.anand.skeletonproject.util.AppConstants;
import com.anand.skeletonproject.util.CommonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */
@Singleton
public class AppDataManager implements DataManager {


    private final Context mContext;
    private final DbHelper mDbHelper;
    private ApiHelper mApiHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ItemServices mItemServices;


    @Inject
    public AppDataManager(@ApplicationContext Context mContext, DbHelper mDbHelper,ApiHelper mApiHelper,
                          PreferencesHelper mPreferencesHelper, ItemServices mItemServices) {
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mApiHelper = mApiHelper;
        this.mPreferencesHelper = mPreferencesHelper;
        this.mItemServices = mItemServices;
    }

    @Override
    public Observable<Boolean> loadUserData() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        return mDbHelper.isUserEmpty().concatMap(isEmpty -> {
            if (isEmpty) {
                Type type = new TypeToken<User>() {
                }
                        .getType();
                User optionList = gson.fromJson(
                        CommonUtils.loadJSONFromAsset(mContext,
                                AppConstants.SEED_DATABASE_REPORT),
                        type);

                   /*User optionList = mItemServices.getItems();*/

                return insertUser(optionList);
            }
            return Observable.just(false);
        });
    }

    @Override
    public Observable<Boolean> loadItems() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        return mDbHelper.isItemEmpty().concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
            @Override
            public ObservableSource<? extends Boolean> apply(Boolean isEmpty) throws Exception {
                if (isEmpty) {
                    Type type = new TypeToken<List<Item>>() {
                    }
                            .getType();
                    List<Item> optionList = gson.fromJson(
                            CommonUtils.loadJSONFromAsset(mContext,
                                    AppConstants.SEED_DATABASE_REPORT),
                            type);

                    //List<Item> optionList = mItemServices.getItems();

                    //return saveItemList(optionList);
                    return  null;//temp
                }
                return Observable.just(false);
            }
        });
    }

    @Override
    public Observable<Boolean> syncItemData() {
        return null;
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);
    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode,
                               String userName, String email, String profilePicPath) {
        setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);
        setCurrentUserProfilePicUrl(profilePicPath);

        updateApiHeader(userId, accessToken);
    }


    @Override
    public void updateApiHeader(Long userId, String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<Boolean> isUserEmpty() {
        return mDbHelper.isUserEmpty();
    }

    @Override
    public Observable<User> getUserData() {
        return mDbHelper.getUserData();
    }

    @Override
    public Observable<List<Item>> getAllItems() {
        return mDbHelper.getAllItems();
    }

    @Override
    public Observable<Boolean> insertItem(Item item) {
        return mDbHelper.insertItem(item);
    }

    @Override
    public Observable<Boolean> isItemEmpty() {
        return mDbHelper.isItemEmpty();
    }

    @Override
    public Observable<Item> getItemData() {
        return mDbHelper.getItemData();
    }

    @Override
    public Observable<Boolean> saveItemList(List<Item> items) {
        return mDbHelper.saveItemList(items);
    }

    @Override
    public Observable<Boolean> updateFav(String itemId, boolean isFav) {
        return mDbHelper.updateFav(itemId,isFav);
    }

    @Override
    public Observable<Boolean> updateCartItem(String itemId, boolean isInCart) {
        return mDbHelper.updateCartItem(itemId,isInCart);
    }
}
