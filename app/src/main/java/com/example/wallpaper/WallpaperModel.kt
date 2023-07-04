package com.example.wallpaper

data class WallpaperModel(
	val nextPage: String? = null,
	val perPage: Int? = null,
	val page: Int? = null,
	val photos: List<PhotosItem?>? = null,
	val totalResults: Int? = null
)

data class Src(
	val small: String? = null,
	val original: String? = null,
	val large: String? = null,
	val tiny: String? = null,
	val medium: String? = null,
	val large2x: String? = null,
	val portrait: String? = null,
	val landscape: String? = null
)

data class PhotosItem(
	val src: Src? = null,
	val width: Int? = null,
	val avgColor: String? = null,
	val alt: String? = null,
	val photographer: String? = null,
	val photographerUrl: String? = null,
	val id: Int? = null,
	val url: String? = null,
	val photographerId: Int? = null,
	val liked: Boolean? = null,
	val height: Int? = null
)

