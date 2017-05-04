package com.anand.skeletonproject.di.module;

import android.app.Application;
import android.content.Context;

import com.anand.skeletonproject.BuildConfig;
import com.anand.skeletonproject.data.AppDataManager;
import com.anand.skeletonproject.data.DataManager;
import com.anand.skeletonproject.data.db.AppDbHelper;
import com.anand.skeletonproject.data.db.DbHelper;
import com.anand.skeletonproject.data.network.ApiHeader;
import com.anand.skeletonproject.data.network.ApiHelper;
import com.anand.skeletonproject.data.network.AppApiHelper;
import com.anand.skeletonproject.data.network.ItemServices;
import com.anand.skeletonproject.data.prefs.AppPreferencesHelper;
import com.anand.skeletonproject.data.prefs.PreferencesHelper;
import com.anand.skeletonproject.di.ApiInfo;
import com.anand.skeletonproject.di.ApplicationContext;
import com.anand.skeletonproject.di.DatabaseInfo;
import com.anand.skeletonproject.di.PreferenceInfo;
import com.anand.skeletonproject.util.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }


    @Provides
    @ApplicationContext
    Context provideContext(){
        return application;
    }

    @Provides
    Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper dbHelper){
        return dbHelper;
    }

    @Provides
    @PreferenceInfo
    String getPrefsName(){
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePrefsHelper(AppPreferencesHelper prefHelper){
        return prefHelper;
    }

    @Provides
    @Singleton
    ItemServices provideRestFullService() {
        return ItemServices.Creator.newRibotsService();
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

}
