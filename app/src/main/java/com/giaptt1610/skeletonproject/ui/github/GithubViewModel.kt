package com.giaptt1610.skeletonproject.ui.github

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giaptt1610.skeletonproject.data.models.GithubUser
import com.giaptt1610.skeletonproject.data.repositories.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    val searchResult = MutableLiveData<List<GithubUser>>()
    var loading = MutableLiveData(false)
        private set

    fun searchUser(query: String) {
        viewModelScope.launch {
            loading.postValue(true)
            val res = githubRepository.searchUser(query)
            searchResult.postValue(res ?: listOf())
            loading.postValue(false)
        }
    }
}