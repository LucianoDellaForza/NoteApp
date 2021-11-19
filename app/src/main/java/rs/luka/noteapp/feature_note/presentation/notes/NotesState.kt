package rs.luka.noteapp.feature_note.presentation.notes

import rs.luka.noteapp.feature_note.domain.models.Note
import rs.luka.noteapp.feature_note.domain.util.NoteOrder
import rs.luka.noteapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)