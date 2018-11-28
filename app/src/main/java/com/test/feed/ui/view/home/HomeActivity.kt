package com.test.feed.ui.view.home

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import butterknife.BindView
import butterknife.OnEditorAction
import butterknife.OnTextChanged
import com.test.feed.R
import com.test.feed.ui.view.base.BaseActivity
import org.jetbrains.annotations.Nullable


class HomeActivity : BaseActivity<HomeFragment>() {

    @BindView(R.id.searchEditText)
    lateinit var searchEditext: EditText

    override val fragment: Class<HomeFragment>
        get() = HomeFragment::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        customLayout = R.layout.activity_home_lay
       super.onCreate(savedInstanceState)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)
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

    @Nullable
    @OnEditorAction(value = R.id.searchEditText)
    protected fun imeItemPressed(actionId: Int) :Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            val searchEditText = this.findViewById<EditText>(R.id.searchEditText)
            currentFragment!!.searchText(searchEditText.text.toString())
            closeKeyboard()
            return true
        }
        return false
    }

    @Nullable
    @OnTextChanged(value = R.id.searchEditText, callback = OnTextChanged.Callback.TEXT_CHANGED)
    protected fun editTextchanged(editable: Editable) {
        if(editable.toString().isEmpty()){
            currentFragment!!.searchText("")
        }
    }
}
