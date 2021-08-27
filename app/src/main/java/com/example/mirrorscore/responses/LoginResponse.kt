package com.example.mirrorscore.responses

data class LoginResponse(
    val Comments: String,
    val ReponseMessage: String,
    val ResponseCode: Int,
    val Result: Result
)

data class Result(
    val token: Token,
    val userId: Int
)

data class Token(
    val access: String,
    val refresh: String
)