package com.example.rxjavatutorial.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavatutorial.network.RetrofitInstance
import com.example.rxjavatutorial.network.RetrofitService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class BookListViewModel : ViewModel() {
    var bookList: MutableLiveData<BookListModel> = MutableLiveData()

    fun getBookListObserver(): MutableLiveData<BookListModel> = bookList

    fun makeApiCall(query: String) {
        RetrofitInstance.getRetroInstance().create(RetrofitService::class.java)
            .getBookListFromApi(query = query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getBookListObserverRx())
    }

    private fun getBookListObserverRx(): Observer<BookListModel> = object : Observer<BookListModel> {
        override fun onSubscribe(d: Disposable) {}

        override fun onNext(t: BookListModel) {
            bookList.postValue(t)
        }

        override fun onError(e: Throwable) {
            bookList.postValue(null)
        }

        override fun onComplete() {}
    }
}