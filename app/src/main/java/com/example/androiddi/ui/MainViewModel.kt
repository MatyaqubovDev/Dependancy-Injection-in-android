package com.example.androiddi.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddi.data.remote.PosterService
import com.example.androiddi.data.remote.RetrofitHttp
import com.example.androiddi.model.Poster
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val posterService: PosterService) : ViewModel() {

    val allPosts = MutableLiveData<ArrayList<Poster>>()
    fun apiPostList() {
        posterService.listPost().enqueue(object : Callback<ArrayList<Poster>> {
            override fun onResponse(
                call: Call<ArrayList<Poster>>,
                response: Response<ArrayList<Poster>>
            ) {
                allPosts.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<Poster>>, t: Throwable) {
                allPosts.value = ArrayList()
            }

        })
    }
}