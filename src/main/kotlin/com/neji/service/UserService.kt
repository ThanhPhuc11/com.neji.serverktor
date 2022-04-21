package com.neji.service

import com.neji.model.NhanVien
import com.neji.repository.UserRepo

object UserService {
    fun getUser(id: String?): List<NhanVien> {
        val paramId = try {
            id!!.toInt()
        } catch (_: Exception) {
            null
        }
        paramId?.let {
            return UserRepo.getUserById(paramId)
        }
        return UserRepo.getAllUser()
    }
}