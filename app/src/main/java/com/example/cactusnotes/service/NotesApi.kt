package com.example.cactusnotes.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NotesApi {
    @POST("/notes")
    fun createNote(@Body note: NoteRequest): Call<NoteResponse>
}