package com.testrecruitment.penjualan.ui.produk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testrecruitment.penjualan.R
import com.testrecruitment.penjualan.databinding.ActivityProdukBinding
import com.testrecruitment.penjualan.ui.keranjang.KeranjangActivity
import com.testrecruitment.penjualan.ui.produk.adapter.Adapterproduk
import com.testrecruitment.penjualan.ui.produk.until.Helper
import com.testrecruitment.penjualan.ui.profile.ProfileActivity
import com.testrecruitment.penjualan.until.goto

class ProdukActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProdukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivProfil.setOnClickListener {
            goto(ProfileActivity::class.java)
        }

        binding.ivKeranjang.setOnClickListener {
            goto(KeranjangActivity::class.java)
        }
        val rvRecyclerView = findViewById<RecyclerView>(R.id.rcycleviewproduk)

        rvRecyclerView.apply {
            layoutManager = GridLayoutManager(this@ProdukActivity, 2)
            var adapter = Adapterproduk(this@ProdukActivity, Helper.Companion.getVersionsList())
            rvRecyclerView.adapter = adapter
        }
    }
}