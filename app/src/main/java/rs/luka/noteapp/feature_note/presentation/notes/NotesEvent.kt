package rs.luka.noteapp.feature_note.presentation.notes

import rs.luka.noteapp.feature_note.domain.models.Note
import rs.luka.noteapp.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()    //order event on radio button
    data class DeleteNote(val note: Note): NotesEvent()     //delete note event
    object RestoreNote: NotesEvent()    //restore deleted note
    object ToggleOrderSection: NotesEvent() //toggle visibility of order section
}
