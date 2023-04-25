package com.example.socialmedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform