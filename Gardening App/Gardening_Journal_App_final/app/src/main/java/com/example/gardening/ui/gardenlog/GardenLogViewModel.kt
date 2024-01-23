package com.example.gardening.ui.gardenlog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gardening.db.Plant
import com.example.gardening.db.PlantDatabase
import com.example.gardening.db.PlantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

class GardenLogViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PlantRepository

    val allPlants: LiveData<List<Plant>>

    init {
        repository = PlantRepository(application)
        allPlants = repository.allPlants
    }

    fun insert(plant: Plant) = viewModelScope.launch {
        repository.insert(plant)
    }



}