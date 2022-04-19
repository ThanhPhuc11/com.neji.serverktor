package com.neji.model

@kotlinx.serialization.Serializable
data class NhanVien(
    var name: String? = null,
    var age: Int? = null
)
