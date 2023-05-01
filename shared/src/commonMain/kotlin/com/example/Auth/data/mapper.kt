package com.example.Auth.data

import com.example.Auth.domain.model.AuthResultData

internal fun AuthResponseData.toAuthResultData() : AuthResultData{
    return AuthResultData(id, name, bio, avatar, token, followerCount, followingCount)
}