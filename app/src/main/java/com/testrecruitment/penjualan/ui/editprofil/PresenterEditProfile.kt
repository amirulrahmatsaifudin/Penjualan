package com.testrecruitment.penjualan.ui.editprofil

import android.util.Patterns.EMAIL_ADDRESS
import com.testrecruitment.penjualan.data.db.user.User
import com.testrecruitment.penjualan.data.local.AppSharedPreference
import com.testrecruitment.penjualan.until.App
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PresenterEditProfile(private val view: EditProfileView) {
    private val idUser = AppSharedPreference.id!!

    private val allUsers = App.appDb.getUserDao().getUserExcl(AppSharedPreference.id!!)
    private val player = App.appDb.getUserDao().getUserByIdNoLiveData(AppSharedPreference.id!!)

    fun getDataUser(): User {
        return player
    }

    private val passUser = player.password

    @DelicateCoroutinesApi
    fun updateDataUser(
        username: String,
        email: String,
        ttl: String,
        jeniskelamin: String,
        telp: String
    ) {

        GlobalScope.launch {
            when {

                !EMAIL_ADDRESS.matcher(email).matches() -> {
                    launch(Dispatchers.Main) {
                        view.run { onErrorUpdate("Check your Email") }
                    }
                }
                checkUserNameIsAlready(username) -> {
                    launch(Dispatchers.Main) {
                        view.run { onErrorUpdate("Username already used") }
                    }
                }
                checkEmailIsAlready(email) -> {
                    launch(Dispatchers.Main) {
                        view.run { onErrorUpdate("Email already used") }
                    }
                }
                username.isBlank() -> {
                    launch(Dispatchers.Main) {
                        view.run { onErrorUpdate("You must have a username") }
                    }
                }

                ttl.isBlank() -> {
                    launch(Dispatchers.Main) {
                        view.run { onErrorUpdate("You must have a username") }
                    }
                }

                jeniskelamin.isBlank() -> {
                    launch(Dispatchers.Main) {
                        view.run { onErrorUpdate("You must have a username") }
                    }
                }

                telp.isBlank() -> {
                    launch(Dispatchers.Main) {
                        view.run { onErrorUpdate("You must have a username") }
                    }
                }

                username == passUser && username.isBlank()  -> {
                    val update = App.appDb.getUserDao()
                        .updateProfileById(
                            username,
                            email,
                            ttl,
                            jeniskelamin,
                            telp,
                            idUser
                        )
                    launch(Dispatchers.Main) {
                        view.onSuccessUpdate(update)
                    }
                }

                username == passUser && username.isNotBlank()  -> {
                    val update = App.appDb.getUserDao()
                        .updateProfileById(
                            username,
                            email,
                            ttl,
                            telp,
                            jeniskelamin,
                            idUser
                        )
                    launch(Dispatchers.Main) {
                        view.onSuccessUpdate(update)

                    }
                }
            }
        }

    }

    private fun checkEmailIsAlready(email: String): Boolean {
        allUsers.forEach {
            if (it.email == email) return true
        }
        return false
    }

    private fun checkUserNameIsAlready(username: String): Boolean {
        allUsers.forEach {
            if (it.username == username) return true
        }
        return false
    }
}
