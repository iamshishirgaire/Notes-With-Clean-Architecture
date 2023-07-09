package com.example.cleannotes.feature_note.presentation.note_view

import com.example.cleannotes.feature_note.domain.model.Note
import com.example.cleannotes.feature_note.domain.utils.NoteOrder

sealed class NotesEvent {
    data class OrderEvent(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNoteEvent(val note: Note)

    object RestoreNoteEvent : NotesEvent()
    object ToggleOrderSectionEvent : NotesEvent()
}