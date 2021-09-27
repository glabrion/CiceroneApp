package ru.glabrion.ciceroneapp.model.network

import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
  @GET("albums")
  suspend fun getAlbums(): MutableList<Album>

  @GET("photos")
  suspend fun getPhotosByAlbumId(@Query("albumId") albumId: Int?): MutableList<Photo>
}