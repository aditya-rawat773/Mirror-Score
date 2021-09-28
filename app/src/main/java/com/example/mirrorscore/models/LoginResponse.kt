package com.example.mirrorscore.models

data class LoginResponse(
    val Comments: String,
    val ResponseMessage: String,
    val ResponseCode: Int,
    val Result: Result
)

data class Result(
    val token:Token,
    val userId: Int
)

data class Token(
    val access: String,
    val refresh: String
)