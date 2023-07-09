package com.example.cleannotes.feature_note.domain.use_cases

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
)