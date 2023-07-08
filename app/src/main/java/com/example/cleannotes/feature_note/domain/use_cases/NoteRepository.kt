package com.example.cleannotes.feature_note.domain.use_cases

import com.example.cleannotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


interface NoteRepository {
    fun getNotes(): Flow<List<Note>>


    suspend fun getNoteById(id: Int): Note?

    suspend fun inserNote(note: Note)


    suspend fun deleteNote(note: Note)
}