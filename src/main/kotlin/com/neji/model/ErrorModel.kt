package com.neji.model

@kotlinx.serialization.Serializable
data class ErrorModel(
    var code: Int? = null,
    var mess: String? = null
)