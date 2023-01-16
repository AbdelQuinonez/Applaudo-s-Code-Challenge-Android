package com.example.applaudoscodechallengeandroid.core

import com.example.applaudoscodechallengeandroid.ui.utils.Constants.ERROR_UNKNOWN
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.NO_ERROR_MESSAGE
import com.google.gson.annotations.SerializedName

data class ErrorModel(
    @field:SerializedName("status")
    val status: String = "",

    @field:SerializedName("message")
    override val message: String = NO_ERROR_MESSAGE,

    @field:SerializedName("Description")
    val description: String? = null,

    @field:SerializedName("Code")
    val code: String? = null,

    @field:SerializedName("ErrorType")
    val errorType: String? = null,

    ) : Throwable()


fun getErrorModel(error: Throwable): ErrorModel {
    return if (error is ErrorModel) {
        error
    } else {
        ErrorModel(ERROR_UNKNOWN)
    }
}

fun ErrorModel?.getErrorMessage() = this?.message ?: NO_ERROR_MESSAGE
