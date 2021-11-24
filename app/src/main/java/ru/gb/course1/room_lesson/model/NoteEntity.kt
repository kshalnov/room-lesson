package ru.gb.course1.room_lesson.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val NOTE_TABLE = "notes"
const val NOTE_COLUMN_ID = "id"
const val NOTE_COLUMN_BODY = "body"
const val NOTE_COLUMN_DONE = "done"

@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = NOTE_COLUMN_ID)
    val id: Int,
    @ColumnInfo(name = NOTE_COLUMN_BODY)
    val body: String,
    @ColumnInfo(name = NOTE_COLUMN_DONE)
    val isDone: Boolean
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}