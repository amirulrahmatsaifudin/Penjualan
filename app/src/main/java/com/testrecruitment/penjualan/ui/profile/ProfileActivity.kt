package com.testrecruitment.penjualan.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.example.gamesuit.activity.ui.profil.PresenterProfile
import com.testrecruitment.penjualan.ui.editprofil.PresenterEditProfile
import com.testrecruitment.penjualan.data.db.user.User
import com.testrecruitment.penjualan.data.local.AppSharedPreference
import com.testrecruitment.penjualan.databinding.ActivityProfileBinding
import com.testrecruitment.penjualan.ui.editprofil.EditprofileActivity
import com.testrecruitment.penjualan.ui.profile.DialogLogoutFragment.Companion.DIALOG_LOGOUT
import com.testrecruitment.penjualan.ui.ubahsandi.UbahsandiActivity
import com.testrecruitment.penjualan.until.goto

class ProfileActivity : AppCompatActivity(), ProfileView.View {
    private lateinit var binding: ActivityProfileBinding
    private var userId: Int = 0
    private lateinit var profilepresenter: PresenterProfile
    private lateinit var username: TextView
    private lateinit var nohp: TextView
    private lateinit var email: TextView
    private lateinit var ubahprofil: LinearLayout
    private lateinit var ubahsandi: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userId = AppSharedPreference.id!!
        username = binding.tvUsername
        nohp = binding.tvTelp
        email = binding.tvEmail

        ubahprofil = binding.linearLayout
        ubahsandi = binding.linearLayout2

        profilepresenter = PresenterProfile(this)
        username.text = userId.toString()
        profilepresenter.getUser(userId).observe(this) {
            bind(it)
        }

        ubahprofil.setOnClickListener {
            goto(EditprofileActivity::class.java)
        }

        ubahsandi.setOnClickListener {
            goto(UbahsandiActivity::class.java)
        }

        binding.btnSignOut.setOnClickListener {
            onSignOut()
        }
    }

    private fun onSignOut() {
        val dialogSignOut = DialogLogoutFragment()
        dialogSignOut.show(supportFragmentManager, DIALOG_LOGOUT)
    }


    private fun bind(user: User) {
        binding.apply {
            username.text = user.username
            nohp.text = user.telp
            email.text = user.email
        }
    }
}