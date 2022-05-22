package com.moose.tipsy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.moose.tipsy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // TODO 1 : Get the viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO 2 : Listen to the values from the viewmodel

        // TODO 3 : Implement the input listener

        // TODO 4 : Add the input listener to our inputs
    }
}