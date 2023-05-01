package com.example.Auth.domain.repository
import com.example.Auth.domain.model.AuthResultData
import com.example.common.util.Result

internal interface AuthRepository {

    suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Result<AuthResultData>

    suspend fun signIn(
        email: String,
        password: String
    ) : Result<AuthResultData>
}