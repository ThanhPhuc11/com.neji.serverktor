package com.neji.di

import com.neji.repository.UserRepo
import com.neji.service.FirebaseService
import com.neji.service.UserService
import com.neji.utils.JwtUtils
import org.koin.dsl.module

val helloAppModule = module {
    single { UserService(get()) } // get() Will resolve HelloRepository
    single { FirebaseService() }
    single { UserRepo() }
    single { JwtUtils() }
}