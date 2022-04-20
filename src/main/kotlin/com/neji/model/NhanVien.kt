package com.neji.model

@kotlinx.serialization.Serializable
data class NhanVien(
    var id: Int? = null,
    var name: String? = null,
    var age: Int? = null
)
