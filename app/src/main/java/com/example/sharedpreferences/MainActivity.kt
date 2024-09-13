package com.example.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val sharedPreferences = getSharedPreferences("counter_preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var counter = sharedPreferences.getInt("counter_value", 0)
        counter += 1

        editor.putInt("counter_value", counter)
        editor.apply()

        binding.tvCounter.text = binding.tvCounter.context.getString(R.string.counter ,counter.toString())
    }
}