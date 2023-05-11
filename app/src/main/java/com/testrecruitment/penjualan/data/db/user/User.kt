package com.testrecruitment.penjualan.data.db.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = User.TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "telp")
    val telp: String,

    @ColumnInfo(name = "ttl")
    val ttl: String,

    @ColumnInfo(name = "jeniskelamin")
    val jeniskelamin: String,


    ) {
    companion object {
        const val TABLE_NAME = "user_table"
    }

    data class AuthDetails(
        val password: String,
        val username: String
    )
}

