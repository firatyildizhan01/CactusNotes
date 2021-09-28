package com.example.cactusnotes.signup

import com.example.cactusnotes.service.NoteRequest
import com.example.cactusnotes.service.NoteResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NotesApi {
    @POST("/notes")
    fun createNote(@Body note: NoteRequest): Call<NoteResponse>
}