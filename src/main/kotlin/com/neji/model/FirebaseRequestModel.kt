package com.neji.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FirebaseRequestModel(
    @SerialName("message")
    var message: MessageModel? = MessageModel()
)