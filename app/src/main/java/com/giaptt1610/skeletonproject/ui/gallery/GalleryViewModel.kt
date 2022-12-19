package com.giaptt1610.skeletonproject.ui.gallery

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giaptt1610.skeletonproject.data.models.Photo
import com.giaptt1610.skeletonproject.data.repositories.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {
    val photosLiveData = MutableLiveData<List<Photo>>()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, t ->
        Log.e("GalleryViewModel", "${t.message}")
    }


    var loading = MutableLiveData(false)
        private set

    fun getListPhotos() {
        viewModelScope.launch(coroutineExceptionHandler) {
            loading.postValue(true)
            val photos = photoRepository.getListPhotos(1, 10)
            photos?.let {
                photosLiveData.postValue(it)
            }
            loading.postValue(false)
        }
    }
}