package com.example.Auth.data

import domain.model.AuthResultData

internal fun AuthResponseData.toAuthResultData() : AuthResultData {
    return AuthResultData(id, name, bio, avatar, token, followerCount, followingCount)
}