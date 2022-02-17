package com.example.mvvmsample.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var editText = MutableLiveData<String>()
    var num = 1
    fun updateQuote(){
        val updatedText = editText.value
        editText.postValue(updatedText)
    }
}
