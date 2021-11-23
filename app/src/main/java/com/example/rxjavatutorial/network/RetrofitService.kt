package com.example.rxjavatutorial.network

import com.example.rxjavatutorial.data.BookListModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("volumes")
    fun getBookListFromApi(@Query("q") query: String): Observable<BookListModel>
}