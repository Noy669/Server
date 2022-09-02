package com.example.server.mvvm

import Constants
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

    fun getArticles(country: String, category: String) {
        viewModelScope.launch {
            val response = async {
                return@async useCase.invoke(
                    country,
                    category,
                    apiKey = Constants.API_KEY
                )
            }.await()
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