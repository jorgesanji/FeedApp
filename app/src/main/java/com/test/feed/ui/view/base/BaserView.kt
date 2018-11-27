package com.test.feed.ui.view.base

import android.util.AttributeSet

interface BaserView {

    val layout: Int

    fun initUI(attributeSet: AttributeSet?)
}
