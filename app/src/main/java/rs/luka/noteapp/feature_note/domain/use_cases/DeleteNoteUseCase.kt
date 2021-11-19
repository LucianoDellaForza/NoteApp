package rs.luka.noteapp.feature_note.domain.use_cases

import rs.luka.noteapp.feature_note.domain.models.Note
import rs.luka.noteapp.feature_note.domain.repositores.NoteRepository

class DeleteNoteUseCase(
    val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}