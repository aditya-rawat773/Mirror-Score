package com.example.mirrorscore.responses

data class PostResponse(
    val Comments: String,
    val ReponseMessage: String,
    val ResponseCode: Int,
    val Result: ResultPost
)

data class ResultPost(
        val count: Int,
        val `data`: List<Data>
)

data class Data(
        val answerCount: Int,
        val createdOn: String,
        val image: String,
        val postId: Int,
        val report: Report,
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

data class Report(
        val incorrectAnswer: Boolean,
        val incorrectQuestion: Boolean,
        val missingImage: Boolean,
        val missingOption: Boolean,
        val reportId: Int,
        val spellingMistake: Boolean
)