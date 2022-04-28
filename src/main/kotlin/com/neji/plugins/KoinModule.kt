package com.neji.plugins

import com.neji.repository.UserRepo
import com.neji.service.UserService
import com.neji.utils.JwtUtils
import org.koin.dsl.module

val helloAppModule = module {
    single { UserService(get()) } // get() Will resolve HelloRepository
    single { UserRepo() }
    single { JwtUtils() }
}