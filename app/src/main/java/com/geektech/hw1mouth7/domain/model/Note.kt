package com.geektech.hw1mouth7.domain.model

data class Note(
    val id: Int = DEFAULT_ID,
    val title: String,
    val description: String,
    val createAt: Long
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}
