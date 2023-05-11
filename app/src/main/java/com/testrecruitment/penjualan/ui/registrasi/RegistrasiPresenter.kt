package com.testrecruitment.penjualan.ui.registrasi

import android.util.Log
import com.testrecruitment.penjualan.data.db.user.User
import com.testrecruitment.penjualan.data.local.AppSharedPreference
import com.testrecruitment.penjualan.until.App
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class RegistrasiPresenter(private val view: RegistrasiActivity) : RegistrasiContract.Presenter {

    override fun register(username: String, email: String, password: String, ttl : String, jeniskelamin : String, telp :String) {
        GlobalScope.launch(Dispatchers.IO) {
            val dao = App.appDb.getUserDao()
            val getUserAndEmail = dao.getUserByUsernameAndEmail(username, email)

            if (getUserAndEmail == null) {
                dao.insertUser(
                    User(
                        username = username,
                        email = email,
                        password = password,
                        ttl = ttl,
                        jeniskelamin = jeniskelamin,
                        telp = telp

                    )
                )
            }

            launch(Dispatchers.Main) {
                if (getUserAndEmail == null) {
                    view.onSuccess(username)
                } else {
                    view.onSignUpMsg("Username atau email telah terdaftar!")
                }
            }
        }
    }

    override fun getUser(email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val user =
                withContext(Dispatchers.Default) {
                    App.appDb.getUserDao().getUserByEmailAndPassword(email, password)
                }
            AppSharedPreference.id = user.id
            Log.d("ID preference", "getUser: ${AppSharedPreference.id}")
            AppSharedPreference.isLogin = true
        }
    }
}