package com.example.trailquest.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trailquest.data.dao.AttractionDao
import com.example.trailquest.data.dao.CountryDao
import com.example.trailquest.data.dao.TypeDao
import com.example.trailquest.data.dao.UserDao
import com.example.trailquest.data.entities.Attraction
import com.example.trailquest.data.entities.Country
import com.example.trailquest.data.entities.Type
import com.example.trailquest.data.entities.User

@Database(
    entities = [User::class, Attraction::class, Type::class, Country::class],
    version = 1,
    exportSchema = false
)
abstract class TrailQuestDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun attractionDao(): AttractionDao
    abstract fun countryDao(): CountryDao
    abstract fun typeDao(): TypeDao

    companion object {
        @Volatile
        private var Instance: TrailQuestDatabase? = null

        fun getDatabase(context: Context): TrailQuestDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    TrailQuestDatabase::class.java,
                    "trail_quest_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}