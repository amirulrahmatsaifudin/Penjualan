package com.example.gamesuit.activity.ui.profil


import androidx.lifecycle.LiveData
import com.testrecruitment.penjualan.data.db.user.User
import com.testrecruitment.penjualan.ui.profile.ProfileActivity
import com.testrecruitment.penjualan.ui.profile.ProfileView
import com.testrecruitment.penjualan.until.App

class PresenterProfile(private val view: ProfileActivity) : ProfileView.Presenter {
    override fun getUser(id: Int): LiveData<User> {
        return App.appDb.getUserDao().getUserById(id)
    }
}
