package com.benyaamin.bamachallenge.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    val userId: Int,
    val name: String,
    val username: String,
    val email: String,
    val addressStreet: String,
    val addressSuite: String,
    val addressCity: String,
    val addressZipCode: String,
    val geoLat: String,
    val geoLng: String,
    val phone: String,
    val website: String,
    val companyName: String,
    val companyCatchPhrase: String,
    val companyBs: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
