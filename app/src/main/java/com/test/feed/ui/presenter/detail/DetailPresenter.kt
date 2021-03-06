package com.test.feed.ui.presenter.detail

import com.test.feed.ui.presenter.base.PrensenterImpl
import com.test.feed.ui.presenter.base.Presenter
import com.test.feed.ui.view.IONavigation

class DetailPresenter(appNavigation: IONavigation) : PrensenterImpl<DetailPresenter.View>(appNavigation) {

    interface View : Presenter.View {
        fun setInfo(title:String?, author:String?, price: String?, image:String?)
    }

    fun getBookDetail(){
        /*view.showLoading()
        val bookId = view.fragment.activity!!.intent.extras[bookIdKey] as? Int
        val bookName = view.fragment.activity!!.intent.extras[bookNameKey] as? String
        view.activity.setTitle(bookName)
        getBookDetailUseCase.id = bookId!!
        getBookDetailUseCase.subscribe(object : BaseSubscriber<Book>(){

            override fun onError(apiError: ApiError) {
                super.onError(apiError)
                this@DetailPresenter.view.hideLoading()
                this@DetailPresenter.view.showInternetConnectionError()
            }

            override fun onNext(book: Book) {
                super.onNext(book)
                val currency = Currency.getInstance(Locale.getDefault())
                val value = String.format("%s%s", NumberFormat.getInstance(Locale.getDefault()).format(book.price), currency.symbol)
                this@DetailPresenter.view.setInfo(book.title, book.author, value, book.image)
                this@DetailPresenter.view.hideLoading()
            }
        })*/
    }
}
