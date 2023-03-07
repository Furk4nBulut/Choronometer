package com.example.choronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import com.example.choronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var stopTime :Long =0
        binding.buttonStart.setOnClickListener{
            binding.chronometer.base =SystemClock.elapsedRealtime() + stopTime
            binding.chronometer.start()
            binding.buttonStart.visibility = View.GONE
            binding.buttonPause.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))

        }
        binding.buttonPause.setOnClickListener{
            stopTime = binding.chronometer.base-SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.buttonPause.visibility = View.GONE
            binding.buttonStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }
        binding.buttonReset.setOnClickListener{
            binding.chronometer.base =SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.buttonPause.visibility = View.GONE
            binding.buttonStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }


    }
}