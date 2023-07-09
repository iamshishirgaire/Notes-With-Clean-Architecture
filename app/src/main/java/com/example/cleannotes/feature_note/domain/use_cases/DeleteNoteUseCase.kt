package com.example.cleannotes.feature_note.domain.use_cases

import com.example.cleannotes.feature_note.domain.model.Note
import com.example.cleannotes.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }

}