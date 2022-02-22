package com.example.mvvmsample.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmsample.ViewModel.MainViewModel
import com.example.mvvmsample.databinding.ActivityMainBinding
import androidx.lifecycle.*
import com.example.mvvmsample.databinding.ActivityMainBinding.inflate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.textLiveData.observe(this,{
            text_textView.text = it
        })
        update_text_btn.setOnClickListener{
            viewModel.setCurrentText(editText.text.toString())
        }

        viewModel.countLiveData.observe(this, Observer {
            counter_textView.text = it.toString()
        })
        update_counter_btn.setOnClickListener {
            viewModel.setCurrentCount()
        }
        viewModel.textLiveData
    }
}