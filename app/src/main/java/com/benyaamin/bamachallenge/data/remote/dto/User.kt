package com.benyaamin.bamachallenge.data.remote.dto

import com.squareup.moshi.Json

data class User(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "username") val username: String,
    @field:Json(name = "email") val email: String,
    @field:Json(name = "address") val address: Address,
    @field:Json(name = "phone") val phone: String,
    @field:Json(name = "website") val website: String,
    @field:Json(name = "company") val company: Company
)

data class Address (
    @field:Json(name = "street") val street: String,
    @field:Json(name = "suite") val suite: String,
    @field:Json(name = "city") val city: String,
    @field:Json(name = "zipCode") val zipCode: String,
    @field:Json(name = "geo") val geo: Geo
)

data class Geo (
    @field:Json(name = "lat") val lat: String,
    @field:Json(name = "lng") val lng: String,
)

data class Company (
    @field:Json(name = "name") val name: String,
    @field:Json(name = "catchPhrase") val catchPhrase: String,
    @field:Json(name = "bs") val bs: String,
)