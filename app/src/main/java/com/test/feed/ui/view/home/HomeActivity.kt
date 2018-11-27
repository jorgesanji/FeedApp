package com.test.feed.ui.view.home

import android.os.Bundle
import android.text.Editable
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import butterknife.OnEditorAction
import butterknife.OnTextChanged
import com.test.feed.R
import com.test.feed.ui.view.base.BaseActivity


class HomeActivity : BaseActivity<HomeFragment>() {

    override val fragment: Class<HomeFragment>
        get() = HomeFragment::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        customLayout = R.layout.activity_home_lay
       super.onCreate(savedInstanceState)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)
    }

    override fun toolbarColor(): Int {
        return R.color.pale_gray
    }

    override fun centerTitle(): Boolean {
        return false
    }

    @OnEditorAction(value = R.id.searchEditText)
    protected fun searchText(actionId: Int) :Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            val searchEditText = this.findViewById<EditText>(R.id.searchEditText)
            currentFragment!!.searchText(searchEditText.text.toString())
            return true
        }
        return false
    }

   @OnTextChanged(value = R.id.searchEditText, callback = OnTextChanged.Callback.TEXT_CHANGED)
    fun searchText(editable: Editable) {
        if(editable.toString().isEmpty()){
            currentFragment!!.searchText("")
        }
    }
}
