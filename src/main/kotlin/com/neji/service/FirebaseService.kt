package com.neji.service

import com.neji.model.DataFCM
import com.neji.model.FirebaseRequestModel
import com.neji.model.MessageModel
import com.neji.model.NotificationFCM
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

class FirebaseService {
    suspend fun getDataFromKtorClient(): String {
        val data =
            hashMapOf("body" to "Body of Your Notification in data", "title" to "Title of Your Notification in data")
        val body = hashMapOf<String, Any>()
        body["message"] = hashMapOf(
            "token" to "cu-XWy86R_2BKYHoawIfBZ:APA91bE3-CkRcxsQNP7kjVg-roVPBBGZ8LN76GfRW_36X835Og5FynB16JbBtJiL_3JVPfUpBdBR1kWugTN-LGRQEE-uUHTeBLDrO0ztIONfv1n6Af0kpsc_I5pLZj-ZGRTa7Gon6LIm",
            "data" to data
        )
        val client = HttpClient(CIO)
        val response = client.post("https://fcm.googleapis.com/v1/projects/fir-ktor/messages:send") {
            headers {
                append(
                    HttpHeaders.Authorization,
                    "Bearer ya29.a0AVA9y1sp_qgrsk3-fFAugzVBnqlOTMgjaJhnXF5rgdUQudgX4dSbpxScPDuVa-ePYh0e6KXcvoSoihm3xPhzNylZkonkcg_yXhOfy3xKrFmHdaprcvGfNCMuQmiNJB39PTMsTMRU7rmz_WGnyy7ZWm1saytb1AaCgYKATASAQASFQE65dr808Yj_EgGrScJxbtyGYVFvg0165"
                )
            }
            contentType(ContentType.Application.Json)

            setBody("{\n" +
                    "    \"message\": {\n" +
                    "        \"token\": \"cu-XWy86R_2BKYHoawIfBZ:APA91bE3-CkRcxsQNP7kjVg-roVPBBGZ8LN76GfRW_36X835Og5FynB16JbBtJiL_3JVPfUpBdBR1kWugTN-LGRQEE-uUHTeBLDrO0ztIONfv1n6Af0kpsc_I5pLZj-ZGRTa7Gon6LIm\",\n" +
                    "        \"data\": {\n" +
                    "            \"body\": \"Body of Your Notification in data\",\n" +
                    "            \"title\": \"Title of Your Notification in data\",\n" +
                    "            \"key_1\": \"Value for key_1\",\n" +
                    "            \"key_2\": \"Value for key_2\"\n" +
                    "        },\n" +
                    "        \"notification\": {\n" +
                    "            \"title\": \"Breaking News\",\n" +
                    "            \"body\": \"New news story available.\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}")
//            setBody(
//                FirebaseRequestModel(
//                    MessageModel(
//                        token = "cu-XWy86R_2BKYHoawIfBZ:APA91bE3-CkRcxsQNP7kjVg-roVPBBGZ8LN76GfRW_36X835Og5FynB16JbBtJiL_3JVPfUpBdBR1kWugTN-LGRQEE-uUHTeBLDrO0ztIONfv1n6Af0kpsc_I5pLZj-ZGRTa7Gon6LIm",
//                        data = DataFCM(
//                            body = "Body of Your Notification in data",
//                            title = "Title of Your Notification in data",
//                            key_1 = "Value for key_1",
//                            key_2 = "Value for key_2"
//                        ),
//                        notification = NotificationFCM(
//                            title = "Breaking News",
//                            body = "New news story available."
//                        )
//                    )
//                )
//            )
        }
        println(response.bodyAsText())
        client.close()
        return response.status.toString()
    }
}