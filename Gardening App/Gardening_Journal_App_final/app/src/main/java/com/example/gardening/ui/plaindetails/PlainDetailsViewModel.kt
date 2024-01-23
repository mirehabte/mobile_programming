package com.example.gardening.ui.plaindetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.gardening.db.Plant
import com.example.gardening.db.PlantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlainDetailsViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PlantRepository
    private val _plantLiveData = MutableLiveData<Plant>()
    val plantLiveData: LiveData<Plant> get() = _plantLiveData

    init {
        repository = PlantRepository(application)
    }

    fun getPlantById(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _plantLiveData.postValue(repository.getPlantById(id))
            }
        }
    }
}