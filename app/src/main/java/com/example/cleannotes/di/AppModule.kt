package com.example.cleannotes.di

import android.app.Application
import androidx.room.Room
import com.example.cleannotes.feature_note.data.data_source.NoteDatabase
import com.example.cleannotes.feature_note.data.repository.NoteRepositoryImpl
import com.example.cleannotes.feature_note.domain.repository.NoteRepository
import com.example.cleannotes.feature_note.domain.use_cases.DeleteNoteUseCase
import com.example.cleannotes.feature_note.domain.use_cases.GetNotesUseCase
import com.example.cleannotes.feature_note.domain.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //NoteDatabase
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = NoteDatabase::class.java,
            name = NoteDatabase.DATABASE_NAME
        ).build()
    }

    //NoteRepository
    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(noteDao = db.noteDao)
    }

    //NoteUseCases

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository)
        )
    }
}