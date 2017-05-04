package com.anand.skeletonproject.data.network;

import com.anand.skeletonproject.data.network.model.LoginRequest;
import com.anand.skeletonproject.data.network.model.LoginResponse;
import com.anand.skeletonproject.data.network.model.LogoutResponse;

import io.reactivex.Observable;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LogoutResponse> doLogoutApiCall();
}
