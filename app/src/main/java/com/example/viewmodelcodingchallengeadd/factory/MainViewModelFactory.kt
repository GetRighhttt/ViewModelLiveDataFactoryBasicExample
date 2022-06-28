package com.example.viewmodelcodingchallengeadd.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelcodingchallengeadd.viewmodel.MainViewModel

/**
 * Demonstration of how we can use a Factory class when we are passing arguments into our
 * Constructor for our ViewModel.
 * Extending ViewModelProvider.Factory gives us access to the Provider and Factory classes.
 * It makes this class an actual Factory class where we can return one instance of ViewModel
 * each time.
 * We have to pass in our parameter from our ViewModel (startTotal) so
 * we can return it in our Override Method as generic type T.
 */
class MainViewModelFactory(private val startTotal: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(startTotal) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class...")
    }
}