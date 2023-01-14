package com.example.applaudoscodechallengeandroid.domain.model

enum class SortBy(val value: String) {

    TOP_RATED("Top Rated"),
    POPULAR("Popular"),
    ON_TV("On Tv"),
    AIRING("Airing Today")

}

fun getSortBy(value: String): SortBy? {
    val map = SortBy.values().associateBy(SortBy::value)
    return map[value]
}