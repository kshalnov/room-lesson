package ru.gb.course1.room_lesson.impl.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.gb.course1.room_lesson.model.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteRoomDb: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}