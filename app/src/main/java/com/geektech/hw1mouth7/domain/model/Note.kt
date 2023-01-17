package com.geektech.hw1mouth7.domain.model

import java.io.Serializable

data class Note(
    val id: Int = DEFAULT_ID,
    val title: String,
    val description: String,
    val createAt: Long
): Serializable {
    companion object {
        const val DEFAULT_ID = 0
    }
}
