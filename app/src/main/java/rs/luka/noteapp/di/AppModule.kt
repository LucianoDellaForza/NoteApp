package rs.luka.noteapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import rs.luka.noteapp.feature_note.data.data_source.NoteDatabase
import rs.luka.noteapp.feature_note.data.repositories.NoteRepositoryImpl
import rs.luka.noteapp.feature_note.domain.repositores.NoteRepository
import rs.luka.noteapp.feature_note.domain.use_cases.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(appContext: Application): NoteDatabase {
        return Room.databaseBuilder(
            appContext,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository = repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository = repository),
            addNoteUseCase = AddNoteUseCase(repository = repository),
            getNoteUseCase = GetNoteUseCase(repository = repository)
        )
    }
}