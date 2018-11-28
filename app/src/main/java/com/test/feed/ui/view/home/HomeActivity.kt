package com.test.feed.ui.view.home

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import com.test.feed.R
import com.test.feed.ui.view.base.BaseActivity

class HomeActivity : BaseActivity<HomeFragment>(), TextView.OnEditorActionListener {

    @BindView(R.id.searchEditText)
    lateinit var searchEditext: EditText

    override val fragment: Class<HomeFragment>
        get() = HomeFragment::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        customLayout = R.layout.activity_home_lay
       super.onCreate(savedInstanceState)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)
        searchEditext.setOnEditorActionListener(this)
    }

    override fun toolbarColor(): Int {
        return R.color.red
    }

    override fun centerTitle(): Boolean {
        return false
    }

    private fun closeKeyboard(){
        val imm = searchEditext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(searchEditext.getWindowToken(), 0)
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            currentFragment!!.queryText(searchEditext.text.toString())
            closeKeyboard()
            return true
        }
        return false
    }
}
