package ru.gb.course1.room_lesson.model

interface NoteRepo {
    // CRUD - Create Read Update Delete
    fun add(note: NoteEntity): Int
    fun getNotes(): List<NoteEntity>
    fun delete(id: Int)
}