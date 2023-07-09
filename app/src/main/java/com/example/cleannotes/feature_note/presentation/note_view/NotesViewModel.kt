package com.example.cleannotes.feature_note.presentation.note_view

import androidx.lifecycle.ViewModel
import com.example.cleannotes.feature_note.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {


    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.OrderEvent -> TODO()
            is NotesEvent.RestoreNoteEvent -> TODO()
            is NotesEvent.ToggleOrderSectionEvent -> TODO()
        }
    }
}
