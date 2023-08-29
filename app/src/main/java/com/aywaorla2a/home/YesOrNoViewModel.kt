package com.aywaorla2a.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aywaorla2a.repository.YesOrNoRepository
import com.aywaorla2a.response.YesOrNoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YesOrNoViewModel @Inject constructor(
    private val yesOrNoRepository: YesOrNoRepository
) : ViewModel() {


    private val _yesOrNoData = MutableLiveData<YesOrNoResponse>()
    val yesOrNoData: LiveData<YesOrNoResponse> = _yesOrNoData

    private val _errorMessage = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage


    init {
        fetchYesOrNo()
    }

    fun fetchYesOrNo() {
        viewModelScope.launch {
            try {
                val yesOrno = yesOrNoRepository.fetchYesOrNo()
                _yesOrNoData.value = yesOrno
            } catch (e: Exception) {
                _errorMessage.value = e.message.toString()
            }
        }
    }

}