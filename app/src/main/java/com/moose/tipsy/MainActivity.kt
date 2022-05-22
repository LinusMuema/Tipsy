package com.moose.tipsy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.moose.tipsy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewmodel: MainViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel.tip.observe(this) { tip ->
            binding.amountInput.setText(tip)
        }

        viewmodel.total.observe(this){ total ->
            binding.totalInput.setText(total)
        }

        val inputListener = object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val tip = binding.tipInput.text.toString().toDoubleOrNull()
                val amount = binding.billInput.text.toString().toDoubleOrNull()

                viewmodel.calculateTip(amount, tip)
            }
        }

        binding.tipInput.addTextChangedListener(inputListener)

        binding.billInput.addTextChangedListener(inputListener)
    }
}