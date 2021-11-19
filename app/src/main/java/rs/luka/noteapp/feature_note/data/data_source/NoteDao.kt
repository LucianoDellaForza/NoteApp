package rs.luka.noteapp.feature_note.data.data_source

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import rs.luka.noteapp.feature_note.domain.models.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>    //return flow, no need? for suspend

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}