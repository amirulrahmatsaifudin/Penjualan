package com.testrecruitment.penjualan.ui.profile



import androidx.lifecycle.LiveData
import com.testrecruitment.penjualan.data.db.user.User

interface ProfileView {
    interface View
    interface Presenter {
        fun getUser(id: Int): LiveData<User>
    }

}