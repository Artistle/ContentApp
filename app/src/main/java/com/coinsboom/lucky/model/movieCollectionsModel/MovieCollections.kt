package com.coinsboom.lucky.model.movieCollectionsModel

data class MovieCollections(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val overview: String,
    val parts: List<Part>,
    val poster_path: Any
)