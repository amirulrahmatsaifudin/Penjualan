package com.testrecruitment.penjualan.ui.registrasi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.testrecruitment.penjualan.data.local.AppSharedPreference.username
import com.testrecruitment.penjualan.databinding.ActivityRegistrasiBinding
import com.testrecruitment.penjualan.ui.produk.ProdukActivity

@SuppressLint("UseCompatLoadingForDrawables")
class RegistrasiActivity : AppCompatActivity(), RegistrasiContract.View {
    private lateinit var binding: ActivityRegistrasiBinding
    private lateinit var registrasiPresent: RegistrasiPresenter
    private lateinit var username: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var ttl: TextInputEditText
    private lateinit var telp: TextInputEditText
    private lateinit var registrasi :Button
    private lateinit var email: TextInputEditText
    private lateinit var jeniskelamin: TextInputEditText
    private lateinit var loadingInd: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registrasiPresent = RegistrasiPresenter(this)

        username = binding.etNamaregistrasi
        password = binding.etPassword
        ttl = binding.etTanggallahir
        email = binding.etEmail
        jeniskelamin = binding.etJenisKelamin
        telp = binding.etTelp
        registrasi = binding.btnRegistrasi

        registrasi.setOnClickListener {
            if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    registrasiPresent.register(
                        username = username.text.toString(),
                        email = email.text.toString(),
                        password = password.text.toString(),
                        ttl = ttl.text.toString(),
                        jeniskelamin = jeniskelamin.text.toString(),
                        telp = telp . text . toString ()


                        )
                }, 3000)
            }
        }


    }

    override fun onSignUpMsg(message: String) {
        Handler(Looper.getMainLooper()).postDelayed({
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }, 0)
    }

    override fun onSuccess(username: String) {
        registrasiPresent.getUser(email.text.toString(), password.text.toString())
        val intent = Intent(this, ProdukActivity::class.java)
        startActivity(intent)
        onResetInputField()
    }

    override fun showProgress() {
        loadingInd.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            loadingInd.visibility = View.GONE
        }, 3000)
    }

    private fun onResetInputField() {
        username.setText("", TextView.BufferType.SPANNABLE)
        email.setText("", TextView.BufferType.SPANNABLE)
        password.setText("", TextView.BufferType.SPANNABLE)
        ttl.setText("", TextView.BufferType.SPANNABLE)
        jeniskelamin.setText("", TextView.BufferType.SPANNABLE)
        telp.setText("", TextView.BufferType.SPANNABLE)

    }
}