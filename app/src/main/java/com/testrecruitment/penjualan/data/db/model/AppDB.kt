package com.testrecruitment.penjualan.data.db.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.testrecruitment.penjualan.data.db.user.User
import com.testrecruitment.penjualan.data.db.user.UserDAO

@Database(entities = [User::class], exportSchema = true, version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun getUserDao(): UserDAO

    companion object {
        const val DB_NAME = "app_db"
    }
}