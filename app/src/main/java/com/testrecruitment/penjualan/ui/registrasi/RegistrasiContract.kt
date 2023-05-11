package com.testrecruitment.penjualan.ui.registrasi


interface RegistrasiContract {

    interface View {
        fun onSignUpMsg(message: String)
        fun showProgress()
        fun onSuccess(username: String)
    }

    interface Presenter {
        fun register(username: String, email: String, password: String, ttl : String, jeniskelamin : String, telp : String)
        fun getUser(username: String, password: String)

    }


}