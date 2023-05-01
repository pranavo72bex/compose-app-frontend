package com.example.Auth.data

import com.example.common.data.KtorApi
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class AuthService:KtorApi() {
    suspend fun signUp(request: SignUpRequest): AuthResponse = client.post {
        endPoint(path = "signup")
        setBody(request)
    }.body()

    suspend fun signIn(request: SignInRequest) : AuthResponse = client.post {
        endPoint(path = "login")
        setBody(request)
    }.body()
}