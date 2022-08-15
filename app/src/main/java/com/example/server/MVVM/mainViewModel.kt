package com.example.server.MVVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.server.model.ResponseResult
import com.example.server.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val repo = MainRepository()
    private val list = ArrayList<Article>()
    var articlesLiveData = MutableLiveData<List<Article>>()
    var errorLiveData = MutableLiveData<String>()

    fun getArticles(apiKey: String) {
        repo.getArticles(apiKey).enqueue(object : Callback<ResponseResult> {
            override fun onResponse(
                call: Call<ResponseResult>,
                response: Response<ResponseResult>
            ) {
                if (response.isSuccessful && response.body()?.articles?.isNotEmpty() == true) {
                    articlesLiveData.value = response.body()?.articles
                } else {
                    errorLiveData.value = response.errorBody().toString()
                }
            }

            override fun onFailure(call: Call<ResponseResult>, t: Throwable) {
                if (t is SecurityException) {
                    errorLiveData.value = t.message
                }
            }
        })
    }
}
