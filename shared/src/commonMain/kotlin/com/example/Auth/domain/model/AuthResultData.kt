package com.example.Auth.domain.model

data class AuthResultData(
    val id: Int,
    val name: String,
    val bio: String,
    val avatar: String? =null,
    val token: String,
    val followerCount: Int = 0,
    val followingCount: Int = 0,
)
