package com.example.trailquest

import android.app.Application
import com.example.trailquest.data.AppContainer
import com.example.trailquest.data.AppDataContainer

class TrailQuestApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}