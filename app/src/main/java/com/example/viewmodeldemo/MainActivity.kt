package com.example.viewmodeldemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.viewmodeldemo.databinding.ActivityMainBinding
import com.example.viewmodeldemo.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {
      lateinit var  binding: ActivityMainBinding
    private  val counterViewModel:CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding =  ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

     counterViewModel.count.observe(this, Observer {

         binding.countTxt.text=it.toString()
     })
        binding.counterBtn.setOnClickListener {
        counterViewModel.incrementCounter()
        }
    }
}
