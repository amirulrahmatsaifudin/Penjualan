package com.testrecruitment.penjualan.ui.login

import com.testrecruitment.penjualan.data.local.AppSharedPreference
import com.testrecruitment.penjualan.until.App

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {

    override fun onLogin(username: String, password: String) {
        GlobalScope.launch {
            val dao = App.appDb.getUserDao()
            val getUserByUsernameAndPassword =
                dao.getUserByUsernameAndPassword(username = username, password = password)
            launch(Dispatchers.Main) {
                if (getUserByUsernameAndPassword == null) {
                    view.onSignInMsg("Incorrect user or password")
                } else {
                    AppSharedPreference.id = getUserByUsernameAndPassword.id
                    AppSharedPreference.isLogin = true
                    view.onSuccess(getUserByUsernameAndPassword)
                }
            }
        }
    }
}