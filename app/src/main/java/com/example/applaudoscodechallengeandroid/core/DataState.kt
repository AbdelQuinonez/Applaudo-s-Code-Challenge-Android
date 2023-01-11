package com.example.applaudoscodechallengeandroid.core

sealed class DataState<T> {
    data class Progress<T>(var loading: Boolean) : DataState<T>()
    data class Success<T>(var data: T) : DataState<T>()
    data class Failure<T>(val e: Throwable) : DataState<T>()
    class Done<T> : DataState<T>()

    companion object {
        fun <T> loading(isLoading: Boolean): DataState<T> = Progress(isLoading)
        fun <T> success(data: T): DataState<T> = Success(data)
        fun <T> failure(e: Throwable): DataState<T> = Failure(e)
        fun <T> done(): DataState<T> = Done()
    }
}

fun <T> DataState<T>.successOr(fallback: T): T {
    return (this as? DataState.Success<T>)?.data ?: fallback
}

fun <T> DataState<T>.successOrFailure(fallback: T): Pair<T, ErrorModel?> {
    return when (this) {
        is DataState.Failure<T> -> Pair(fallback, getErrorModel(this.e))
        is DataState.Success<T> -> Pair(this.data, null)
        else -> Pair(fallback, null)
    }
}
