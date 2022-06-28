package com.example.viewmodelcodingchallengeadd.viewmodel

import androidx.lifecycle.ViewModel
import com.example.viewmodelcodingchallengeadd.databinding.ActivityMainBinding

/**
 * ViewModel to hold two methods to return the total, and set the total value.
 */
class MainViewModel: ViewModel() {
    private var total = 0

    // method to return total
    fun returnTotalValue(): Int {
        return total
    }

    // method to set the total with the new input
    fun setTotalValue(input: Int) {
        total += input
    }
}