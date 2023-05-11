package com.testrecruitment.penjualan.ui.produk.model

class Modelproduk {
    var imgproduk: Int? = 0
    var namaproduk: String? = null
    var hargaproduk: String? = null
    var diskonproduk: String? = null

    constructor(imgproduk: Int, namaproduk: String, hargaproduk: String, diskonproduk: String) {
        this.imgproduk = imgproduk
        this.namaproduk = namaproduk
        this.hargaproduk = hargaproduk
        this.diskonproduk = diskonproduk
    }

}