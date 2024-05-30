package com.dilip.dicegame

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform