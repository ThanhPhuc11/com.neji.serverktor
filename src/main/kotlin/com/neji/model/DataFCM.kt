package com.neji.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataFCM(
    @SerialName("body")
    var body: String? = "",
    @SerialName("title")
    var title: String? = "",
    @SerialName("key_1")
    var key_1: String? = "",
    @SerialName("key_2")
    var key_2: String? = ""
)