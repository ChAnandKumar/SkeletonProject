package com.anand.skeletonproject.data;

import com.anand.skeletonproject.data.db.DbHelper;
import com.anand.skeletonproject.data.prefs.PreferencesHelper;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

public interface DataManager extends DbHelper,PreferencesHelper{


    Observable<Boolean> loadUserData();
    Observable<Boolean> loadItems();

    Observable<Boolean> syncItemData();

    void updateApiHeader(Long userId, String accessToken);
    void setUserAsLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
