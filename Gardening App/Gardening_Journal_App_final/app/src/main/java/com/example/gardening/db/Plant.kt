package com.example.gardening.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant(

    @ColumnInfo(name = "plantName")
    val name: String,
    val type: String,
    val wateringFrequency: Int,
    val plantingDate: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)