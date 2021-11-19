package rs.luka.noteapp.feature_note.domain.use_cases

import rs.luka.noteapp.feature_note.domain.models.Note
import rs.luka.noteapp.feature_note.domain.repositores.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(noteId: Int): Note? {
        return repository.getNoteById(noteId)
    }
}