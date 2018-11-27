package com.test.feed.ui.view.splash

import android.view.View
import com.test.feed.di.InjectorHelper
import com.test.feed.ui.presenter.splash.SplashPresenter
import com.test.feed.ui.view.base.MVPFragment
class SplashFragment : MVPFragment<SplashPresenter, SplashPresenter.View>(){

    override val rootView: View get(){return SplashScreen(activity!!)}

    override fun injectDependencies() {
        InjectorHelper.getPresenterComponent(activity!!).inject(this)
    }

    override fun onDidAppear() {
        presenter.initSession()
    }
}