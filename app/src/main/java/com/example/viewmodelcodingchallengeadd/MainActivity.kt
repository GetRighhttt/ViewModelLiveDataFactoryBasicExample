package com.example.viewmodelcodingchallengeadd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelcodingchallengeadd.databinding.ActivityMainBinding
import com.example.viewmodelcodingchallengeadd.factory.MainViewModelFactory
import com.example.viewmodelcodingchallengeadd.viewmodel.MainViewModel

/**
 * Basic example again of how we can use ViewModels with our UI to hold our business logic.
 */
class MainActivity : AppCompatActivity() {

    // databinding variable
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

            // create reference to our ViewModel
            viewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)

            /**
             * Here we show how we can pass in and initialize our startTotal
             * from our constructor in our ViewModel.
             * The app will start with a total of 125 because we passed it in as a constructor,
             * and used our Factory class to create an instance of it.
             */
            viewModelFactory = MainViewModelFactory(125)

            // set the TextView to the total Value
            tvAddNumber.text = viewModel.returnTotalValue().toString()

            //prepare our button and set it to click functionality
            button.setOnClickListener {

                // set the total value = to our edit text and cast it to a string
                viewModel.setTotalValue(etNumber.text.toString().toInt())

                // set the TextView to the total value now
                tvAddNumber.text = viewModel.returnTotalValue().toString()
            }
        }
    }
}