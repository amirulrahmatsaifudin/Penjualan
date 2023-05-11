package com.testrecruitment.penjualan.data.db.user

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface UserDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insertUser(user: User): Long

    @Delete
    suspend fun deleteUser(user: User): Int

    @Update
    suspend fun updateUser(user: User): Int

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE id = :id")
    fun getUserById(id: Int): LiveData<User>

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE username = :username")
    fun getUserByUserName(username: String): User

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE username = :username OR email = :email")
    fun getUserByUsernameAndEmail(username: String, email: String): User

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE email = :email AND password = :password")
    fun getUserByEmailAndPassword(email: String, password: String): User

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE username = :username AND password = :password")
    fun getUserByUsernameAndPassword(username: String, password: String): User

    @Query("DELETE FROM ${User.TABLE_NAME}")
    suspend fun clearAllUser(): Int

    @Query("SELECT * FROM ${User.TABLE_NAME}")
    fun getUsers(): LiveData<List<User>>

    @Query("UPDATE ${User.TABLE_NAME} SET  username = :username, email= :email,ttl = :ttl, jeniskelamin = :jeniskelamin, telp = :telp WHERE id = :id")
    fun updateProfileById(
        username: String,
        email: String,
        ttl: String,
        jeniskelamin: String,
        telp: String,
        id: Int,

    ): Int

    @Query("UPDATE ${User.TABLE_NAME} SET  password = :password, password = :newPass,password = :konfrimPass WHERE id = :id")
    fun updatePasswordById(
        password: String,
        newPass: String,
        konfrimPass: String,
        id: Int,

        ): Int

    @Query("select * from ${User.TABLE_NAME} except select * from ${User.TABLE_NAME} where id  = :id")
    fun getUserExcl(id: Int): List<User>

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE id = :id")
    fun getUserByIdNoLiveData(id: Int): User


}