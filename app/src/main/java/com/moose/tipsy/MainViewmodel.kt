package com.moose.tipsy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewmodel: ViewModel() {
    private val _tip: MutableLiveData<String> = MutableLiveData("0")
    val tip: LiveData<String>
        get() = _tip

    private val _total: MutableLiveData<String> = MutableLiveData("0")
    val total: LiveData<String>
        get() = _total

    fun calculateTip(bill: Double?, percent: Double?) {
        if (bill != null && percent != null) {
            val tipAmount = bill.toDouble() * (percent.toDouble() / 100)
            val totalAmount = bill.toDouble() + tipAmount

            _tip.value = "$%.2f".format(tipAmount)
            _total.value = "$%.2f".format(totalAmount)
        }
    }
}