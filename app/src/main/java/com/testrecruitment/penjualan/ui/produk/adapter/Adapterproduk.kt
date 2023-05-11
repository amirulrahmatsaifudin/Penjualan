package com.testrecruitment.penjualan.ui.produk.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.testrecruitment.penjualan.R
import com.testrecruitment.penjualan.databinding.ItemProdukBinding
import com.testrecruitment.penjualan.ui.produk.model.Modelproduk

class Adapterproduk(val context : Context, val androidVersionList: ArrayList<Modelproduk>) : RecyclerView.Adapter<Adapterproduk.ViewHolder>() {
    private lateinit var bindig : ItemProdukBinding
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.namaproduk?.text = androidVersionList[p1].namaproduk
        p0?.hargaproduk?.text = androidVersionList[p1].hargaproduk
        p0?.diskonproduk?.text = androidVersionList[p1].diskonproduk
        p0?.imageproduk?.setImageResource(androidVersionList[p1].imgproduk!!)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.item_produk, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return androidVersionList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namaproduk = itemView.findViewById<TextView>(R.id.tvNamaproduk)
        val imageproduk = itemView.findViewById<ImageView>(R.id.imageView2)
        val hargaproduk = itemView.findViewById<TextView>(R.id.tvHarga)
        val diskonproduk = itemView.findViewById<TextView>(R.id.tvDiskon)

    }
}