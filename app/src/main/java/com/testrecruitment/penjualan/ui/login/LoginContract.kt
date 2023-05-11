package com.testrecruitment.penjualan.ui.login

import com.testrecruitment.penjualan.data.db.user.User

interface LoginContract {

    interface View {
        fun onSignInMsg(message: String)
        fun showProgress()
        fun onSuccess(user: User)
    }

    interface Presenter {
        fun onLogin(username: String, password: String)
    }

}