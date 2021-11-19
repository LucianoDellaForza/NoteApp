package rs.luka.noteapp.feature_note.data.repositories

import kotlinx.coroutines.flow.Flow
import rs.luka.noteapp.feature_note.data.data_source.NoteDao
import rs.luka.noteapp.feature_note.domain.models.Note
import rs.luka.noteapp.feature_note.domain.repositores.NoteRepository

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

}