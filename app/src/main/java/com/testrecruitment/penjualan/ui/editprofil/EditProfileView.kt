package com.testrecruitment.penjualan.ui.editprofil


import android.widget.ImageView

interface EditProfileView {
    fun onSuccessUpdate(user: Int)
    fun onErrorUpdate(message: String)
    fun onSignOut()

}