package com.example.mvvmsample.ViewModel

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var textLiveData = MutableLiveData<String>()
    var clickCount : Int = 1
    var countLiveData = MutableLiveData<Int>()

    fun setCurrentText(clickText: String) {
        textLiveData.postValue(clickText)
    }

    fun setCurrentCount(){
        countLiveData.postValue(clickCount++)
    }
}
