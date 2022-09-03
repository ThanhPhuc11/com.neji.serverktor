package com.neji.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NotificationFCM(
    @SerialName("title")
    var title: String? = "",
    @SerialName("body")
    var body: String? = ""
)