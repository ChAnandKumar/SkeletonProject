package com.anand.skeletonproject.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

@Module
public class BusModule {

    @Provides
    @Singleton
    static PublishSubject<String> provideSubject() {
        return PublishSubject.create();
    }
}
