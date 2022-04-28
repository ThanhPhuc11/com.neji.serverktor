package com.neji.model

@kotlinx.serialization.Serializable
data class ResponseModel<V>(
//    var code: Int? = null,
    var data: V? = null
)