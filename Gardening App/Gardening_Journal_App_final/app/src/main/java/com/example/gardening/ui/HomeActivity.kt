package com.example.gardening.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.gardening.R
import com.example.gardening.ui.gardenlog.GardenLogViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var mainVM: GardenLogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainVM = ViewModelProvider(this).get(GardenLogViewModel::class.java)
    }
}