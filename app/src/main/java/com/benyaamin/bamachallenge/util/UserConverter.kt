package com.benyaamin.bamachallenge.util

import com.benyaamin.bamachallenge.data.remote.dto.Address
import com.benyaamin.bamachallenge.data.remote.dto.Company
import com.benyaamin.bamachallenge.data.remote.dto.Geo
import com.benyaamin.bamachallenge.data.remote.dto.User
import com.benyaamin.bamachallenge.domain.UserEntity

fun User.toEntity(): UserEntity {
    return UserEntity(
        id,
        name,
        username,
        email,
        address.street,
        address.suite,
        address.city,
        address.zipCode,
        address.geo.lat,
        address.geo.lng,
        phone,
        website,
        company.name,
        company.catchPhrase,
        company.bs
    )
}

fun UserEntity.toUser(): User {
    val company = Company(
        companyName,
        companyCatchPhrase,
        companyBs
    )
    val geo = Geo(
        geoLat,
        geoLng
    )
    val address = Address(
        addressStreet,
        addressSuite,
        addressCity,
        addressZipCode,
        geo
    )
    return User(
        userId,
        name,
        username,
        email,
        address,
        phone,
        website,
        company
    )
}