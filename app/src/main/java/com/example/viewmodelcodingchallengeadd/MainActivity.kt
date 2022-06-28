@file:Suppress("RedundantSamConstructor")

package com.example.viewmodelcodingchallengeadd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelcodingchallengeadd.databinding.ActivityMainBinding
import com.example.viewmodelcodingchallengeadd.factory.MainViewModelFactory
import com.example.viewmodelcodingchallengeadd.viewmodel.MainViewModel

/**
 * Basic example again of how we can use ViewModels with our UI to hold our business logic.
 *
 * We have incorporated using a Factory class, as well as LiveData as well, as we know
 * they all pretty much go hand in hand.
 */
class MainActivity : AppCompatActivity() {

    // DataBinding variable
    private lateinit var binding: ActivityMainBinding

    // ViewModel variable
    private lateinit var viewModel: MainViewModel

    // define reference variable for our ViewModel factory
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // use the apply scope method to apply binding to all views
        binding.apply {
            /**
             * Here we show how we can pass in and initialize our startTotal
             * from our constructor in our ViewModel.
             * The app will start with a total of 125 because we passed it in as a constructor,
             * and used our Factory class to create an instance of it.
             */
            viewModelFactory = MainViewModelFactory(125)
            // create reference to our ViewModel, and index our factory class
            viewModel = ViewModelProvider(
                this@MainActivity, viewModelFactory)[MainViewModel::class.java]

            /**
             * Here below we will write code to update the TextView with the changes
             * made in the edit Text. LiveData automatically updates views so we no longer
             * need to set the View after a change.
             */
            viewModel.total.observe(this@MainActivity, Observer {
                tvAddNumber.text = it.toString()
            })

            //prepare our button and set it to click functionality
            button.setOnClickListener {

                // set the total value = to our edit text and cast it to a string
                viewModel.setTotalValue(etNumber.text.toString().toInt())
            }
        }
    }
}