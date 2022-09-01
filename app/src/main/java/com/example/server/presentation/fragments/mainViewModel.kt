package com.example.server.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.server.domain.interactor.RequestDataUseCase
import com.example.server.presentation.model.ActionResult
import com.example.server.presentation.model.Article
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(var useCase: RequestDataUseCase): ViewModel() {
    var articlesLiveData = MutableLiveData<ArrayList<Article>?>()
    var errorLiveData = MutableLiveData<String>()

//    fun getArticles(source: String: String): ActionResult<ResponseResult> {
//        var value: ActionResult<ResponseResult> = ActionResult.SUCCESS("", ResponseResult())
//        repo.getArticles(apiKey).enqueue(object : Callback<ResponseResult> {
//            override fun onResponse(
//                call: Call<ResponseResult>,
//                response: Response<ResponseResult>
//            ) {
//                value =
//                    if (response.isSuccessful && response.body()?.articles?.isNotEmpty() == true) {
//                        ActionResult.SUCCESS(response.message(), response.body())
////                    articlesLiveData.value = response.body()?.articles
//                    } else {
//                        ActionResult.ERROR(response.message() ?: "Error")
////                    errorLiveData.value = response.errorBody().toString()
//                    }
//            }
//
//            override fun onFailure(call: Call<ResponseResult>, t: Throwable) {
//                value = ActionResult.ERROR(t.message ?: "Error")
////                if (t is SecurityException) {
////                    errorLiveData.value = t.message
////                }
//            }
//        })
//        return value
//    }
//}

    fun getArticles(country: String, category: String) {
        viewModelScope.launch {
            val response = async { return@async useCase.invoke(country, category, apiKey=  "18673a2eedc445fb9a44f383ca9da981") }.await()
            when (response) {
                is ActionResult.SUCCESS -> {
                    articlesLiveData.value = response.data?.articles
                }
                is ActionResult.ERROR -> {
                    errorLiveData.value = response.message
                }
            }
        }
    }
}