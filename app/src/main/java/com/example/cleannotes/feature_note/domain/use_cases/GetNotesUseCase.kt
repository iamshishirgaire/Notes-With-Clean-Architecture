package com.example.cleannotes.feature_note.domain.use_cases

import com.example.cleannotes.feature_note.domain.model.Note
import com.example.cleannotes.feature_note.domain.repository.NoteRepository
import com.example.cleannotes.feature_note.domain.utils.NoteOrder
import com.example.cleannotes.feature_note.domain.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val noteRepository: NoteRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(orderType = OrderType.Ascending)): Flow<List<Note>> {
        return noteRepository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }


                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }

                }

                is OrderType.Descending -> {
                    when (noteOrder) {

                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                    }
                }
            }

        }
    }

}