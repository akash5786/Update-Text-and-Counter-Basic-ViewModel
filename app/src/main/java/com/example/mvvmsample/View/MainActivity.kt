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

        viewModel.editText.observe(this,{
            binding.updatedTv.text = update_text.text
        })

        binding.updateTextBtn.setOnClickListener{
            viewModel.updateQuote()
        }
        counter_tv.setText(""+viewModel.num)
        update_counter_btn.setOnClickListener {
            viewModel.num++
            counter_tv.setText(""+viewModel.num)
        }
    }

    override fun onResume() {
        viewModel.updateQuote()
        super.onResume()
    }

}