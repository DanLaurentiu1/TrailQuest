package com.example.trailquest.data

import android.content.Context
import com.example.trailquest.data.repository.attraction.AttractionRepository
import com.example.trailquest.data.repository.attraction.LocalAttractionRepository
import com.example.trailquest.data.repository.country.CountryRepository
import com.example.trailquest.data.repository.country.LocalCountryRepository
import com.example.trailquest.data.repository.type.LocalTypeRepository
import com.example.trailquest.data.repository.type.TypeRepository
import com.example.trailquest.data.repository.user.LocalUserRepository
import com.example.trailquest.data.repository.user.UserRepository

interface AppContainer {
    val usersRepository: UserRepository
    val attractionRepository: AttractionRepository
    val countryRepository: CountryRepository
    val typeRepository: TypeRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val usersRepository: UserRepository by lazy {
        LocalUserRepository(TrailQuestDatabase.getDatabase(context).userDao())
    }

    override val attractionRepository: AttractionRepository by lazy {
        LocalAttractionRepository(TrailQuestDatabase.getDatabase(context).attractionDao())
    }

    override val countryRepository: CountryRepository by lazy {
        LocalCountryRepository(TrailQuestDatabase.getDatabase(context).countryDao())
    }

    override val typeRepository: TypeRepository by lazy {
        LocalTypeRepository(TrailQuestDatabase.getDatabase(context).typeDao())
    }
}