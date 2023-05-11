package com.testrecruitment.penjualan.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.testrecruitment.penjualan.data.db.user.User
import com.testrecruitment.penjualan.databinding.ActivityLoginBinding
import com.testrecruitment.penjualan.ui.produk.ProdukActivity
import com.testrecruitment.penjualan.ui.registrasi.RegistrasiActivity
import com.testrecruitment.penjualan.ui.ubahsandi.UbahsandiActivity
import com.testrecruitment.penjualan.until.goto

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginPrasenter: LoginPresenter
    private lateinit var username: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loadingInd: ProgressBar
    private lateinit var loginBtn: Button
    private lateinit var registrasi: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = binding.etNama
        password = binding.etPassword
        loginBtn = binding.btnLogin
        registrasi = binding.tvRegistrasi

        loginPrasenter = LoginPresenter(this)

        registrasi.setOnClickListener {
            goto(RegistrasiActivity::class.java)
        }



        loginBtn.setOnClickListener {
            showProgress()
            Handler(Looper.getMainLooper()).postDelayed({
                loginPrasenter.onLogin(
                    username = username.text.toString(),
                    password = password.text.toString()
                )
            }, 3000)
        }

        addTextChangedListenerOnView(username, password, textWatcher = textWatcher)
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val username = username.text?.trim().toString()
            val passwordText = password.text?.trim().toString()
            loginBtn.isEnabled =
                (username.isNotBlank() && passwordText.isNotBlank())
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }

    private fun addTextChangedListenerOnView(
        vararg views: TextInputEditText,
        textWatcher: TextWatcher
    ) {
        for (view in views) {
            view.addTextChangedListener(textWatcher)
        }
    }


    override fun onSignInMsg(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        loadingInd.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            loadingInd.visibility = View.GONE
        }, 3000)
    }

    override fun onSuccess(user: User) {
        val intent = Intent(this, ProdukActivity::class.java)
        startActivity(intent)
        onResetInputField()
    }

    private fun onResetInputField() {
        username.setText("", TextView.BufferType.SPANNABLE)
        password.setText("", TextView.BufferType.SPANNABLE)
    }
}
