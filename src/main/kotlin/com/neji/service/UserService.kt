package com.neji.service

import com.neji.model.NhanVien
import com.neji.repository.UserRepo

class UserService(private val repo: UserRepo) {
    fun getUser(id: String?): List<NhanVien> {
        val paramId = try {
            id!!.toInt()
        } catch (_: Exception) {
            null
        }
        paramId?.let {
            return repo.getUserById(paramId)
        }
        return repo.getAllUser()
    }
}