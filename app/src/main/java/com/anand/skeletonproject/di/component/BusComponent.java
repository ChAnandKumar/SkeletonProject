package com.anand.skeletonproject.di.component;

import com.anand.skeletonproject.di.module.BusModule;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by anand.chandaliya on 04-05-2017.
 */

@Singleton
@Component(modules = BusModule.class)
public interface BusComponent {
    PublishSubject<String> getSubject();
}
