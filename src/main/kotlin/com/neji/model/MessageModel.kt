package com.neji.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageModel(
    @SerialName("token")
    var token: String? = "",
    @SerialName("data")
    var data: DataFCM? = DataFCM(),
    @SerialName("notification")
    var notification: NotificationFCM? = NotificationFCM()
)