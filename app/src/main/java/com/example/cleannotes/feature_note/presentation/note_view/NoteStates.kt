package com.example.cleannotes.feature_note.presentation.note_view

import com.example.cleannotes.feature_note.domain.model.Note
import com.example.cleannotes.feature_note.domain.utils.NoteOrder
import com.example.cleannotes.feature_note.domain.utils.OrderType

data class NoteStates(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false,
)
