package rs.luka.noteapp.feature_note.domain.repositores

import kotlinx.coroutines.flow.Flow
import rs.luka.noteapp.feature_note.domain.models.Note

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}