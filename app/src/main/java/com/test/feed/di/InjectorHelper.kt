package com.test.feed.di

import android.app.Activity

import com.test.feed.di.component.DaggerPresenterComponent
import com.test.feed.di.component.PresenterComponent
import com.test.feed.di.module.ManagerModule
import com.test.feed.di.module.NavigatorModule
import com.test.feed.di.module.PresenterModule
import com.test.feed.di.module.UseCaseModule
import com.test.feed.ui.application.SampleApplication

object InjectorHelper {

    fun getPresenterComponent(activity: Activity): PresenterComponent {
        return DaggerPresenterComponent.builder()
                .applicationComponent(SampleApplication.instance!!
                        .applicationComponent)
                .useCaseModule(UseCaseModule(activity))
                .navigatorModule(NavigatorModule(activity))
                .presenterModule(PresenterModule())
                .managerModule(ManagerModule(activity))
                .build()
    }
}
