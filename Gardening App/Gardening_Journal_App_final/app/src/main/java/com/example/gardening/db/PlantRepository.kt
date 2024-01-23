package com.example.gardening.db

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData

class PlantRepository(application: Application) {
    private val plantDao: PlantDao
    val allPlants: LiveData<List<Plant>>
    init {
        val database = PlantDatabase.getDatabase(application)
        plantDao = database.plantDao()
        allPlants = plantDao.getAllPlants()
    }
    suspend fun insert(plant: Plant) {
        plantDao.insert(plant)
    }
    suspend fun update(plant: Plant) {
        plantDao.update(plant)
    }
    suspend fun delete(plant: Plant) {
        plantDao.delete(plant.id)
    }
    fun getPlantById(plantId: Int): Plant {
       return plantDao.getPlantById(plantId)

    }
}