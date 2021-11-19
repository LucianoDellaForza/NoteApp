package rs.luka.noteapp.feature_note.domain.use_cases

import rs.luka.noteapp.feature_note.domain.models.InvalidNoteException
import rs.luka.noteapp.feature_note.domain.models.Note
import rs.luka.noteapp.feature_note.domain.repositores.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty")
        }
        repository.insertNote(note)
    }
}