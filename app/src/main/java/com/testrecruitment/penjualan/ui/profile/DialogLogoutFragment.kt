package com.testrecruitment.penjualan.ui.profile

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.testrecruitment.penjualan.data.local.AppSharedPreference.isLogin
import com.testrecruitment.penjualan.databinding.FragmentDialogLogoutBinding
import com.testrecruitment.penjualan.ui.login.LoginActivity

class DialogLogoutFragment : DialogFragment() {
    private lateinit var binding: FragmentDialogLogoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding = FragmentDialogLogoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnkeluar.setOnClickListener {
            isLogin = false
            Intent(activity,LoginActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnbatal.setOnClickListener {
            dismiss()
        }
    }
    companion object{
        const val DIALOG_LOGOUT = "dialog_logout"
    }
}