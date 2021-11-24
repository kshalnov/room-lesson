package ru.gb.course1.room_lesson

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import ru.gb.course1.room_lesson.impl.room.NoteDao
import ru.gb.course1.room_lesson.impl.room.NoteRoomDb
import ru.gb.course1.room_lesson.impl.room.RoomNoteRepoImpl
import ru.gb.course1.room_lesson.model.NoteRepo

private const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
private const val DB_PATH = "note.db"

class App : Application() {
    private val noteDb: NoteRoomDb by lazy {
        Room.databaseBuilder(
            this,
            NoteRoomDb::class.java,
            DB_PATH
        ).build()
    }
    private val noteDao: NoteDao by lazy {
        noteDb.noteDao()
    }
    val noteRepo: NoteRepo by lazy { RoomNoteRepoImpl(noteDao) }
    val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences(
            SHARED_PREF_NAME,
            MODE_PRIVATE
        )
    }
}

val Context.app
    get() = applicationContext as App