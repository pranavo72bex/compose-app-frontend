package com.example.Auth.domain.repository

import com.example.Auth.domain.model.AuthResultData
import com.example.common.util.Result

class AuthRepositoryImpl : AuthRepository {
    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Result<AuthResultData> {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(email: String, password: String): Result<AuthResultData> {
        TODO("Not yet implemented")
    }
}