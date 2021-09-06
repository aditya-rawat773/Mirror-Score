package com.example.mirrorscore.responses

data class NewPostResponse(
    val Comments: String,
    val ReponseMessage: String,
    val ResponseCode: Int,
    val Results: Results
)
data class Results(
    val answerCount: Int,
    val createdOn: String,
    val image: String,
    val postId: Int,
    val reportCount: Int,
    val reported: Boolean,
    val studentBoard: String,
    val studentClass: String,
    val subject: String,
    val text: String,
    val updatedOn: String,
    val upvoteCount: Int,
    val upvoted: Boolean,
    val userId: Int,
    val userName: String
)