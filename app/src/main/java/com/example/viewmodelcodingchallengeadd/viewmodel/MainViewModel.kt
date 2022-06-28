package com.example.viewmodelcodingchallengeadd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelcodingchallengeadd.databinding.ActivityMainBinding

/**
 * ViewModel to hold two methods to return the _total, and set the _total value.
 *
 * We will also show an example of LiveData here. Our _total variable will be
 * assigned as MutableLiveData with a type of Int.
 * ".value" is used for Live Data variables when assigning or changing a value.
 *
 */
class MainViewModel(startTotal : Int): ViewModel() {

    // Declaring our LiveData variable with a backing property so our Main Activity has
    // access to it when need be.
    private var _total = MutableLiveData<Int>()
    val total: LiveData<Int>
        get() = _total


    // initialized when ViewModel is first called
    init {
        _total.value = startTotal
    }

    // method to set the _total with the new input with mutable live data
    fun setTotalValue(input: Int) {
        // safety operator used with LiveData; will add input to _total
        _total.value = _total.value?.plus(input)
    }
}