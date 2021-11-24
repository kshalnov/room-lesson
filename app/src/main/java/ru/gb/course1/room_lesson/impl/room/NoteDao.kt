package ru.gb.course1.room_lesson.impl.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.gb.course1.room_lesson.model.NOTE_TABLE
import ru.gb.course1.room_lesson.model.NoteEntity

@Dao
interface NoteDao {
    @Insert
    fun add(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

    @Query("SELECT * FROM $NOTE_TABLE")
    fun getNotes(): List<NoteEntity>

    @Query("DELETE FROM $NOTE_TABLE")
    fun clear()
}